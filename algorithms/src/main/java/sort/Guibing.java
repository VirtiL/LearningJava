package sort;

import java.util.Arrays;

/**
 * @Description: 归并排序
    归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。

    算法描述
    把长度为n的输入序列分成两个长度为n/2的子序列；
    对这两个子序列分别采用归并排序；
    将两个排序好的子序列合并成一个最终的排序序列。
    归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间。
 * @author: zhangcq
 * @Time: 2019-6-3 09:31
 * @Version 1.0
 */
public class Guibing {

    /**
     *
     特点:
     平均时间复杂度是O(nlog2n)
     最坏时间复杂度是O(nlog2n)
     最好时间复杂度是O(nlog2n)
     空间复杂度是O(n)
     稳定性为稳定

     [5, 6, 8, 3, 4, 7, 9, 1, 2, 0]
     [5, 6, 8, 3, 4, 7, 9, 1, 2, 0]
     [5, 6, 8, 3, 4, 7, 9, 1, 2, 0]
     [3, 4, 5, 6, 8, 7, 9, 1, 2, 0]
     [3, 4, 5, 6, 8, 7, 9, 1, 2, 0]
     [3, 4, 5, 6, 8, 1, 7, 9, 2, 0]
     [3, 4, 5, 6, 8, 1, 7, 9, 0, 2]
     [3, 4, 5, 6, 8, 0, 1, 2, 7, 9]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     * @param args
     */
    public static void main(String[] args) {
        int[] guibing = new int[]{5,6,8,3,4,7,9,1,2,0};
        mergeSort(guibing,0, guibing.length - 1);
    }

    private static void merge(int[] guibing, int start, int mid,
                              int end) {
        int[] tmp = new int[guibing.length];
        int i = start, j = mid + 1, k = start;
        while (i != mid + 1 && j != end + 1) {
            if (guibing[i] < guibing[j]){
                tmp[k++] = guibing[i++];
            }else{
                tmp[k++] = guibing[j++];
            }
        }
        while (i != mid + 1){
            tmp[k++] = guibing[i++];
        }
        while (j != end + 1){
            tmp[k++] = guibing[j++];
        }
        for (i = start; i <= end; i++){
            guibing[i] = tmp[i];
        }
        System.out.println(Arrays.toString(guibing));
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // 左边有序
            mergeSort(a, start, mid);
            // 右边有序
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

}