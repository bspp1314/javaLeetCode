package leetCode283;

public class Solution {
    public void moveZeroes(int[] nums) {
       int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                if ((j-1) != i) {
                    nums[i] = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        Solution m = new Solution();
        int[] nums = new int[] {0};

        m.moveZeroes(nums);

        for (int i = 0; i < nums.length; i++) {
             System.out.printf(" %d ",nums[i]);
        }
        System.out.println();
    }
}
