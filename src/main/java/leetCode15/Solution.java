package leetCode15;

import sun.tools.tree.NewArrayExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3){
            return null;
        }

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        if (nums[0] >= 0) {
            return null;
        }

        if (nums[nums.length-1] <= 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            }

            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            ArrayList<List<Integer>> a = twoSum(i+1,nums,-nums[i]);
            res.addAll(a);
        }

        return res;
    }

    //nums 是有序的
    public static ArrayList<List<Integer>> twoSum(int begin,int[] nums,int target) {
        ArrayList<List<Integer>> result = new  ArrayList<List<Integer>>();

        HashMap<Integer, Integer> targetMap = new HashMap<Integer,Integer>();
        HashMap<Integer,Boolean> existRes = new HashMap<Integer, Boolean>();


        for (int i = begin; i < nums.length; i++) {
            if (targetMap.containsKey(target-nums[i])){
                if (existRes.containsKey(nums[i])) {
                    continue;
                }

                existRes.put(nums[i],true);
                ArrayList a = new ArrayList();
                a.add(nums[i]);
                a.add(target-nums[i]);
                a.add(-target);
                result.add(a);

            }

            targetMap.put(nums[i],i);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> a = new Solution().threeSum(new int[]{1,0,-1,2,-1,-4});
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size() ; j++) {
                System.out.printf("  %d  ",a.get(i).get(j));
            }

            System.out.println();
        }
    }



}
