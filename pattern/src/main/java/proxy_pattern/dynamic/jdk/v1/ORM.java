package proxy_pattern.dynamic.jdk.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 代理对象
 * 方法一: 可实现InvocationHandler接口,也可以不实现,视情况而定  (public class ORM implements InvocationHandler)
 * 方法二: 如果不实现,那么在调用proxy的静态方法时需要自己new一个事件处理器InvocationHandler  (new InvocationHandler)
 * @author: zhangcq
 * @Time: 2019/03/26 0026 16:54:29 ${
 * @Version 1.0
 */
public class ORM implements InvocationHandler {

    //被代理对象的引用
    private Object target;

    /**
     * 获取被代理者的信息
     * @return
     * @throws Exception
     */
    public Object getInstance(Object target) throws Exception{
        this.target = target;

        Class clazz = target.getClass();
        System.out.println("被代理之前的类"+clazz);
        /**
         * 该方法是在Proxy类中是静态方法,且接收的三个参数依次为:
         * ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
         * Class<?>[] interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
         * InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
         */
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
//        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),new InvocationHandler(){
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("---------------------------------");
//                System.out.println("开启一个事务!");
//                Object invoke = method.invoke(target, args);
//                System.out.println("提交并关闭一个事务!");
//                System.out.println("---------------------------------");
//                return null;
//            }
//        });
    }

    /**
     * 代理对象自动调用该方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------------------------------");
        System.out.println("开启一个事务!");
        Object invoke = method.invoke(target, args);
        System.out.println("提交并关闭一个事务!");
        System.out.println("---------------------------------");
        return null;
    }
}