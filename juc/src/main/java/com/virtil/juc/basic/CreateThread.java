package com.virtil.juc.basic;

/**
 * @Description: 创建线程的三种方式:
 * 1:  继承Thread
 * 2:  实现Runnable
 * 3:  线程池创建(内部还是用的上边两种方式)
 * @Author: zhangcq
 * @Time: 2020-9-2 15:40
 */
public class CreateThread {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i = i + 1) {
                System.out.println("Thread");
            }
        });


        Runnable t2 = () -> {
            for (int i = 0; i < 10; i = i + 1) {
                System.out.println("Runnable");
            }
        };
        t1.start();
        new Thread(t2).start();
        for (int i = 0; i < 10; i = i + 1) {
            System.out.println("main");
        }

    }


}