package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-15 13:18
 * @Version 1.0
 */
public class RedisLock {


    /**
     * 获得锁
     * @return
     */
    public String lock(String key,int timeout){
        try {
            Jedis jedis = RedisManager.getJedis();
            String lock = UUID.randomUUID().toString();
            //设置一个获取锁的超时时间,如果超过这个时间没获取到锁,可以返回一个系统繁忙的提示
            long trueTime = System.currentTimeMillis() + timeout;
            //模拟阻塞
            while (trueTime > System.currentTimeMillis()){
                //setnx不是阻塞操作,只有在 key 不存在时设置 key 的值。EX是秒,PX是毫秒 NX只有键key不存在的时候才会设置key的值 XX – 只有键key存在的时候才会设置key的值
                String set = jedis.set(key, lock, "NX", "PX", 1000);
                if("OK".equals(set)){
                    System.out.println(Thread.currentThread().getName()+"->加锁成功!");
                    return lock;
                }
                Thread.sleep(1000);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 释放锁
     * @return
     */
    public boolean unlock(String key,String value){
        try {
            Jedis jedis = RedisManager.getJedis();
            while (true){
                //监控一个或者多个key,一旦监控的被删除,这个事务就会失败
                jedis.watch(key);
                if(value.equalsIgnoreCase(jedis.get(key))){
                    Transaction multi = jedis.multi();
                    multi.del(key);
                    List<Object> list = multi.exec();
                    if(null == list){
                        continue;
                    }
                }
                jedis.unwatch();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        RedisLock redisLock = new RedisLock();
        String lock = redisLock.lock("redis:lock", 2000);
        if(null != lock){
            System.out.println("获取锁成功!");
        }else{
            System.out.println("获取锁失败!");
        }
        String lock2 = redisLock.lock("redis:lock", 2000);
        if(null != lock2){
            System.out.println("获取锁成功!");
        }else{
            System.out.println("获取锁失败!");
        }

    }


}