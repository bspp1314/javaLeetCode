package leetCode35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int  end = nums.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;    //防止溢位
            if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else {
               return mid;
            }
        }
        if (start == 0) {
            return 0;
        }else if (end == nums.length-1){
            return nums.length;
        }else{
            return end +1;
        }

    }
    public static void main(String[] args) {

    }
}
