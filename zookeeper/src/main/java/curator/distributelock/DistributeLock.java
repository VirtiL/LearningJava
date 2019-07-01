package curator.distributelock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-1 15:40
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
    private CuratorFramework curatorFramework;

    /**
     * 锁节点名
     */
    private String nodeName;

    /**
     * 可重入排它锁
     */
    private InterProcessMutex interProcessMutex;


    public DistributeLock() {
        this.curatorFramework = ZkClient.getCuratorFramework();
        curatorFramework.start();
//        this.interProcessMutex = new InterProcessMutex(curatorFramework,NAMESPACE_ROOT+nodeN)
    }
}