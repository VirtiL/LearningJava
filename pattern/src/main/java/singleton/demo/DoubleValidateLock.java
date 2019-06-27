package singleton.demo;

/**
 * @Description: 双重效验锁的方式(推荐)
 * @author: zhangcq
 * @Time: 2019/2/18 19:57
 * @Version 1.0
 */
public class DoubleValidateLock {

    /**
     *  静态实例变量加上volatile,保证线程可见性
     */
    private static volatile DoubleValidateLock doubleValidateLock;

    private DoubleValidateLock() {
    }

    //双重效验锁
    public static DoubleValidateLock getDoubleValidateLock(){
        if(doubleValidateLock == null){
            synchronized (DoubleValidateLock.class){
                if(doubleValidateLock == null){
                    doubleValidateLock = new DoubleValidateLock();
                }
            }
        }
        return doubleValidateLock;
    }
}