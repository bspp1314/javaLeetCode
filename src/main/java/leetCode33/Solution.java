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
    //4,5,6,7,8,9,10,11,12,0,12
    //nums = [4,5,6,7,0,1,2], target = 0
    public int search(int[] nums, int target) {
        int m = 0;
        int i = 1;
        int j = 0;
        int len = nums.length;
        while (true) {
            int tmp = (int)Math.pow(2,m+1);
            if (tmp >= nums.length) {
                i = j+1;
                m = 0;
            }else if (tmp == (nums.length -1)){
                break;
            }else{
                System.out.println("i value is "+i);
                System.out.println("nums len is " + nums.length);
                if(nums[i] < nums[i-1]) {
                    break;
                }else{
                    if (nums[i] < nums[j]) {
                        i = j+1;
                        m = 0;
                    }else{
                        m++;
                        i = (int) (j + Math.pow(2,m)+1);
                    }
                }
            }
        }


        int res = binarySearch(nums,0,i-1,target);
        if (res > 0){
            return res;
        }
        return binarySearch(nums,i,nums.length,target);
    }

    public static void main(String[] args) {
        int[] array = {0,4,5,6,7,8,9,10};

        Solution s = new Solution();
        s.search(array,0);
    }
}
