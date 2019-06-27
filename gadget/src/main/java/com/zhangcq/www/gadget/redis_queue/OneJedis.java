package com.zhangcq.www.gadget.redis_queue;

import redis.clients.jedis.Jedis;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-26 17:21
 * @Version 1.0
 */
public class OneJedis {

    private static volatile Jedis jedis;

    private OneJedis(){}

    public static Jedis getJedis(){
        if(jedis == null){
            synchronized (OneJedis.class){
                if(jedis == null){
                    jedis = new Jedis("192.168.50.50",6379);
                    jedis.auth("redis");
                }
            }

        }
        return jedis;
    }

}