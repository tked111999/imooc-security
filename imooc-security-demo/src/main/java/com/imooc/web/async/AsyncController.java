package com.imooc.web.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@Slf4j
@RestController
@RequestMapping("/order")
public class AsyncController {

    @RequestMapping("sync")
    public String syncOrder() {
        log.info("主线程开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("主线程返回");
        return "success";
    }

    @RequestMapping("async1")
    public Callable<String> asyncOrder1() {
        log.info("主线程开始");
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("异步请求开始");
                Thread.sleep(1000);
                log.info("异步请求返回");
                return "success";
            }
        };
        log.info("主线程返回");
        return callable;
    }

}
