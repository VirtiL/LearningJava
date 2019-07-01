package api.demo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-29 21:43
 * @Version 1.0
 */
public class CreateSessionDemo {

    //集群地址
    private static final String CONNECTSTRING = "192.168.0.201:2181,192.168.0.202:2181,192.168.0.203:2181,192.168.0.204:2181";

    //计数器,并发包的东西,当计数器为0是再执行主线程
    private static CountDownLatch countDownLatch = new CountDownLatch(1);


    public static void main(String[] args) throws IOException, InterruptedException {
        //参数:集群地址,session过期时间,Watcher
        //会话状态:未连接(not-connected)-连接中(connecting)-已连接(connected)-已关闭(close)
        ZooKeeper zooKeeper = new ZooKeeper(CONNECTSTRING,5000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
                    countDownLatch.countDown();
                    System.out.println("watchedEvent: "+watchedEvent.getState());
                }
            }
        });
        countDownLatch.await();
        System.out.println("end: "+zooKeeper.getState());
    }

}