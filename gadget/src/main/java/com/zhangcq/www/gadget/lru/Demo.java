package com.zhangcq.www.gadget.lru;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-28 13:09
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {

        LRU<String, String> lru = new LRU<>(6);
        //先缓存一下东西,装满了就该LRU了
        lru.put("aa","aa");
        lru.put("bb","bb");
        lru.put("cc","cc");
        lru.put("dd","dd");
        lru.put("ee","ee");
        lru.put("ff","ff");
        //访问一下aa
        System.out.println(lru.get("aa"));
        //访问一下cc
        System.out.println(lru.get("cc"));
        //再放进去一个gg
        lru.put("gg","gg");
        //然后看结果 {dd=dd, ee=ee, ff=ff, aa=aa, cc=cc, gg=gg}
        System.out.println(lru);

    }
}