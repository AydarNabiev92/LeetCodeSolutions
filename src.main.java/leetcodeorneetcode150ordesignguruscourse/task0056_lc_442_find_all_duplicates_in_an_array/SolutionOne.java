package leetcodeorneetcode150ordesignguruscourse.task0056_lc_442_find_all_duplicates_in_an_array;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/find-all-duplicate-numbers-easy
        // difference for DG is that you need to add all duplicates, meaning instead of [2,3] it would be [3,2,2,3]
        // https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
        // Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer
        // appears at most twice, return an array of all the integers that appears twice.
        //You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space
        // needed to store the output
        //Example 1:
        //Input: nums = [4,3,2,7,8,2,3,1]
        //Output: [2,3]
        //Example 2:
        //Input: nums = [1,1,2]
        //Output: [1]
        //Example 3:
        //Input: nums = [1]
        //Output: []
        System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1})); // [2,3]
        System.out.println(findDuplicates(new int[]{1,1,2})); // [1]
        System.out.println(findDuplicates(new int[]{1})); // []
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        List<Integer> duplicateNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicateNumbers.add(nums[i]);
            }
        }

        return duplicateNumbers;
    }

    public static List<Integer> findDuplicatesMySolution(int[] nums) {
        // supposedly it's slower somehow
        List<Integer> result = new ArrayList<>();
        if (nums.length < 2) {
            return result;
        }

        int i = 0;
        while (i < nums.length) {
            // from 1 to n, when indices work from 0 to n - 1. so 1 must stand in 0th place, 2 in 1st, etc
            // then, I also have to determine duplicates
            int correctValue = i + 1;
            if (correctValue != nums[i]) { // that means that it stands in an incorrect place
                // current incorrect value must be put to its value - 1 (1 must be put to 0)
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    if (!result.contains(nums[i])) {
                        result.add(nums[i]);
                    }
                    i++;
                }
            } else {
                i++;
            }
        }

        return result;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

