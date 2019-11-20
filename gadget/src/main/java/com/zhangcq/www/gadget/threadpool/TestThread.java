package com.zhangcq.www.gadget.threadpool;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2019-11-20 15:16
 */
public class TestThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}