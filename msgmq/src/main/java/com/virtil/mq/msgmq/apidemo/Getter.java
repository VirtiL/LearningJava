package com.virtil.mq.msgmq.apidemo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-8-3 16:28
 * @Version 1.0
 */
public class Getter {

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
            //也就是说目前最多处理64条没返回ack的消息,如果返回ack了,就继续接收
            channel.basicQos(64);

            //申请一个直连(direct),持久化的,非自动删除的交换机
            //String exchange , String type , boolean durable , boolean autoDelete , Map<String, Object> arguments
            //交换机名,交换机类型,是否持久化,交换机不再被使用的时候是否自动删除,其他参数
            channel.exchangeDeclare(Config.DIRECT_EXCHANGE,"direct",true,false,null);
            //当消息不能被交换机路由到队列上的时候,可以通过ReturnListener去处理这些消息,也可以为信道指定一个备份交换机,让没有被路由到的消息转发给备份交换机去处理
//            HashMap<String, Object> changes = new HashMap<>();
//            changes.put("alternate-exchage","备份交换机名");
//            channel.exchangeDeclare(Config.DIRECT_EXCHANGE,"direct",true,false,changes);

            HashMap<String, Object> map = new HashMap<>();
            //单位ms,整个队列在5秒以后进入死信队列,如果队列和消息都设置了过期时间,那个数小就以哪个为准
//            map.put("x-message-ttl",5000);
//          //这个队列最多存放多少条消息,超过了会删除最先入队的消息
//            map.put("x-max-length",10);
//          //这个队列最多存放多少字节的数据,超过了会删除最先入队的消息
//            map.put("x-max-length-bytes",1000);
//          //指定这个队列的死信交换机
//            map.put("x-dead-letter-exchange","死信交换机");

            //申请一个持久化的,非排他的,非自动删除的队列,排他性指的是不同连接不可见,同一连接中的不同信道是可见的
            //String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
            //队列名,是否持久化,是否具有排他性指的是不同连接是否可见,队列不再被使用的时候是否自动删除,其他参数
            channel.queueDeclare(Config.DIRECT_QUEUE,true,false,false,map);

            //通过路由键绑定交换机和队列
            channel.queueBind(Config.DIRECT_QUEUE,Config.DIRECT_EXCHANGE,Config.DIRECT_ROUTING_KEY);

            //创建一个消费者
            DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("消费一条消息:"+new String(body));
                    try {
                        //睡一秒
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            };
            channel.basicConsume(Config.DIRECT_QUEUE,defaultConsumer);

            try {
                //睡一会等回调处理完
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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