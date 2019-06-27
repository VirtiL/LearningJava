package make_consume.v3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: 库房
 * @Time: 2019/2/11 16:26
 * @Version 1.0
 */
public class Library {
    private BlockingQueue resourceQueue = new LinkedBlockingQueue(10);
    /**
     * 向库房中添加资源
     */
    public void add(){
        try {
            resourceQueue.put(1);
            System.out.println("卖家" + Thread.currentThread().getName()
                    + "生产一件资源," + "当前库房有" + resourceQueue.size() +
                    "个资源");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 在库房中移除资源
     */
    public void remove(){
        try {
            resourceQueue.take();
            System.out.println("买家" + Thread.currentThread().getName() +
                    "消耗一件资源," + "当前库房有" + resourceQueue.size()
                    + "个资源");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}