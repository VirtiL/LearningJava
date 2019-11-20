package quchong;

import java.util.Arrays;

/**
 * @Description:主要求的是数组中不重复的元素个数以及值(去重)
 * @author: zhangcq
 * @Time: 2019-7-5 17:16
 * @Version 1.0
 */
public class KuaiManZhiZhen {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,3,3,4,5,6,5,7,6,3,2,1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int man = 0;
        int kuai = 0;
        int length = arr.length;
        //如果快指针小于数组长度
        while(kuai < length){
            //如果慢指针的值和快指针的值相同,则快指针+1
            if(arr[man] == arr[kuai]){
                kuai++;
            }else{
                //如果快慢指针不同
                //慢指针+1
                man++;
                //把快指针的值给慢指针
                arr[man] = arr[kuai];
                //快指针+1
                kuai++;
            }

        }
        //慢指针+1就是不重复元素的个数
        System.out.println("去重后长度为"+(man+1));


        for (int i=0;i<man+1;i++) {
            System.out.println(arr[i]);
        }
    }

}