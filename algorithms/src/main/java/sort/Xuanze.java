package sort;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

算法描述
n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：

初始状态：无序区为R[1..n]，有序区为空；
第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
n-1趟结束，数组有序化了。
 * @author: zhangcq
 * @Time: 2019-5-30 18:00
 * @Version 1.0
 */
public class Xuanze {

    /**
     *特点:
     平均时间复杂度是O(n^2)
     最坏时间复杂度是O(n^2)
     最好时间复杂度是O(n^2)
     空间复杂度是O(1)
     稳定性为不稳定
     [0, 6, 8, 3, 4, 7, 9, 1, 2, 5]
     [0, 1, 8, 3, 4, 7, 9, 6, 2, 5]
     [0, 1, 2, 3, 4, 7, 9, 6, 8, 5]
     [0, 1, 2, 3, 4, 7, 9, 6, 8, 5]
     [0, 1, 2, 3, 4, 7, 9, 6, 8, 5]
     [0, 1, 2, 3, 4, 5, 9, 6, 8, 7]
     [0, 1, 2, 3, 4, 5, 6, 9, 8, 7]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     */
    public static void main(String[] args) {
        int[] xuanze = new int[]{5,6,8,3,4,7,9,1,2,0};
        int len = xuanze.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                // 寻找最小的数
                if (xuanze[j] < xuanze[minIndex]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }
            temp = xuanze[i];
            xuanze[i] = xuanze[minIndex];
            xuanze[minIndex] = temp;
            System.out.println(Arrays.toString(xuanze));
        }
        System.out.println(Arrays.toString(xuanze));

    }

}