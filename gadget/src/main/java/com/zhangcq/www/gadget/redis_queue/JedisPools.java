package com.zhangcq.www.gadget.redis_queue;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description:
 *
 * maxIdle，最大空闲数，数据库连接的最大空闲时间。超过空闲时间，数据库连
接将被标记为不可用，然后被释放。设为0表示无限制。
MaxActive，连接池的最大数据库连接数。设为0表示无限制。
maxWait ，最大建立连接等待时间。如果超过此时间将接到异常。设为-1表示
无限制。
 *maxActive:最大连接数据库连接数,设 0 为没有限制
 *maxIdle:最大等待连接中的数量,设 0 为没有限制
 *maxWait:最大等待毫秒数, 单位为 ms, 超过时间会出错误信息

一般把maxActive设置成可能的并发量就行了
    ###jedispoolconfig### 

    #jedis的最大分配对象# 
    jedis.pool.maxActive=1024 

    #jedis最大保存idel状态对象数 # 
    jedis.pool.maxIdle=200 

    #jedis池没有对象返回时，最大等待时间 # 
    jedis.pool.maxWait=1000 

    #jedis调用borrowObject方法时，是否进行有效检查# 
    jedis.pool.testOnBorrow=true 

    #jedis调用returnObject方法时，是否进行有效检查 # 
    jedis.pool.testOnReturn=true

 * @author: zhangcq
 * @Time: 2019-6-27 13:40
 * @Version 1.0
 */
public class JedisPools {

    private static JedisPool pool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大闲置连接数
        jedisPoolConfig.setMaxIdle(30);
        //最小闲置连接数
        jedisPoolConfig.setMinIdle(10);
        //最大连接数
        jedisPoolConfig.setMaxTotal(35);
        //最大等待时间
        jedisPoolConfig.setMaxWaitMillis(1000);
        pool = new JedisPool(jedisPoolConfig,"192.168.50.50",6379);

    }


    private JedisPools(){}

    public static Jedis getJedis(){
        Jedis redis = pool.getResource();
        redis.auth("redis");
        return redis;
    }

}