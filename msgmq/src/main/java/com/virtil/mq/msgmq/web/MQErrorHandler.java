package com.virtil.mq.msgmq.web;

import org.springframework.util.ErrorHandler;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-8-5 16:36
 * @Version 1.0
 */
public class MQErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable throwable) {
        System.out.println("错误"+throwable);

    }
}