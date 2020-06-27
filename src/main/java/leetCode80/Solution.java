package leetCode80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (j < 2 || nums[i] > nums[j-2]) {//j < 2 说明没有出现重复, nums[i] > nums[j-2] 同样说明没有出现重复，注意这里利用了数组是有序的，且单调递增
                nums[j++] = nums[i];
            }
        }

        return  j;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n:nums) {
            if (i < 2 || n > nums[i-2]) {   //i < 2 说明没有出现重复 n > nums[i-2] 同样说明没有出现重复，注意这里利用数组是有序的，且单调递增
                    nums[i++] = n;
            }
        }

        return  i ;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,1,1,2,2,2,3,3,4,4,4};
        //res
        int res = s.removeDuplicates(nums);

        System.out.println(res);

        System.out.println("remove duplicate array is ");
        for (int i = 0; i < res; i++) {
            System.out.printf(" %d ",nums[i]);
        }

        System.out.println();


    }
}
