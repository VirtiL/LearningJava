package com.virtil.mq.msgmq.apidemo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-8-3 16:28
 * @Version 1.0
 */
public class Setter {



    public static void main(String[] args) {

        //配置工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Config.HOST);
        factory.setPort(Config.PORT);
        factory.setUsername(Config.USERNAME);
        factory.setPassword(Config.PASSWORD);

        try {
            //生产一个连接
            Connection connection = factory.newConnection();
            //创建一个信道
            Channel channel = connection.createChannel();

            //发送消息
            String msg = "hello!";
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().contentEncoding("UTF-8")
//            //持久化消息       //设置过期时间    //优先级,默认就是5
            .deliveryMode(2).expiration("5000").priority(5).build();
            //String exchange, String routingKey, boolean mandatory, boolean immediate, BasicProperties props, byte[] body
            //当mandatory为true时，如果exchange根据自身类型和消息routingKey无法找到一个合适的queue存储消息，
            // 那么broker会调用basic.return方法将消息返还给生产者;当mandatory设置为false时，出现上述情况broker会直接将消息丢弃;
            // 通俗的讲，mandatory标志告诉broker代理服务器至少将消息route到一个队列中，否则就将消息return给发送者;
//            channel.basicPublish(Config.DIRECT_EXCHANGE,Config.DIRECT_ROUTING_KEY,true,properties,msg.getBytes());

            channel.basicPublish(Config.DIRECT_EXCHANGE,Config.DIRECT_ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN,msg.getBytes());
            System.out.println("发送一条消息:"+msg);
            //关闭信道
            channel.close();
            //关闭连接
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

}