package leetcodeorneetcode150ordesignguruscourse.task0054_lc_448_find_all_numbers_disappeared_in_an_array;

import java.util.*;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/find-all-missing-numbers-easy
        // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
        // We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates,
        // which means some numbers will be missing. Find all those missing numbers.
        //Example 1:
        //Input: [2, 3, 1, 8, 2, 3, 5, 1]
        //Output: 4, 6, 7
        //Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
        //Example 2:
        //Input: [2, 4, 1, 2]
        //Output: 3
        //Example 3:
        //Input: [2, 3, 2, 1]
        //Output: 4
        System.out.println(findDisappearedNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1})); // 4, 6, 7
        System.out.println(findDisappearedNumbers(new int[]{2, 4, 1, 2})); // 3
        System.out.println(findDisappearedNumbers(new int[]{2, 3, 2, 1})); // 4
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // let's say we meet a duplicate. do we ignore it then?
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) { // extra condition?
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(j + 1);
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

