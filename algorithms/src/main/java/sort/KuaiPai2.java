package sort;

import java.util.Arrays;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-19 17:02
 * @Version 1.0
 */
public class KuaiPai2 {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4,1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int start, int end) {

        //当开始位置小于结束位置时（数组有数据）  进行排序  也就是递归入口
        //0<3
        if (start < end) {
            System.out.println(start+"--"+end);
            //首先找到基准数  作为比较的标准数  取数组开始位置   从哪里开始  用哪个数当标准数 这个就是标准数
            //5=arr[0]
            int first = arr[start];

            //记录需要进行排序的下标
            //low = 0
            int low = start;
            //high = 3
            int high = end;

            //循环对比 比标准数大和小的数字
            //0<3?
            while (low < high) {
            System.out.println(low+"-"+high);
                //如果标准数小于右边的数字  把右边的游标卡尺向左移动
                // 0<3 && 5 <= 1
                while (low < high && first <= arr[high]) {
                    //3-1
                    high--;
                }
                //如果标准数大于 右边的数字
                //用低位数字替换右边数字
                //arr[0] = arr[3]
                arr[low] = arr[high];
                //如果左边的数字比标准数小
                while (low < high && arr[low] <= first) {
                    low++;
                }
                //如果左边的数字比标准数大
                //用左边数字替换右边数字
                arr[high] = arr[low];
            }
            //把标准数赋给高或者低所在的元素
            arr[low] = first;
            //处理所有比标准数小的数字
            quickSort(arr, start, low);
            //处理所有比标准数大的数字
            quickSort(arr, low + 1, end);
        }
    }
}