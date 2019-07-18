package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-15 13:12
 * @Version 1.0
 */
public class RedisManager {


    private static JedisPool jedisPool;

    static{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大等待时间
        jedisPoolConfig.setMaxWaitMillis(5000);
        //最大连接数
        jedisPoolConfig.setMaxTotal(20);
        //最小空间连接数
        jedisPoolConfig.setMinIdle(2);
        //最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);
        jedisPool = new JedisPool(jedisPoolConfig, "192.168.0.50", 6379);

    }



    public static Jedis getJedis() throws Exception {
        if(null != jedisPool){
            return jedisPool.getResource();
        }
        throw new Exception("get jedis exception!");
    }







}