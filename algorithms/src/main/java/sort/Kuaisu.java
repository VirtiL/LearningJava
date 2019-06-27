package sort;

import java.util.Arrays;

/**
 * @Description: 快速排序
 *
 * @author: zhangcq
 * @Time: 2019-6-6 09:27
 * @Version 1.0
 */
public class Kuaisu {


    /**
     *
     * 特点:
     平均时间复杂度是O(nlog2n)
     最坏时间复杂度是O(n^2)
     最好时间复杂度是O(nlog2n)
     空间复杂度是O(nlog2n)
     稳定性为不稳定
     [5, 6, 8, 3, 4, 7, 9, 1, 2, 0]
     [0, 3, 4, 1, 2, 5, 9, 6, 8, 7]
     [0, 3, 4, 1, 2, 5, 9, 6, 8, 7]
     [0, 3, 4, 1, 2, 5, 9, 6, 8, 7]
     [0, 2, 1, 3, 4, 5, 9, 6, 8, 7]
     [0, 1, 2, 3, 4, 5, 9, 6, 8, 7]
     [0, 1, 2, 3, 4, 5, 9, 6, 8, 7]
     [0, 1, 2, 3, 4, 5, 9, 6, 8, 7]
     [0, 1, 2, 3, 4, 5, 9, 6, 8, 7]
     [0, 1, 2, 3, 4, 5, 7, 6, 8, 9]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     * @param args
     */
    public static void main(String[] args) {
        int[] kuaisu = new int[]{5,6,8,3,4,7,9,1,2,0};
        // 对 arr 进行拷贝，不改变参数内容
        int[] ints = quickSort(kuaisu, 0, kuaisu.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        System.out.println(Arrays.toString(arr));
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




}