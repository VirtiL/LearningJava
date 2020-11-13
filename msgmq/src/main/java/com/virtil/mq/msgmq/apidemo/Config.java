package com.virtil.mq.msgmq.apidemo;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-8-3 18:50
 * @Version 1.0
 */
public class Config {

    public static final String HOST = "192.168.2.80";
    public static final Integer PORT = 5672;
    public static final String USERNAME = "rabbitmq";
    public static final String PASSWORD = "123456";
    //直连交换机
    public static final String DIRECT_EXCHANGE = "direct:exchange";
    //直连队列
    public static final String DIRECT_QUEUE = "direct:queue";
    //直连路由键
    public static final String DIRECT_ROUTING_KEY="direct:routing:key";
}