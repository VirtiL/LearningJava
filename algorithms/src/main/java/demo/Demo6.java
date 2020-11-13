package demo;

/**
 * @Description: 回文数
 * @author: zhangcq
 * @Time: 2019-7-20 09:56
 * @Version 1.0
 */
public class Demo6 {

    public static void main(String[] args) {
        int a = 123454321;
        System.out.println(reverse(a));
    }

    public static boolean reverse(int x) {
        if(x < 0 || (x%10 == 0 && x!=0)){
            return false;
        }

        int temp = 0;
        while (x>temp){
            temp = temp*10+x%10;
            x = x/10;
        }
        return x == temp || x == temp/10;
    }

}