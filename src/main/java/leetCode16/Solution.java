package leetCode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int distance = Integer.MAX_VALUE;
        if(nums ==null ||nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        for(int i = 0;i<nums.length-2;i++){
            //去重
            if( i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];

                int newDis =  Math.abs(sum-target);
                if  (newDis < distance) {
                    distance = newDis;
                    res = sum;
                }

                if (distance == 0 ) {
                    return res;
                }else if ((sum -target) < 0 ){ //比0小，向 0 逼近
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //-1
        int a = new Solution().threeSumClosest(new int[]{-1,2,1,-4,0,-9,10,3,22,3},4);

        System.out.println(a);
    }



}
