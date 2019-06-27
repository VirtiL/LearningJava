package sort;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

算法描述
比较相邻的元素。如果第一个比第二个大，就交换它们两个；
对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
针对所有的元素重复以上的步骤，除了最后一个；
重复步骤1~3，直到排序完成。


 * @author: zhangcq
 * @Time: 2019-5-30 17:35
 * @Version 1.0
 */
public class Maopao {

    /**
     * 相邻大小比较,大在后,小在前,最后一位不参与比较
     * 特点:
         平均时间复杂度是O(n^2)
         最坏时间复杂度是O(n^2)
         最好时间复杂度是O(n)
         空间复杂度是O(1)
         稳定性为稳定
     [5, 6, 3, 4, 7, 8, 1, 2, 0, 9]
     [5, 3, 4, 6, 7, 1, 2, 0, 8, 9]
     [3, 4, 5, 6, 1, 2, 0, 7, 8, 9]
     [3, 4, 5, 1, 2, 0, 6, 7, 8, 9]
     [3, 4, 1, 2, 0, 5, 6, 7, 8, 9]
     [3, 1, 2, 0, 4, 5, 6, 7, 8, 9]
     [1, 2, 0, 3, 4, 5, 6, 7, 8, 9]
     [1, 0, 2, 3, 4, 5, 6, 7, 8, 9]
     [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     */
    public static void main(String[] args) {
        int[] maopao = new int[]{5,6,8,3,4,7,9,1,2,0};
        int length = maopao.length;
        for (int i =0;i<length-1;i++){
            for (int j=0;j<length-1-i;j++){
                // 相邻元素两两对比
                if (maopao[j] > maopao[j+1]) {
                    // 元素交换
                    int temp = maopao[j+1];
                    maopao[j+1] = maopao[j];
                    maopao[j] = temp;
                }
            }
            System.out.println(Arrays.toString(maopao));
        }
        System.out.println(Arrays.toString(maopao));

    }

}