package sort;

import java.util.Arrays;

/**
 * @Description: 计数排序
 * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 *
    算法描述
    找出待排序的数组中最大和最小的元素；
    统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
    对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
    反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。

    算法步骤
    花O(n)的时间扫描一下整个序列 A，获取最小值 min 和最大值 max
    开辟一块新的空间创建新的数组 B，长度为 ( max - min + 1)
    数组 B 中 index 的元素记录的值是 A 中某元素出现的次数
最后输出目标整数序列，具体的逻辑是遍历数组 B，输出相应元素以及对应的个数
 * @author: zhangcq
 * @Time: 2019-6-19 13:39
 * @Version 1.0
 */
public class JiShu {

    /**
     *特点:
     平均时间复杂度是O(n+k)
     最坏时间复杂度是O(n+k)
     最好时间复杂度是O(n+k)
     空间复杂度是O(n+k)
     稳定性为稳定
     * @param args
     */
    public static void main(String[] args) {
        int[] jishu = new int[]{5,6,8,3,4,7,9,1,2,0};
        int[] sort = sort(jishu);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] sourceArray){
       int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
       int maxValue = getMaxValue(arr);

        return countingSort(arr, maxValue);
    }

    private static int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }



}