package com.virtil.juc.basic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-9-7 15:44
 */
public class Interrupt {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    return;
                }else{
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(1111);
                }

            }
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}