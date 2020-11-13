package demo;

/**
 * @Description: 二分查找 和带重复数据的二分查找
 * @author: zhangcq
 * @Time: 2019-7-19 23:43
 * @Version 1.0
 */
public class Demo4 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int r = binarySearch(arr,0,arr.length, 5);
        System.out.println(r);
        int[] arr2 = new int[]{1,2,3,4,4,5,5,5,6};
        int r2 = binarySearchleft(arr2,0,arr2.length, 5);
        System.out.println(r2);
        int[] arr3 = new int[]{1,2,3,4,4,5,5,5,6};
        int r3 = binarySearchRight(arr2,0,arr2.length, 5);
        System.out.println(r3);
    }


    /**
     * 不带重复的
     * @param arr
     * @param start
     * @param end
     * @param find
     * @return
     */
    private static int binarySearch(int[] arr, int start, int end,int find) {
        while (start <= end){
            int m = (start+end) >>> 1;
            if(find == arr[m]){
                return m;
            }else if(find > arr[m]){
                start = m+1;
            }else if(find < arr[m]){
                end = m-1;
            }

        }
        return -(start + 1);

    }


    /**
     * 带重复的查最左边
     * @return
     */
    private static int binarySearchleft(int[] arr2, int start, int end, int find) {
        //1,2,3,4,4,4,7,8,9
        while (start <= end){
            int m = (start+end) >>> 1;
            if(find == arr2[m]){
                if(find == arr2[m-1]){
                    end = m-1;
                    continue;
                }
                return m;
            }else if(find > arr2[m]){
                start = m+1;
            }else if(find < arr2[m]){
                end = m-1;
            }
        }
        return -(start + 1);
    }

    private static int binarySearchRight(int[] arr2, int start, int end, int find) {
        while (start <= end){
            int m = (start+end) >>> 1;
            if(find == arr2[m]){
                if(find == arr2[m+1]){
                    start = m+1;
                    continue;
                }
                return m;
            }else if(find > arr2[m]){
                start = m+1;
            }else if(find < arr2[m]){
                end = m-1;
            }
        }
        return -(start + 1);
    }

}