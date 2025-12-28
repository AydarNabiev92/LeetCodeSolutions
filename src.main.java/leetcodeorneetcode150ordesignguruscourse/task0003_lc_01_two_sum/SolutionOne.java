package leetcodeorneetcode150ordesignguruscourse.task0003_lc_01_two_sum;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/two-sum/
        // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        // You may assume that each input would have exactly one solution, and you may not use the same element twice.
        // You can return the answer in any order.

        // Example 1:
        // Input: nums = [2,7,11,15], target = 9
        // Output: [0,1]
        // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        int[] num1 = {2,7,11,15};
        System.out.println("Expected [0, 1], actual - " + Arrays.toString(twoSum(num1, 9)));

        // Example 2:
        // Input: nums = [3,2,4], target = 6
        // Output: [1,2]
        int[] num2 = {3, 2, 4};
        System.out.println("Expected [1, 2], actual - " + Arrays.toString(twoSum(num2, 6)));

        // Example 3:
        // Input: nums = [3,3], target = 6
        // Output: [0,1]
        int[] num3 = {3, 3};
        System.out.println("Expected [0, 1], actual - " + Arrays.toString(twoSum(num3, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // Go through the array
        for (int i = 0; i <= nums.length - 1; i++) {
            int candidate = nums[i];
            // Check it against others, don't sum it with itself
            for (int j = i + 1; j <= nums.length - 1; j++) {
                int candidateSoulmate = nums[j];
                if (target - candidate == candidateSoulmate) {
                    return new int[]{i, j};
                }
            }
        }

        // This isn't the solution, but the task seems to always give nums with required elements for target
        return new int[]{0, 0};
    }
}
