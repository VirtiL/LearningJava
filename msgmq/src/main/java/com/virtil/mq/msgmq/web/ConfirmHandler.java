package com.virtil.mq.msgmq.web;

import com.rabbitmq.client.ConfirmCallback;

import java.io.IOException;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-8-5 16:32
 * @Version 1.0
 */
public class ConfirmHandler implements ConfirmCallback{
    @Override
    public void handle(long l, boolean b) throws IOException {
        System.out.println(l+"-->"+b);
    }
}