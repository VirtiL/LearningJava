package demo;

import java.util.Arrays;

/**
 * @Description:  快排
 * @author: zhangcq
 * @Time: 2019-7-21 15:29
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        int[] arr = new int[]{7,3,9,10,4,6};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int i, int length) {
        if(i<length){
            System.out.println("1->"+Arrays.toString(arr));
            int min = sortChild(arr, i, length);
            System.out.println("2->"+Arrays.toString(arr));
            sort(arr,i,min-1);
            System.out.println("3->"+Arrays.toString(arr));
            sort(arr,min+1,length);
            System.out.println("4->"+Arrays.toString(arr));
        }
    }

    private static int sortChild(int[] arr,int start,int end) {
            int temp = arr[start];//基数
            int i = start;
            int j = end;
            while (i<j) {
                while (i < j) {
                    if (arr[j] < temp) {//j找小的,扔给i
                        arr[i] = arr[j];
                        break;
                    }
                    j--;
                }
                while (i < j) {
                    if (arr[i] >= temp) {//i找大的,扔给j
                        arr[j] = arr[i];
                        break;
                    }
                    i++;
                }
            }
            arr[i] = temp;
            return i;
    }


}