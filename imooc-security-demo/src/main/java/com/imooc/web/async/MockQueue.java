package com.imooc.web.async;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class MockQueue {
    private String placeOrder;
    private String completeOrder;

    /**
     * 模拟MQ下单请求
     * @param placeOrder
     */
    public void setPlaceOrder(String placeOrder) throws Exception {
        log.info("接到下单请求：" + placeOrder);
        Thread.sleep(1000);
        this.completeOrder = placeOrder;
        log.info("下单处理完毕：" + placeOrder);
    }
}
