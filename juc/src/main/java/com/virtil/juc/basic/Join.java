package com.virtil.juc.basic;

/**
 * @Description:
 *  在当前线程执行过程中加入其他线程,等加入的线程执行完再执行本线程,可以实现顺序执行
 * @Author: zhangcq
 * @Time: 2020-9-2 15:56
 */
public class Join {
    public static void main(String[] args) {
        Thread thread2 = new Thread(() -> {
            for (int i = 101; i < 150; i = i + 1) {
                System.out.println(i);
            }
        });
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i = i + 1) {
                System.out.println(i);
                if(i == 50){
                    try {
                        thread2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread2.start();
    }
}