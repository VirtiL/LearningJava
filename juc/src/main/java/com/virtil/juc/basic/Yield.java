package com.virtil.juc.basic;

/**
 * @Description:
 *  线程让出当前CPU资源给其他线程,自己重新进入等待队列,变成就绪状态
 * @Author: zhangcq
 * @Time: 2020-9-2 15:51
 */
public class Yield {


    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i = i + 1) {
                System.out.println(i);
                Thread.yield();
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i = i + 1) {
                System.out.println(200 + i);
            }
        });
        thread2.start();
    }
}