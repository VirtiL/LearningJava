package demo;

/**
 * @Description: 阶乘
 * @author: zhangcq
 * @Time: 2019-7-20 13:52
 * @Version 1.0
 */
public class Demo10 {

    public static void main(String[] args) {
        int n = 3;
        int rr = jiecheng(n);
        System.out.println(rr);
    }

    private static int jiecheng(int n) {
        //1*2*3*4*5
        for (int i = n-1;i > 0;i--){
            n*=i;
        }


        return n;
    }

}