package com.virtil.juc.basic;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 *  线程睡眠
 *      让当前线程进入睡眠状态,不释放锁,等时间到了自动唤起
 * @Author: zhangcq
 * @Time: 2020-9-2 15:40
 */
public class Sleep {


    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i = i + 1) {
                System.out.println("Thread");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        for (int i = 0; i < 10; i = i + 1) {
            System.out.println("main");
        }
    }


}