package sort;

import java.util.Arrays;

/**
 * @Description: 插入排序
 *
    插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

    算法描述
    一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
    从第一个元素开始，该元素可以认为已经被排序；
    取出下一个元素，在已经排序的元素序列中从后向前扫描；
    如果该元素（已排序）大于新元素，将该元素移到下一位置；
    重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
    将新元素插入到该位置后；
    重复步骤2~5。
 * @author: zhangcq
 * @Time: 2019-6-3 09:20
 * @Version 1.0
 */
public class Charu {


    /**
     *
     特点:
     平均时间复杂度是O(n^2)
     最坏时间复杂度是O(n^2)
     最好时间复杂度是O(n)
     空间复杂度是O(1)
     稳定性为稳定

     [5, 6, 8, 3, 4, 7, 9, 1, 2, 0]
     [5, 6, 8, 3, 4, 7, 9, 1, 2, 0]
     [3, 5, 6, 8, 4, 7, 9, 1, 2, 0]
     [3, 4, 5, 6, 8, 7, 9, 1, 2, 0]
     [3, 4, 5, 6, 7, 8, 9, 1, 2, 0]
     [3, 4, 5, 6, 7, 8, 9, 1, 2, 0]
     [1, 3, 4, 5, 6, 7, 8, 9, 2, 0]
     [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     * @param args
     */
    public static void main(String[] args) {
        int[] charu = new int[]{5,6,8,3,4,7,9,1,2,0};

        int len = charu.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = charu[i];
            while (preIndex >= 0 && charu[preIndex] > current) {
                charu[preIndex + 1] = charu[preIndex];
                preIndex--;
            }
            charu[preIndex + 1] = current;
            System.out.println(Arrays.toString(charu));
        }
        System.out.println(Arrays.toString(charu));

    }
}