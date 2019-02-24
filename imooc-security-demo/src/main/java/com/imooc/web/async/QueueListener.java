package com.imooc.web.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            for (; ; ) {
                String orderNumber = mockQueue.getCompleteOrder();
                if (StringUtils.isNotBlank(orderNumber) && deferredResultHolder.getMap().get(orderNumber) != null) {
                    log.info("返回订单处理结果：" + orderNumber);
                    // 返回给浏览器调用消息
                    deferredResultHolder.getMap().get(orderNumber).setResult(orderNumber + "订单处理成功！");
                    // 虚拟MQ字段置空
                    mockQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("监听器一直在运行着……");
                }
            }
        }).start();

    }
}
