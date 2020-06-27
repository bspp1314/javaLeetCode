package leetCode27;

public class Solution {
    public int removeElement(int[] nums,int val) {
        if (nums.length == 0) {
            return  0;
        }

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3,3,4,4,5,5,6,6,6,6,7,7,9,9};
        int res = s.removeElement(nums,6);

        System.out.println(res);

        System.out.println("remove duplicate array is ");
        for (int i = 0; i < res; i++) {
            System.out.printf(" %d ",nums[i]);
        }

        System.out.println();


    }


}
