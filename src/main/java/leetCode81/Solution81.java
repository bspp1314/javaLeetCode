package leetCode81;

public class Solution81 {
    public Boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return nums[0] == target;
        }

        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            while (left < right && nums[left] == nums[left+1]) {
                left = left +1 ;
            }

            while (left < right && nums[right] == nums[right-1]) {
                    right = right -1 ;
            }

            int mid = (left + right) / 2;
            if (nums[mid] == target)  {
                return true;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid] ) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else{
                    right = mid -1 ;
                }
            }
        }

        return  false;

    }


    public static void main(String[] args) {
        int[] array = {5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 1, 1, 2, 2, 3, 3, 4, 4};

        Solution81 s = new Solution81();
        for (int i = 0;i < array.length;i++){
            System.out.println(s.search(array,array[i]));
        }

        System.out.println("===========================");


        for (int i = 0;i < array.length;i++){
            System.out.println(s.search(array,array[i]+9));
        }
        System.out.println("===========================");

        for (int i = 0;i < array.length;i++){
            System.out.println(s.search(array,array[i]-9));
        }
    }
}
