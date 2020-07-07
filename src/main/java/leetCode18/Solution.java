package leetCode18;

import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

//    给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
//    注意：
//
//    答案中不可以包含重复的四元组。
//
//    示例：
//
//    给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//    满足要求的四元组集合为：
//            [
//            [-1,  0, 0, 1],
//            [-2, -1, 1, 2],
//            [-2,  0, 0, 2]
//            ]



    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = nums.length;

        if (nums == null || len < 4) {
            return ans;
        }


        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int threeSumTarget = target - nums[i];

            for (int j = i+1; j < len-2; j++) {
                //去重
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = len - 1;

                while (left < right) {
                    int sum = nums[j] + nums[left] + nums[right];
                    if (sum == threeSumTarget) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < threeSumTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> a = new Solution().fourSum(new int[]{1,3,3,5,-2,-3,-4,-5},-11);
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size() ; j++) {
                System.out.printf("  %d  ",a.get(i).get(j));
            }

            System.out.println();
        }
    }
}
