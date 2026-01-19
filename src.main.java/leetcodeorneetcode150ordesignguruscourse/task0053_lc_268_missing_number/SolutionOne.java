package leetcodeorneetcode150ordesignguruscourse.task0053_lc_268_missing_number;

import java.util.HashMap;
import java.util.Map;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/find-the-missing-number-easy
        // https://leetcode.com/problems/missing-number/description/
        // 268. Missing Number
        //Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
        //Example 1:
        //Input: nums = [3,0,1]
        //Output: 2
        //Explanation:
        //n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
        //Example 2:
        //Input: nums = [0,1]
        //Output: 2
        //Explanation:
        //n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
        //Example 3:
        //Input: nums = [9,6,4,2,3,5,7,0,1]
        //Output: 8
        //Explanation:
        //n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
        System.out.println(missingNumber(new int[]{3,0,1})); // 2
        System.out.println(missingNumber(new int[]{0,1})); // 2
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // 8
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // because it is from 0 to n, not from 1 to n, meaning our value can get out of bounds, we have to ignore this number
            // number that is equal to length will be replaced by number which place it occupies
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }

        return nums.length;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int missingNumberMyFirstInstinctSolution(int[] nums) {
        // this is what I would've done without knowing cyclic sort
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            map.put(i, 1);
        }

        for (int i = 0; i < nums.length; i++) {
            map.remove(nums[i]);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            return entry.getKey();
        }

        return 0;
    }
}

