package com.zhangcq.www.gadget.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-28 13:09
 * @Version 1.0
 */
public class LRU<K,V> extends LinkedHashMap<K,V> {

    //空间大小
    private final int SIZE;


    public LRU(int size){
        //将accessOrder设置为true,按访问顺序遍历
        super(size,0.75f,true);
        SIZE = size;
    }

    /**
     * 重写删除
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //如果容量大于设置的空间大小就删
        return size() > this.SIZE;
    }
}