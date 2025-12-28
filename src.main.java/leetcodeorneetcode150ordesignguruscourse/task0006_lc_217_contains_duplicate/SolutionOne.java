package leetcodeorneetcode150ordesignguruscourse.task0006_lc_217_contains_duplicate;

import java.util.HashSet;
import java.util.Set;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/contains-duplicate/description/

        // Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

        //Example 1:
        //Input: nums = [1,2,3,1]
        //Output: true
        //Explanation:
        //The element 1 occurs at the indices 0 and 3.
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> metBefore = new HashSet<>();
        for (int candidate : nums) {
            if (metBefore.contains(candidate)) {
                return true;
            } else {
                metBefore.add(candidate);
            }
        }

        return false;
    }
}
