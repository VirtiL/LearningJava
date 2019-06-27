package sort;

import java.util.Arrays;

/**
 * @Description: 希尔排序

    希尔排序概念:
    1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。

    希尔排序特点:
    先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序.

    选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
    按增量序列个数k，对序列进行k 趟排序；
    每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
    希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。动态定义间隔序列的算法是《算法（第4版）》的合著者Robert Sedgewick提出的。

 * 
 * @author: zhangcq
 * @Time: 2019-6-3 09:26
 * @Version 1.0
 */
public class Xier {


    /**
     *
     特点:
     平均时间复杂度是O(n^1.3)
     最坏时间复杂度是O(n^2)
     最好时间复杂度是O(n)
     空间复杂度是O(1)
     稳定性为不稳定

     [5, 6, 1, 2, 0, 7, 9, 8, 3, 4]
     [0, 2, 1, 4, 3, 6, 5, 7, 9, 8]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     * @param args
     */
    public static void main(String[] args) {
        int[] xier = new int[]{5,6,8,3,4,7,9,1,2,0};
        int len = xier.length;
        for (int gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = xier[i];
                while (j - gap >= 0 && current < xier[j - gap]) {
                    xier[j] = xier[j - gap];
                    j = j - gap;
                }
                xier[j] = current;
            }
            System.out.println(Arrays.toString(xier));
        }
        System.out.println(Arrays.toString(xier));
    }
    
}