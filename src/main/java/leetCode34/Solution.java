package leetCode34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if (nums.length == 0) {
            return  res;
        }

        return search(nums,0,nums.length -1,target);
    }

    public static int[] search(int[] nums, int left,int right,int target) {
        int[] res = {-1,-1};


        while (left <= right) {
            int mid = left + (right-left)/2;
            if (target == nums[mid]) {
                    res[0] = mid;
                    res[1] = mid;
                    int[] leftRange = search(nums,left,mid-1,target);
                    int[] rightRange = search(nums,mid+1,right,target);
                    if(leftRange[0] != -1) {
                       res[0] = leftRange[0];
                    }

                    if (rightRange[1] != -1) {
                        res[1] = rightRange[1];
                    }
                    return res;
            }else if (target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] array = new int[]{1};
        for (int i = 0;i < array.length;i++){
                int[] res = s.searchRange(array,array[i]);
                System.out.printf("target %d range { %d,  ",array[i],res[0]);
                System.out.println(res[1]+"}");
        }
        System.out.println("=======================");

        for (int i = 0;i < array.length;i++){
            int[] res = s.searchRange(array,array[i]+9);
            System.out.printf("target %d range { %d,  ",array[i]+9,res[0]);
            System.out.println(res[1]+"}");
        }
        System.out.println("=======================");

        for (int i = 0;i < array.length;i++){
            int[] res = s.searchRange(array,array[i]-9);
            System.out.printf("target %d range { %d,  ",array[i]-9,res[0]);
            System.out.println(res[1]+"}");
        }
        System.out.println("=======================");
    }

}
