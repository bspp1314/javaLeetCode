package leetCode33;

public class Solution {
    public static int binarySearch(int[] arr, int start, int end, int hkey){
        int result = -1;

        while (start <= end){
            int mid = start + (end - start)/2;    //防止溢位
            if (arr[mid] > hkey)
                end = mid - 1;
            else if (arr[mid] < hkey)
                start = mid + 1;
            else {
                result = mid ;
                break;
            }
        }

        return result;

    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return  -1;
        }

        if (nums.length == 1){
            return  nums[0] == target ? 0:-1;
        }

        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            int mid = left + (right -left) / 2;
            if (nums[mid] == target)  {
                return mid;
            }

            if (nums[mid] > nums[0]) {
                if (nums[0] <= target && target < nums[mid] ) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[nums.length-1]) {
                    left = mid + 1;
                }else{
                    right = mid -1 ;
                }
            }
        }

        return  -1;

    }


    public static void main(String[] args) {
        int[] array = {4,5,6,7,8,9,10,1,2,3};

        Solution s = new Solution();
        int a = s.search(array,1);
        for (int i = 0;i < array.length;i++){
            System.out.println(s.search(array,array[i]));
        }
    }
}
