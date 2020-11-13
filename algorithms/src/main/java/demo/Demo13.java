package demo;

import java.util.Arrays;

/**
 * @Description:
 * {1,5,0,6,9,0,0,8,3,7,6,0,5}
 * 将数组中指定的0都移到末尾,最终变成,考虑边界以及时间空间复杂度,尽量一次循环
 * {1,5,6,9,8,3,7,6,5,0,0,0,0}
 *
 * @author: zhangcq
 * @Time: 2019-7-24 10:26
 * @Version 1.0
 */
public class Demo13 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,0,6,9,0,0,8,3,7,6,0,5};
        wuxu(arr);
        youxu(arr);

    }

    /**
     * 无序移动0        [1, 5, 7, 6, 9, 6, 5, 8, 3, 0, 0, 0, 0]
     * @param arr
     */
    private static void wuxu(int[] arr) {
        int zero = arr.length-1;
        for (int i=arr.length-1;i>=0;i--) {
            if(arr[i] == 0){
                int temp = arr[i];
                arr[i] = arr[zero];
                arr[zero] = temp;
                zero--;
            }
        }
        System.out.println("无序移动:"+Arrays.toString(arr));
    }

    /**
     * 有序移动0    {1,5,6,9,8,3,7,6,5,0,0,0,0}
     * @param arr
     */
    private static void youxu(int[] arr) {

        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab"+"c";
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
        System.out.println(b.equals(c));
        System.out.println(b.equals(d));
        System.out.println(c.equals(d));
        System.out.println("................");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);
        System.out.println(b==c);
        System.out.println(b==d);
        System.out.println(c==d);



//        System.out.println("有序移动:"+Arrays.toString(arr));
    }



}