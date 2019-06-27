package singleton.demo;

/**
 * @Description: 饿汉式(线程安全的单例)(不推荐)
 * @author zhangcq
 * @Time: 2019/2/18 17:54
 * @Version 1.0
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

//    private static HungrySingleton instance;
//    static {
//        instance = new HungrySingleton();
//    }

    private HungrySingleton() {}

    public static HungrySingleton getInstance(){
        return instance;
    }
}