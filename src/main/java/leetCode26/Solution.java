package leetCode26;


public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int j = 0;
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]){
                len++;
                j++;
                nums[j] = nums[i];
            }
        }

        return  len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3,3,4,4,5,5,6,6,6,6,7,7,9,9};
        int res = s.removeDuplicates(nums);

        System.out.println(res);

        System.out.println("remove duplicate array is ");
        for (int i = 0; i < res; i++) {
            System.out.printf(" %d ",nums[i]);
        }

        System.out.println();


    }

}
