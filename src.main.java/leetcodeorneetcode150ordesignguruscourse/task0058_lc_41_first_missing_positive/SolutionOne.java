package leetcodeorneetcode150ordesignguruscourse.task0058_lc_41_first_missing_positive;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-2-find-the-smallest-missing-positive-number-medium
        // https://leetcode.com/problems/first-missing-positive/description/
        // Given an unsorted array containing numbers, find the smallest missing positive number in it.
        //Note: Positive numbers start from '1'.
        //Example 1:
        //Input: [-3, 1, 5, 4, 2]
        //Output: 3
        //Explanation: The smallest missing positive number is '3'
        //Example 2:
        //Input: [3, -2, 0, 1, 2]
        //Output: 4
        //Example 3:
        //Input: [3, 2, 5, 1]
        //Output: 4
        //Example 4:
        //Input: [33, 37, 5]
        //Output: 1
        System.out.println(firstMissingPositive(new int[]{-3, 1, 5, 4, 2})); // 3
        System.out.println(firstMissingPositive(new int[]{3, -2, 0, 1, 2})); // 4
        System.out.println(firstMissingPositive(new int[]{3, 2, 5, 1})); // 4
        System.out.println(firstMissingPositive(new int[]{33, 37, 5})); // 1
        System.out.println(firstMissingPositive(new int[]{1, 1})); // 2
    }

    public static int firstMissingPositive(int[] nums) {
        // we can take its length and make a new array based on that length. then we go through the original and assign
        // it to the new array (as long as value is not negative or out of bound for the new array meaning not bigger than
        // length. then the first wrong value for its index is our smallest missing positive number
        // but since our spacewise decision must be O(1), maybe we can't create new array, we just get rid of all negative
        // and out of bounds members (fill their spaces with 0 or do not touch them?). then we check
        int i = 0;
        while (i < nums.length) {
            // last condition is there because there can be duplicates - we avoid infinite loop
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                return j + 1;
            }
        }

        // if all members are fine, then first missing will be right after them
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

