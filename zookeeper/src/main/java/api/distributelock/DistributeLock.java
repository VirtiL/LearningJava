package api.distributelock;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 分布式锁的实现
 * @author: zhangcq
 * @Time: 2019-7-1 14:43
 * @Version 1.0
 */
public class DistributeLock {

    /**
     * 指定一个命名空间,也就是根节点,锁所在地
     */
    private static final String NAMESPACE_ROOT="/LOCKS";

    /**
     * zk的实例
     */
    private ZooKeeper zookeeper;

    /**
     * 超时时间
     */
    private int sessionTimeOut;

    /**
     * 锁节点名
     */
    private String nodeName;


    /**
     * 节点数据
     */
    private final static byte[] NODE_DATA = {1,2};

    /**
     * 更换锁的基计时器
     */
    private CountDownLatch countDownLatch = new CountDownLatch(1);


    public DistributeLock() throws IOException, InterruptedException {
       this.zookeeper = ZkClient.getInstance();
       this.sessionTimeOut = ZkClient.getSessionTimeOut();
    }

    /**
     * 获取锁,也就是创建znode
     * @return
     */
    public boolean lock(){
        try {
            //临时有序节点-EPHEMERAL_SEQUENTIAL
            nodeName = zookeeper.create(NAMESPACE_ROOT + "/", NODE_DATA, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println(Thread.currentThread().getName()+"创建了lock节点,节点名为="+nodeName+" 开始去竞争锁!");

            //判断当前线程或进程是否可以获取锁
            //获取命名空间下的所有子节点
            List<String> children = zookeeper.getChildren(NAMESPACE_ROOT, true);
            //节点倒序,从小到大
            SortedSet<String> sorted = new TreeSet<String>();
            for (String child : children) {
                sorted.add(NAMESPACE_ROOT+"/"+child);
            }

            //获取最小节点,也就是当前锁
            if(nodeName.equals(sorted.first())){
                //表示当前是最小节点,则代表可以获得锁
                System.out.println(Thread.currentThread().getName()+"获得了锁,lock节点是="+nodeName);
                return true;
            }

            //获取比nodeName大的节点,从小到大
            SortedSet<String> lessThanNodeName = sorted.headSet(nodeName);
            if(!lessThanNodeName.isEmpty()){
                //拿到nodeName上一个节点
                String prevNodeName = lessThanNodeName.last();
                //然后监控上一个节点,也就是当nodeName失效以后,上一个节点就要得到锁了
                zookeeper.exists(prevNodeName,new LockWacther(countDownLatch));
                //如果会话超时,或者节点被删除时,就可以继续获取锁了
                countDownLatch.await(sessionTimeOut, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() +"成功获取了锁,lock节点是"+nodeName);
                return true;
            }


        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return false;
    }

    /**
     * 释放锁
     * @return
     */
    public boolean unlock(){
        System.out.println(Thread.currentThread().getName()+"开始释放锁,lock节点是"+nodeName);
        try {
            System.out.println(nodeName+"节点被删除,锁成功释放!");
            zookeeper.delete(nodeName,-1);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

        return false;
    }


}