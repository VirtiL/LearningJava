package api.distributelock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-1 15:13
 * @Version 1.0
 */
public class LockWacther implements Watcher {

    private CountDownLatch countDownLatch;

    public LockWacther(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getType() == Event.EventType.NodeDeleted){
            countDownLatch.countDown();
        }
    }
}