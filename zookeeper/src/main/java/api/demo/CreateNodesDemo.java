package api.demo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-29 21:59
 * @Version 1.0
 */
public class CreateNodesDemo {

    //集群地址
    private static final String CONNECTSTRING = "192.168.0.201:2181,192.168.0.202:2181,192.168.0.203:2181,192.168.0.204:2181";

    //计数器,并发包的东西,当计数器为0是再执行主线程
    private static CountDownLatch countDownLatch = new CountDownLatch(1);


    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        //参数:集群地址,session过期时间,Watcher
        //会话状态:未连接(not-connected)-连接中(connecting)-已连接(connected)-已关闭(close)
//        Watcher状态:
//            None(-1),
//            NodeCreated(1),
//            NodeDeleted(2),
//            NodeDataChanged(3),
//            NodeChildrenChanged(4);

//        KeeperState状态:
    //        Disconnected(0),
    //        NoSyncConnected(1),
    //        SyncConnected(3),
    //        AuthFailed(4),
    //        ConnectedReadOnly(5),
    //        SaslAuthenticated(6),
    //        Expired(-112);
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


        //创建节点
//        ACL选择：
        //OPEN_ACL_UNSAFE  : 完全开放的ACL，任何连接的客户端都可以操作该属性znode
        //CREATOR_ALL_ACL : 只有创建者才有ACL权限
        //READ_ACL_UNSAFE：只能读取ACL
//        ANYONE_ID_UNSAFE:ID代表任何人
//                AUTH_IDS:可以设置ACL,代替了已经认证过客户端的IDs
        //CreateMode状态：
//        PERSISTENT(0, false, false),//持久化节点
//        PERSISTENT_SEQUENTIAL(2, false, true),//持久化有序节点
//        EPHEMERAL(1, true, false),//临时节点
//        EPHEMERAL_SEQUENTIAL(3, true, true);//临时有序节点
        String node_name = zooKeeper.create("/node1", "create".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(node_name);


    }
}