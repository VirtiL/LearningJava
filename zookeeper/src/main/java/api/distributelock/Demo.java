package api.distributelock;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: 简单实现,多实例
 * @author: zhangcq
 * @Time: 2019-7-1 15:21
 * @Version 1.0
 */
public class Demo {


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i< 10; i++){
            new Thread(()->{
                DistributeLock distributeLock = null;
                try {
                    distributeLock = new DistributeLock();
                    countDownLatch.countDown();
                    countDownLatch.await();
                    distributeLock.lock();
                    Thread.sleep(500);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(distributeLock != null){
                        distributeLock.unlock();
                    }
                }
            }).start();
        }
    }


}