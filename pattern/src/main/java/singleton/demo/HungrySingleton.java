package singleton.demo;

import java.io.Serializable;

/**
 * @Description: 饿汉式单例1
 * @Author: virtiL
 * @Time: 2021/1/13 13:53
 */
public class HungrySingleton implements Serializable {

    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("Multiple instances are not allowed");
        }
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }


    private Object readResolve() {
        return INSTANCE;
    }


}

//public class HungrySingleton {
//
//    private static final HungrySingleton INSTANCE;
//
//    static {
//        INSTANCE = new HungrySingleton();
//    }
//
//    private HungrySingleton() {
//        if(INSTANCE != null){
//            throw new RuntimeException("Multiple instances are not allowed");
//        }
//    }
//
//    public static HungrySingleton getInstance() {
//        return INSTANCE;
//    }
//
//    private Object readResolve() {
//        return INSTANCE;
//    }
//
//}