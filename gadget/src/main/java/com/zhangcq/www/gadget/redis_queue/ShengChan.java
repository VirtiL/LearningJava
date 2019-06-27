package com.zhangcq.www.gadget.redis_queue;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-26 17:41
 * @Version 1.0
 */
public class ShengChan extends Thread{

    @Override
    public void run() {
        Jedis jedis = OneJedis.getJedis();
        while (true){
            try {
                Thread.sleep((long) (Math.random()*1000));
                UUID uuid = UUID.randomUUID();
                jedis.lpush("list","插入的"+uuid.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}