package leetcode;

import java.util.HashMap;

/**
 * @Description:
 * @Author: zhangcq
 * @Time: 2020-8-31 17:33
 */
public class Node1 {



    public static void main(String[] args) {
        int[] nums = {1, 6, 5, 2, 7, 9, 3, 4};
        int target = 9;
        twoSum(nums, target);
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * @param nums
     * @param target
     */
//    private static void twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i=0;i<nums.length;i++){
//            int cha = target - nums[i];
//            if(map.containsKey(cha)){
//                System.out.println(i+" and "+map.get(cha));
//                break;
//            }
//            map.put(nums[i],i);
//        }
//
//    }

    public static int[] twoSum(int[] nums, int target) {
        int[] aa = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int cha = target - nums[i];
            if(map.containsKey(cha)){
                int index = map.get(cha);
                aa = new int[]{i,index};
                break;
            }
            map.put(nums[i],i);
        }
        return aa;
    }

}