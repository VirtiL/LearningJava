package demo;

import java.util.Stack;

/**
 * @Description: 整数反转
 * @author: zhangcq
 * @Time: 2019-7-20 09:25
 * @Version 1.0
 */
public class Demo5 {


    public static void main(String[] args) {
        int a = -123456;
        int aa = reverse(a);
        System.out.println(aa);
        int bb = reverse2(a);
        System.out.println(bb);
        int cc = reverse3(a);
        System.out.println(cc);
    }

    private static int reverse3(int a) {
        boolean flag = a > 0;
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();
        if (!flag)sb.append("-");
        int abs = Math.abs(a);
        String str = String.valueOf(abs);
        for (int i=0;i<str.length();i++){
            stack.push(str.toCharArray()[i]);
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop().toString());
        }
        return Integer.parseInt(sb.toString());
    }

    private static int reverse2(int a) {
        boolean flag = a > 0;
        int abs = Math.abs(a);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(abs)).reverse();
        String s = sb.toString();
        String s1 = flag ? s : "-" + s;
        System.out.println(s1);
        return Integer.parseInt(s1);
    }

    public static int reverse(int x) {
        long temp = 0;
        while (x != 0){
            int y = x % 10;
            temp = temp*10+y;
            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            x = x/10;
        }
        return (int) temp;
    }


}