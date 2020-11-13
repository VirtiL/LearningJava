package com.virtil.mq.msgmq.web;

import com.rabbitmq.client.Return;
import com.rabbitmq.client.ReturnCallback;

/**
 * @Description:    Exchange无法将消息路由到任何队列时会被调用
 * @author: zhangcq
 * @Time: 2019-8-5 16:22
 * @Version 1.0
 */
public class ReturnHandler implements ReturnCallback{
    @Override
    public void handle(Return aReturn) {
        System.out.println("进入错误处理!");

    }
}