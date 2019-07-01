package api.distributelock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 *
 * 分布式锁实现方式:
 * 环境:N个进程(线程)去同时并发访问
 * 实现方式:利用zookeeper的文件系统和wathcher机制还有计时器来实现
 * 原理:
 *      1.在文件系统中设置一个/locks命名空间
 *      2.假设客户端在该命名空间下创建znode,这个节点是临时有序节点
 *      3.并发获取锁时,判断当前进程或线程所持有的的节点id是否是有序znode中最小的,如果是,则获取锁,并监听是否超时和下一个锁
 *      4.当上一个进程或线程释放了锁,则其他客户端根据3的步骤去竞争释放锁-1的节点锁,以此类推完成有序操作,也就是分布式锁
 *
 *
 *
 *
 * @author: zhangcq
 * @Time: 2019-7-1 13:54
 * @Version 1.0
 */
public class ZkClient {

    //集群地址
    private static final String CONNECTSTRING = "192.168.0.201:2181,192.168.0.202:2181,192.168.0.203:2181,192.168.0.204:2181";

    private static final int sessionTimeOut=5000;


    /**
     * 获取zk实例
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static ZooKeeper getInstance() throws IOException, InterruptedException {
        //计数器,并发包的东西,当计数器为0是再执行主线程
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(CONNECTSTRING, sessionTimeOut, new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {
            //保证是链接状态
            if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                countDownLatch.countDown();
            }
        }
        });
        countDownLatch.await();
        return zooKeeper;
    }

    public static int getSessionTimeOut(){
        return sessionTimeOut;
    }








}