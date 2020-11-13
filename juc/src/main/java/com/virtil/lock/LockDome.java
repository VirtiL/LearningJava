package com.virtil.lock;

import com.sun.org.apache.bcel.internal.generic.*;
import org.openjdk.jol.info.ClassLayout;

import java.io.PrintStream;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-9-3 17:37
 */
public class LockDome {

    public static void main(String[] args) {
        AAA aaa = new AAA();
        synchronized (aaa){
            System.out.println(ClassLayout.parseInstance(aaa).toPrintable());
        }
    }



}