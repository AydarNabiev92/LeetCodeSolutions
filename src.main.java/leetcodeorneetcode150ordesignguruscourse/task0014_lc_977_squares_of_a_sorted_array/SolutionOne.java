package leetcodeorneetcode150ordesignguruscourse.task0014_lc_977_squares_of_a_sorted_array;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/squares-of-a-sorted-array/description/
        // Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
        //Example 1:
        //Input: nums = [-4,-1,0,3,10]
        //Output: [0,1,9,16,100]
        //Explanation: After squaring, the array becomes [16,1,0,9,100].
        //After sorting, it becomes [0,1,9,16,100].
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10}))); // [0, 1, 9, 16, 100]
    }

    public static int[] sortedSquares(int[] nums) {
        // left pointer (leftest element) and right pointer (rightest element)
        // compare them, biggest goes to the right of the resulting array (because they are competitors since smallest
        // negative is gonna be one of the biggest positive (which is relevant for squares)
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int resultPointer = nums.length - 1;

        // what's the condition for stopping? if left and right are equal?
        while (left != right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[resultPointer] = nums[left] * nums[left];
                left++;
            } else {
                result[resultPointer] = nums[right] * nums[right];
                right--;
            }

            resultPointer--;
        }
        result[resultPointer] = nums[left] * nums[left];

        return result;
    }

//    public static int[] sortedSquares(int[] nums) {
//        // my solution. it's not good because Arrays.sort
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//
//        Arrays.sort(nums);
//        return nums;
//    }
}
