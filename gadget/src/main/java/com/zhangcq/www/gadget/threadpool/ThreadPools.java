package com.zhangcq.www.gadget.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2019-11-20 14:57
 */
public class ThreadPools {

    public static ThreadFactory nametfs = new ThreadFactoryBuilder().setNameFormat("pool-virtil-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(5, 100,
            5000000L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(100), nametfs, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            pool.execute(new TestThread());
        }
        pool.shutdown();
    }
}