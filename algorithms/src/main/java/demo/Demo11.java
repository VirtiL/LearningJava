package demo;

import java.util.Arrays;

/**
 * @Description: 小根堆,大根堆
 * @author: zhangcq
 * @Time: 2019-7-21 17:35
 * @Version 1.0
 */
public class Demo11 {

    public static void main(String[] args) {
        int[] dui = new int[]{5,6,8,3,4,7,9,1,2,0};
        minDui(dui);
        int[] dui2 = new int[]{5,6,8,3,4,7,9,1,2,0};
        maxDui(dui2);
    }

    private static void minDui(int[] dui) {
        int len = dui.length;
        //循环执行
        while (len > 2) {

            //遍历父节点
            for (int p = (len/ 2); p >0; p--) {
                //找到最大的儿子节点,先假设是左儿子
                int maxChild = (p * 2)-1;
                //看看是不是有右儿子,如果右儿子有并且比左儿子大,那就把右儿子设置成最大的儿子
                if ((maxChild + 1) < len && dui[maxChild + 1] < dui[maxChild]) {
                    maxChild++;
                }
                //儿子比父亲大,就交换
                if (dui[maxChild] < dui[p-1]) {
                    int temp = dui[maxChild];
                    dui[maxChild] = dui[p-1];
                    dui[p-1] = temp;
                }
            }
            //根节点与最后一个节点交换
            int gen = dui[0];
            dui[0] = dui[len-1];
            dui[len-1] = gen;
            len--;
        }
        System.out.println("小根堆: "+Arrays.toString(dui));
    }

    private static void maxDui(int[] dui) {
        int len = dui.length;
        //循环执行
        while (len > 2) {

            //遍历父节点
            for (int p = (len/ 2); p >0; p--) {
                //找到最大的儿子节点,先假设是左儿子
                int maxChild = (p * 2)-1;
                //看看是不是有右儿子,如果右儿子有并且比左儿子大,那就把右儿子设置成最大的儿子
                if ((maxChild + 1) < len && dui[maxChild + 1] > dui[maxChild]) {
                    maxChild++;
                }
                //儿子比父亲大,就交换
                if (dui[maxChild] > dui[p-1]) {
                    int temp = dui[maxChild];
                    dui[maxChild] = dui[p-1];
                    dui[p-1] = temp;
                }
            }
            //根节点与最后一个节点交换
            int gen = dui[0];
            dui[0] = dui[len-1];
            dui[len-1] = gen;
            len--;
        }

        System.out.println("大根堆: "+Arrays.toString(dui));

    }

}