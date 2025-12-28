package leetcodeorneetcode150ordesignguruscourse.task0030_lc_259_three_sum_smaller;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/triplets-with-smaller-sum-medium
        // https://leetcode.com/problems/3sum-smaller/description/
        // Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
        // arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.
        // Example 1:
        //Input: [-1, 0, 2, 3], target=3
        //Output: 2
        //Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
        // Example 2:
        //Input: [-1, 4, 2, 1, 3], target=5
        //Output: 4
        //Explanation: There are four triplets whose sum is less than the target:
        //[-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
        // Constraints:
        //    n == arr.length
        //    0 <= n <= 3500
        //    -100 <= arr[i] <= 100
        //    -100 <= target <= 100
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3)); // 2
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5)); // 4
        System.out.println(searchTriplets(new int[]{0, 0, 0, 0, 0}, 1)); // 10
    }

    public static int searchTriplets(int[] arr, int target) {
        // the same approach?
        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i <= arr.length - 3; i++) {
            int firstElement = arr[i];
            int requiredToBeLessThanThis = target - firstElement;

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                // the rotation needs to be smart - remember that when sum is too small we increase left, if it's
                // too big we move right. in this case if our sum is smaller than target then we need to increase count
                // and change left. but what can help us increase the speed is if our sum is already too small then
                // everything between left and right is valid for target
                // so do we only move right?
                int twoSum = arr[left] + arr[right];
                if (twoSum >= requiredToBeLessThanThis) {
                    right--;
                } else {
                    // [-1, 4, 2, 1, 3], target=5
                    // [-1, 1, 2, 3, 4], target=5
                    // -1 -> 6, [1, 2, 3, 4]
                    count = count + (right - left);
                    left++;
                }
            }
        }

        return count;
    }
}
