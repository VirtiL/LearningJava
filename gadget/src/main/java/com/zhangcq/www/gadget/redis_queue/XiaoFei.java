package com.zhangcq.www.gadget.redis_queue;

import redis.clients.jedis.Jedis;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-26 17:41
 * @Version 1.0
 */
public class XiaoFei extends Thread{

    @Override
    public void run() {
        Jedis jedis = OneJedis.getJedis();
        while (true){
            try {
                Thread.sleep((long) (Math.random()*1000));
                StringBuffer sb = new StringBuffer();
                String lpop = jedis.blpop(2,"list").toString();
                System.out.println(lpop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}