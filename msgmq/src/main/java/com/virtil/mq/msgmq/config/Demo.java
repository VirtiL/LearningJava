package com.virtil.mq.msgmq.config;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-8-5 21:07
 * @Version 1.0
 */
public class Demo {

    public static volatile Demo demo;

    public Demo() {
    }


    public static Demo getDemo() {
        if(demo == null){
            synchronized (Demo.class){
                if (demo == null){
                    demo = new Demo();
                }
            }
        }
        return demo;
    }
}