package singleton.demo;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 注册式容器单例
 * @Author: virtiL
 */
public class RegisterContainerSingleton {

    //容器
    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    private RegisterContainerSingleton() {
    }

    public static Object getBean(String className) {
        if (!ioc.containsKey(className)) {
            synchronized (ioc) {
                Object obj = null;
                try {
//                    obj = Class.forName(className).newInstance();//jdk9之后就过时了
                    obj = Class.forName(className).getDeclaredConstructor().newInstance();
                    ioc.put(className, obj);
                } catch (InvocationTargetException | NoSuchMethodException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                return obj;
            }
        } else {
            return ioc.get(className);
        }

    }
//    public static Object getBean(String className) {
//        synchronized (ioc) {
//            if (!ioc.containsKey(className)) {
//                Object obj = null;
//                try {
////                    obj = Class.forName(className).newInstance();//jdk9之后就过时了
//                    obj = Class.forName(className).getDeclaredConstructor().newInstance();
//                    ioc.put(className, obj);
//                } catch (InvocationTargetException | NoSuchMethodException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                return obj;
//            } else {
//                return ioc.get(className);
//            }
//        }
//    }
}