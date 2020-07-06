package leetCode15;

import sun.tools.tree.NewArrayExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = nums.length;

        if(nums ==null ||len < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for(int i = 0;i<len-2;i++){
            //nums[i] > 0 之后就不会有 a + b +c == 0
            if(nums[i]>0)   {
                break;
            }

            //去重
            if( i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i+1;
            int r = len-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l]==nums[l+1]){ // 去重
                        l++;
                    }
                    while(l<r&&nums[r]==nums[r-1]) { // 去重
                        r--;
                    }

                    l++;
                    r--;
                }else if(sum<0){ // sum 过小，指针向左移动
                    l++;
                }else if(sum>0){ // sum 过大，指针向右移动
                    r--;
                }
            }
        }
        return ans;
    }

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
