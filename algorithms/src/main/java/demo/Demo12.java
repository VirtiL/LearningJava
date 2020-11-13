package demo;

import java.util.Arrays;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-22 16:12
 * @Version 1.0
 */
public class Demo12 {


    public static void main(String[] args) {
        int[] arr = new int[]{7,3,9,10,3,6};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] array, int _left, int _right) {
        int left = _left;//
        int right = _right;
        int pivot;//基准线
        if (left < right) {
            pivot = array[left];
            while (left != right) {
                //从右往左找到比基准线小的数
                while (left < right && pivot <= array[right]) {
                    right--;
                }
                //将右边比基准线小的数换到左边
                array[left] = array[right];
                //从左往右找到比基准线大的数
                while (left < right && pivot >= array[left]) {
                    left++;
                }
                //将左边比基准线大的数换到右边
                array[right] = array[left];
            }
            //此时left和right指向同一位置
            array[left] = pivot;
            quickSort(array, _left, left - 1);
            quickSort(array, left + 1, _right);
        }
    }
}