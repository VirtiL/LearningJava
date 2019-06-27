package singleton.demo;

/**
 * @Description: 懒汉式(非线程安全的,所以需要加锁)(不推荐)
 * @author zhangcq
 * @Time: 2019/2/18 17:54
 * @Version 1.0
 */
public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton() {}

    //方法加锁
//    public static synchronized LazySingleton getInstance(){
//        if(singleton == null){
//            singleton = new LazySingleton();
//        }
//        return singleton;
//    }

    //代码块加锁
    public static LazySingleton getInstance(){
        synchronized (LazySingleton.class){
            if(singleton == null){
                singleton = new LazySingleton();
            }
        }
        return singleton;
    }

}