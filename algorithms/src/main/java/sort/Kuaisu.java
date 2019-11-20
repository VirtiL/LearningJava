package sort;

import java.util.Arrays;

/**
 * @Description: 快速排序
 *
快速排序使用分治法来把一个串（list）分为两个子串（sub-lists)

从数列中挑出一个元素，称为 “基准”（pivot）；
重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
---------------------
作者：VirtiL
来源：CSDN
原文：https://blog.csdn.net/virtiL33/article/details/91038941
版权声明：本文为博主原创文章，转载请附上博文链接！
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
        //确保arr是2个数或以上
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //5,6,8,3,4,7,9,1,2,0
        // 设定基准值下标.也就是5
        int pivot = left;
        //获取基准后一位下标,也就是6的下标
        int index = pivot + 1;
        //遍历数组,从6开始
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                System.out.println(Arrays.toString(arr));
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