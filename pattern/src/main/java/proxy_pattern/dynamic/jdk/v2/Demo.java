package proxy_pattern.dynamic.jdk.v2;


import java.io.FileOutputStream;

/**
 * @Description: 抛弃jdk的主要Api,通过手写实现动态代理
 * @author: zhangcq
 * @Time: 2019/03/26 16:52:58
 * @Version 1.0
 */
public class Demo {

//    public static void main(String[] args) {
//        try {
//            Log instance = (Log) new ORM().getInstance(new DBLogs());
//            System.out.println("被代理以后的类"+instance.getClass());
//            instance.insert();
//            //输出动态创建的类的字节码
//            byte[] $Proxy0s = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Log.class});
//            FileOutputStream fileOutputStream = new FileOutputStream("D:/$Proxy0.class");
//            fileOutputStream.write($Proxy0s);
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}