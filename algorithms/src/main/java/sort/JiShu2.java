package sort;

import java.util.Arrays;

/**
 * @Description: 基数排序
 *
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
 *
算法描述
    取得数组中的最大数，并取得位数；
    arr为原始数组，从最低位开始取每个位组成radix数组；
    对radix进行计数排序（利用计数排序适用于小范围数的特点)

算法步骤
    将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零
    从最低位开始，依次进行一次排序
    从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
 * @author: zhangcq
 * @Time: 2019-6-19 13:40
 * @Version 1.0
 */
public class JiShu2 {


    /**
     * 特点:
     平均时间复杂度是O(n*k)
     最坏时间复杂度是O(n*k)
     最好时间复杂度是O(n*k)
     空间复杂度是O(n+k)
     稳定性为稳定
     * @param args
     */
    public static void main(String[] args) {
        int[] jishu2 = new int[]{5,6,8,3,4,7,9,1,2,0};
        int[] sort = sort(jishu2);
        System.out.println(Arrays.toString(sort));
    }


    public static int[] sort(int[] sourceArray){
       int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

       int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
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

    private static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private static int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }
    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }





}