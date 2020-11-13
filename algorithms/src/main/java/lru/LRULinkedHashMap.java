package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-22 10:40
 * @Version 1.0
 */
public class LRULinkedHashMap extends LinkedHashMap{

    public final int size;

    /**
     * 设置缓存容纳量
     */
    public LRULinkedHashMap(int initialCapacity) {
        // true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        super((int) Math.ceil(initialCapacity / 0.75) + 1, 0.75f, true);
        size = initialCapacity;
    }

    /**
     *
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        // 当 map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > size;
    }
}