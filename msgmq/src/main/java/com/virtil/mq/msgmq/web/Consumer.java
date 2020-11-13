package com.virtil.mq.msgmq.web;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-8-3 23:14
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "springboot:direct:queue")
public class Consumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println(msg);
    }

}