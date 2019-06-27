package com.zhangcq.www.gadget.localCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 本地缓存器
 * @author: 张超群
 * @Time: 2018/11/12 16:52
 * @Version 1.0
 */
public class LocalCache {
    /**
     * 缓存Map
     */
    private static Map<String, CacheContent> map = new ConcurrentHashMap<>();
    private static  LocalCache localCache = new LocalCache();

    private LocalCache(){
    }

    public  String getLocalCache(String key) {
        CacheContent cc = map.get(key);

        if(null == cc) {
            return null;
        }

        long currentTime = System.currentTimeMillis();

        if(cc.getCacheMillis() > 0 && currentTime - cc.getCreateTime() > cc.getCacheMillis()) {
            //超过缓存过期时间,返回null
            map.remove(key);
            return null;
        } else {
            return cc.getElement();
        }
    }

    public void setLocalCache(String key,int cacheMillis,String value) {
        long currentTime = System.currentTimeMillis();
        CacheContent cc = new CacheContent(cacheMillis,value,currentTime);
        map.put(key,cc);
    }

    public static LocalCache getInStance(){
        return localCache;
    }

    class CacheContent{
        /**
         * 缓存生效时间
         */
        private  int cacheMillis;
        /**
         * 缓存对象
         */
        private String element;
        /**
         * 缓存创建时间
         */
        private long createTime;

        public CacheContent(int cacheMillis, String element, long createTime) {
            this.cacheMillis = cacheMillis;
            this.element = element;
            this.createTime = createTime;
        }

        public int getCacheMillis() {
            return cacheMillis;
        }

        public void setCacheMillis(int cacheMillis) {
            this.cacheMillis = cacheMillis;
        }

        public String getElement() {
            return element;
        }

        public void setElement(String element) {
            this.element = element;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }


    public static void main(String[] args) {
        //先查询本地缓存
        String key ="testkey";
        LocalCache localCache = LocalCache.getInStance();
        String value = localCache.getLocalCache(key);
        if(isBlank(value)) {
            //从db或cache获取数据
            value = "1111";
            //设置本地缓存,生效时间为10秒
            localCache.setLocalCache(key ,10000,value);
        }
        System.out.println(localCache.getLocalCache(key));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(localCache.getLocalCache(key));
    }
}