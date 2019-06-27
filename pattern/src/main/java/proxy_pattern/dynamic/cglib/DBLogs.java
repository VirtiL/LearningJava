package proxy_pattern.dynamic.cglib;

/**
 * @Description: 被代理对象
 * @author: zhangcq
 * @Time: 2019-3-28 14:17
 * @Version 1.0
 */
public class DBLogs {

    public void insert(){
        System.out.println("插入数据");
    }

}