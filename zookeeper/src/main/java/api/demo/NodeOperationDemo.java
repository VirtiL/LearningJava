package api.demo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: 节点操作
 * @author: zhangcq
 * @Time: 2019-6-30 14:06
 * @Version 1.0
 */
public class NodeOperationDemo implements Watcher{

    //集群地址
    private static final String CONNECTSTRING = "192.168.0.201:2181,192.168.0.202:2181,192.168.0.203:2181,192.168.0.204:2181";

    //计数器,并发包的东西,当计数器为0是再执行主线程
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper;

    private static Stat stat = new Stat();

//    ACL选择：
//      OPEN_ACL_UNSAFE  : 完全开放的ACL，任何连接的客户端都可以操作该属性znode
//      CREATOR_ALL_ACL : 只有创建者才有ACL权限
//      READ_ACL_UNSAFE：只能读取ACL
//      ANYONE_ID_UNSAFE:ID代表任何人
//      AUTH_IDS:可以设置ACL,代替了已经认证过客户端的IDs

//    CreateMode状态：
//        PERSISTENT(0, false, false),//持久化节点
//        PERSISTENT_SEQUENTIAL(2, false, true),//持久化有序节点
//        EPHEMERAL(1, true, false),//临时节点,临时节点不能创建子节点
//        EPHEMERAL_SEQUENTIAL(3, true, true);//临时有序节点
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper(CONNECTSTRING,5000, new NodeOperationDemo());
        countDownLatch.await();
//        //增
//        zooKeeper.create("/nodes","nodes".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
//        //查
//        zooKeeper.getData("/nodes", new NodeOperationDemo(), stat);
//        TimeUnit.SECONDS.sleep(2);
//
//        //改
//        zooKeeper.setData("/nodes","nodes111".getBytes(),-1);
//        //查
//        zooKeeper.getData("/nodes",true,stat);
//        TimeUnit.SECONDS.sleep(2);
//
//        //创建子节点
//        if(zooKeeper.exists("/nodes",true) == null){
//            zooKeeper.create("/nodes/node1","node-1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
//            //查
//            zooKeeper.getData("/nodes/node1",true,stat);
//            TimeUnit.SECONDS.sleep(2);
//        }
//        //删,-1表示没有锁
//        zooKeeper.delete("/nodes/node1",-1);
//        TimeUnit.SECONDS.sleep(5);


        //设置授权
        List<ACL> acls = new ArrayList<ACL>();
        zooKeeper.addAuthInfo(SchemaType.DIGEST.getType(),"root:root".getBytes());
//        ACL acl = new ACL(ZooDefs.Perms.READ|ZooDefs.Perms.WRITE,new Id("ip","192.168.0.0.1"));
//        ACL acl1 = new ACL(ZooDefs.Perms.READ|ZooDefs.Perms.WRITE,new Id("digest","username:password"));
//        acls.add(acl);
//        acls.add(acl1);
        zooKeeper.create("/auth","auth".getBytes(),acls,CreateMode.EPHEMERAL);


    }




    public void process(WatchedEvent watchedEvent) {

        //如果当前连接已经成功,那就通过计数器去控制这个链接
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            //刚刚链接成功的类型为None路径为null,这里排除掉
//            类型:
//            None(-1),//空
//            NodeCreated(1),//创建子节点触发
//            NodeDeleted(2),//删除子节点触发
//            NodeDataChanged(3),//修改触发
//            NodeChildrenChanged(4);//更新子节点触发
            if(watchedEvent.getPath() == null && Event.EventType.None == watchedEvent.getType()){
                countDownLatch.countDown();
                System.out.println("链接成功!"+watchedEvent.getState());
            }else{
                System.out.println("操作类型: "+watchedEvent.getType());
                switch (watchedEvent.getType()){
                    case NodeCreated:
                        System.out.println("创建子节点: "+watchedEvent.getType()+" - "+watchedEvent.getState());
                        try {
                            System.out.println(zooKeeper.getData(watchedEvent.getPath(), true, stat));
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case NodeDeleted:
                        System.out.println("删除: "+watchedEvent.getType()+" - "+watchedEvent.getState());
                        try {
                            System.out.println(zooKeeper.exists(watchedEvent.getPath(),true));
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case NodeDataChanged:
                        System.out.println("修改: "+watchedEvent.getType()+" - "+watchedEvent.getState());
                        try {
                            System.out.println(zooKeeper.getData(watchedEvent.getPath(), true, stat));
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case NodeChildrenChanged:
                        System.out.println("修改子节点: "+watchedEvent.getType()+" - "+watchedEvent.getState()+" - "+watchedEvent.getPath());
                        try {
                            System.out.println(zooKeeper.getData(watchedEvent.getPath(), true, stat));
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;

                }
            }
        }
    }
}