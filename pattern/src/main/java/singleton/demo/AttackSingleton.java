package singleton.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @Description: 破坏单例
 * @Author: virtiL
 */
public class AttackSingleton {



//    public static void main(String[] args) throws Exception {
//
////        Class<HungrySingleton> hungrySingletonClass = HungrySingleton.class;
//        Class<HungrySingleton> hungrySingletonClass = (Class<HungrySingleton>) Class.forName("singleton.demo.HungrySingleton");
//        Constructor<HungrySingleton> declaredConstructor = hungrySingletonClass.getDeclaredConstructor();
//        //强制让jvm不检查权限
//        declaredConstructor.setAccessible(true);
//        //新建实例1
//        HungrySingleton h1 = declaredConstructor.newInstance();
//        System.out.println(h1);
//        //新建实例2
//        HungrySingleton h2 = declaredConstructor.newInstance();
//        System.out.println(h2);
//        System.out.println(h1==h2);
//
//    }









    public static void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream("test");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(instance);
        oos.writeObject(instance);
        oos.flush();
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("test");
        ObjectInputStream ois = new ObjectInputStream(fis);
        HungrySingleton instance2 = (HungrySingleton) ois.readObject();
        System.out.println(instance2);
        ois.close();
        fis.close();

        System.out.println(instance==instance2);
    }
}