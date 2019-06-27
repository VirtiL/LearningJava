package proxy_pattern.dynamic.cglib;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-3-28 13:59
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        DBLogs instance =(DBLogs) new ORM().getInstance(new DBLogs());
        System.out.println("代理后的对象: "+instance.getClass());
        instance.insert();
    }

}