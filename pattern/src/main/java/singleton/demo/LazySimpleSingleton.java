package singleton.demo;

/**
 * @Description: 懒汉式单例
 * @Author: virtiL
 * @Time: 2021/1/13 13:56
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {
        if(AnonymousInnerClass.INSTANCE != null){
            throw new RuntimeException("Multiple instances are not allowed");
        }
    }

    //保证空间共享和方法不被重载
    public static final LazySimpleSingleton getInstance() {
        //返回结果之前会加载内部类
        return AnonymousInnerClass.INSTANCE;
    }

    //默认是不加载的,当使用LazySimpleSingleton的时候才会加载初始化内部类,也就是达成了延迟加载的目的
    private static class AnonymousInnerClass{
        private static final  LazySimpleSingleton INSTANCE = new LazySimpleSingleton();
    }

    private Object readResolve() {
        return AnonymousInnerClass.INSTANCE;
    }


}



//public class LazySimpleSingleton {
//
//    //用volatile来保证线程可见性和指令重排序
//    private static volatile LazySimpleSingleton INSTANCE = null;
//
//    private LazySimpleSingleton() {
//        if(INSTANCE != null){
//            throw new RuntimeException("Multiple instances are not allowed");
//        }
//    }
//
//    //双重校验锁
//    public static LazySimpleSingleton getInstance() {
//        //此处N个线程都可以同时进来
//        if (INSTANCE == null) {
//            //此处N个线程都可以同时进来,但是这里加了锁,串行化执行
//            synchronized (LazySimpleSingleton.class) {
//                //虽然保证了同步,从不能每次进来都new吧,所以还是要再检查一次的
//                if (INSTANCE == null) {
//                    INSTANCE = new LazySimpleSingleton();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//    private Object readResolve() {
//        return INSTANCE;
//    }
//
//}
