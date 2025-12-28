package leetcodeorneetcode150ordesignguruscourse.task0024_designgurus_pair_with_target_sum;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/pair-with-target-sum-easy
        // Given an array of numbers sorted in ascending order and a target sum, find a pair in the array whose sum is equal to the given target.
        //Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target. If no such pair exists return [-1, -1].
        //Example 1:
        //Input: [1, 2, 3, 4, 6], target=6
        //Output: [1, 3]
        //Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
        System.out.println(Arrays.toString(search(new int[]{1, 2, 3, 4, 6}, 6))); // [1, 3]
        System.out.println(Arrays.toString(search(new int[]{2, 5, 9, 11}, 11))); // [0, 2]
        System.out.println(Arrays.toString(search(new int[]{1, 2, 3, 4, 6}, 6))); // [1, 3]
        System.out.println(Arrays.toString(search(new int[]{0, 1, 2, 3, 4}, 0))); // [-1, -1]
    }

    public static int[] search(int[] arr, int targetSum) {
        // two pointers. if sum is bigger than end we make right pointer smaller, if smaller we make left bigger
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum > targetSum) {
                right--;
            } else if (sum < targetSum) {
                left++;
            } else {
                return new int[] {left, right};
            }
        }

        return new int[] {-1, -1};
    }
}
