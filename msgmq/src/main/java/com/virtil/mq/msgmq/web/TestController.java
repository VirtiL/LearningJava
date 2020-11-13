package com.virtil.mq.msgmq.web;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-8-3 16:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/mq/")
public class TestController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;


    @GetMapping("set")
    public String setmsg(String msg){
        rabbitTemplate.convertAndSend("springboot:direct:exchange","springboot:direct:routingkey",msg);
        return "";
    }

}