package proxy_pattern.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: 执行者,代理类
 *     cglib是可以不传被代理对象的引用的,而他产生的对象的引用是由cglib创建并提供的
 * @author: zhangcq
 * @Time: 2019-3-28 14:18
 * @Version 1.0
 */
public class ORM implements MethodInterceptor{

    //被代理对象的引用(可不用)
    private Object target;

    /**
     * 相当于jdk动态代理中的绑定
     * @param target  也可以直接传DBLogs.class
     * @return
     */
    public Object getInstance(Object target){
        System.out.println("代理前的对象: "+target.getClass());
        this.target = target;
        //创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        enhancer.setSuperclass(this.target.getClass());
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦截
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return enhancer.create();
    }


    /**
     * @param o 子类的引用
     * @param method    方法
     * @param objects   参数
     * @param methodProxy   方法代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---------------------------------");
        System.out.println("开启一个事务!");
        //调用父类的方法
        methodProxy.invokeSuper(o, objects);
//        Object invoke = method.invoke(this.target, objects);
        System.out.println("提交并关闭一个事务!");
        System.out.println("---------------------------------");
        return null;
    }
}