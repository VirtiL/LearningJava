//package redis;
//
//import java.util.Collections;
//
///**
// * @Description:
// * @Author: zhangcq
// * @Time: 2019-10-30 14:40
// */
//public class RedisTemplate {
//
//    /**
//     * 获取锁
//     * @param txNo
//     * @param lockKey
//     * @param value
//     * @param expireTime：单位-秒
//     * @return
//     */
//    public boolean lock(String txNo, String lockKey, String value, int expireTime) throws Exception{
//        if(log.isInfoEnabled()){
//            log.info(" --  lock params txNo:{} lockKey:{} value:{} expireTime:{}", txNo, lockKey, value,expireTime);
//        }
//        String script = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";
//        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
//        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey),value,expireTime);
//        if(LOCK_SUCCESS.equals(result)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    /**
//     * 释放锁
//     * @param txNo
//     * @param lockKey
//     * @param value
//     * @return
//     */
//    public boolean unlock(String txNo, String lockKey, String value){
//        if(log.isInfoEnabled()){
//            log.info(" --  unlock params txNo:{} lockKey:{} value:{}", txNo, lockKey, value);
//        }
//        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
//        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey),value);
//        if(LOCK_SUCCESS.equals(result)) {
//            return true;
//        }
//        return false;
//    }
//}