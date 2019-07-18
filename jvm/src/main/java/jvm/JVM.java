package jvm;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-4 14:25
 * @Version 1.0
 */
public class JVM {


    public static void main(String[] args) {
        JVM jvm = new JVM();
        int method = jvm.method();
        System.out.println(method);
    }


    private int method(){
        int a = 1;
        int b = 2;
        int c = a+b;
        return c;
    }

}