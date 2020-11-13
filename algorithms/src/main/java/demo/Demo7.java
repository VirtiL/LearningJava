package demo;

import java.util.Arrays;

/**
 * @Description: 求众数
 * @author: zhangcq
 * @Time: 2019-7-20 10:38
 * @Version 1.0
 */
public class Demo7 {

    public static void main(String[] args) {
        int[] a = {1,1,2,3};
        Arrays.sort(a);
        int rr = toupiao(a);
        System.out.println(rr);

    }

    private static int toupiao(int[] nums) {
            //计算当前的数字出现的次数
            int count=0;
            //当前判断的元素
            int candidate=0;
            //1123
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }
            return candidate;
    }

}