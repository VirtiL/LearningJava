package com.virtil.lock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-9-3 14:22
 */
public class Test {


    /**
     * java.lang.Object object internals:
     * OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     * 0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     * 4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     * 8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
     * 12     4        (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     */
    public static void main(String[] args) {
//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        AAA a = new AAA();
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a){
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }


}