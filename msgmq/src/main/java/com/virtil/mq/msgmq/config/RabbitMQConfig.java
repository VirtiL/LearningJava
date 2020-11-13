package com.virtil.mq.msgmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-8-3 14:00
 * @Version 1.0
 */
@Configuration
public class RabbitMQConfig {


    @Value("${spring.rabbitmq.direct.exchange}")
    private String rabbitmqexchangekey;

    @Value("${spring.rabbitmq.direct.queue}")
    private String rabbitmqqueuekey;

    @Value("${spring.rabbitmq.direct.routingkey}")
    private String rabbitmqroutingkey;



    //定义直连交换机
    @Bean
    public DirectExchange getDirectExchange(){
        return new DirectExchange(rabbitmqexchangekey);
    }

    //定义队列
    @Bean
    public Queue getQueue(){
        return new Queue(rabbitmqqueuekey);
    }

    //绑定关系
    @Bean
    public Binding getBinding(@Qualifier("getDirectExchange") DirectExchange directExchange,
                              @Qualifier("getQueue") Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with(rabbitmqroutingkey);
    }





}