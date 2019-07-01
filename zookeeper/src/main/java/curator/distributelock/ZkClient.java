package curator.distributelock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-1 15:39
 * @Version 1.0
 */
public class ZkClient {

    //集群地址
    private static final String CONNECTSTRING = "192.168.0.201:2181,192.168.0.202:2181,192.168.0.203:2181,192.168.0.204:2181";

    private static final int sessionTimeOut=5000;


    public static CuratorFramework getCuratorFramework(){
        return CuratorFrameworkFactory.newClient(CONNECTSTRING,new ExponentialBackoffRetry(1000,3));
    }



}