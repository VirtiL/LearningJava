package proxy_pattern.static_state;


/**
 * @Description: 代理模式
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.
 * 同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * @author: zhangcq
 * @Time: 2019/03/26 0026 16:09:15
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        //目标对象
        FileLog fileLog = new FileLog();
        System.out.println(fileLog.getClass());
        //把目标对象的信息告诉代理对象
        ProxyLog proxyLog = new ProxyLog(fileLog);
        System.out.println(proxyLog.getClass());
        //代理对象输出结果
        proxyLog.print();
    }

}