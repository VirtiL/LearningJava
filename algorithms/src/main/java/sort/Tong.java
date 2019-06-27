package sort;

import java.util.Arrays;

/**
 * @Description: 桶排序
 *
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。

算法描述
    设置一个定量的数组当作空桶；
    遍历输入数据，并且把数据一个一个放到对应的桶里去；
    对每个不是空的桶进行排序；
    从不是空的桶里把排好序的数据拼接起来。

算法步骤
    设置固定数量的空桶。
    把数据放到对应的桶中。
    对每个不为空的桶中数据进行排序。
    拼接不为空的桶中数据，得到结果
 * @author: zhangcq
 * @Time: 2019-6-19 13:40
 * @Version 1.0
 */
public class Tong {


    /**
     * 特点:
     平均时间复杂度是O(n+k)
     最坏时间复杂度是O(n^2)
     最好时间复杂度是O(n)
     空间复杂度是O(n+k)
     稳定性为稳定
     * @param args
     */
    public static void main(String[] args) {
        int[] tong = new int[]{5,6,8,3,4,7,9,1,2,0};
        int[] sort = sort(tong);
        System.out.println(Arrays.toString(sort));
    }


    public static int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return bucketSort(arr, 5);
    }

    private static int[] bucketSort(int[] arr, int bucketSize){
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
        // 对每个桶进行排序，这里使用了插入排序
//            ***************
        int len = bucket.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = bucket[i];
            while (preIndex >= 0 && bucket[preIndex] > current) {
                bucket[preIndex + 1] = bucket[preIndex];
                preIndex--;
            }
            bucket[preIndex + 1] = current;
        }
//            ***************
        for (int value : bucket) {
            arr[arrIndex++] = value;
        }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

}