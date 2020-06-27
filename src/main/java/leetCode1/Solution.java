package leetCode1;

import java.util.HashMap;

public class Solution {

    public static int[] twoSum(int[] nums,int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> targetMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (targetMap.containsKey(target-nums[i])){
                result[0] = targetMap.get(target-nums[i]);
                result[1] = i;
                return result;
            }

            targetMap.put(nums[i],i);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int target = 5;

        int[] res = twoSum(nums,target);

        for (int i = 0; i < res.length ; i++) {
            System.out.printf(" %d ",res[i]);
        }
        System.out.println();


    }
}
