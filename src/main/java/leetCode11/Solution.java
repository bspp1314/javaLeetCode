package leetCode11;

public class Solution {
    //双指针法
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int maxArea = 0;

        while (i < j) {
            int newArea = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
            maxArea = maxArea > newArea ? maxArea : newArea;

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;

    }

    public static void main(String[] args) {

    }
}
