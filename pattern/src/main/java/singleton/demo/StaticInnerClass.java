package singleton.demo;

/**
 * @Description: 静态内部类的方式(推荐)
 * @author: zhangcq
 * @Time: 2019/2/18 20:02
 * @Version 1.0
 */
public class StaticInnerClass {

    private StaticInnerClass() {}

    /**
     * 静态内部类
     */
    private static class SingletonBuilder{
        private static StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance(){
        return SingletonBuilder.staticInnerClass;
    }



}