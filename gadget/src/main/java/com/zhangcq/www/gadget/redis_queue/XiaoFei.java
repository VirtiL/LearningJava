package com.zhangcq.www.gadget.redis_queue;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-26 17:41
 * @Version 1.0
 */
public class XiaoFei extends Thread{

    @Override
    public void run() {
        Jedis jedis = JedisPools.getJedis();
        while (true){
            try {
                Thread.sleep((long) (Math.random()*1000));
                List<String> list = jedis.brpop(0, "list");
                System.out.println(Thread.currentThread().getName()+"消费的"+list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}