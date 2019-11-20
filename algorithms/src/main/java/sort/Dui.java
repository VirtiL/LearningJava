package sort;

import java.util.Arrays;

/**
 * @Description: 堆排序
 *
 *
    堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，
    并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。

    算法描述
    将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
    将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
    由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，
得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。

    算法步骤
    创建一个堆 H[0……n-1]；

    把堆首（最大值）和堆尾互换；

    把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；

    重复步骤 2，直到堆的尺寸为 1。

 * @author: zhangcq
 * @Time: 2019-6-19 13:39
 * @Version 1.0
 */
public class Dui {

    /**
     * 特点:
     平均时间复杂度是O(nlog2n)
     最坏时间复杂度是O(nlog2n)
     最好时间复杂度是O(nlog2n)
     空间复杂度是O(1)
     稳定性为不稳定
     */
    public static void main(String[] args) {
        int[] dui = new int[]{5,6,8,3,4,7,9,1,2,0};
        int[] sort = sort(dui);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] sourceArray){
       int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

       int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private static void buildMaxHeap(int[] arr, int len) {
        //先将数组平分,如果一半的长度大于0,那就执行
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        //5,6,8,3,4,7,9,1,2,0   5   10
        int left = 2 * i + 1;//11
        int right = 2 * i + 2;//12
        int largest = i;//5

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}