package leetcodeorneetcode150ordesignguruscourse.task0043_lc_643_maximum_average_subarray_first;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/maximum-sum-subarray-of-size-k-easy
        // https://leetcode.com/problems/maximum-average-subarray-i/description/
        // You are given an integer array nums consisting of n elements, and an integer k.
        //Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
        // Any answer with a calculation error less than 10times-5 will be accepted.
        //Example 1:
        //Input: nums = [1,12,-5,-6,50,3], k = 4
        //Output: 12.75000
        //Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
        //Example 2:
        //Input: nums = [5], k = 1
        //Output: 5.00000
        //Constraints:
        //n == nums.length
        //1 <= k <= n <= 105
        //-104 <= nums[i] <= 104
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4)); // 12.75000
        System.out.println(findMaxAverage(new int[]{5}, 1)); // 5.00000
        System.out.println(findMaxAverage(new int[]{-1}, 1)); // -1.00000
    }

    public int findMaxSumSubArray(int k, int[] arr) {
        // create first subarray?
        int left = 0;
        int right = k - 1;
        int currentWindow = 0;
        int maxSumFound = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            currentWindow = currentWindow + arr[i];
        }
        if (currentWindow > maxSumFound) {
            maxSumFound = currentWindow;
        }

        // sliding window
        while (right < arr.length - 1) {
            currentWindow = currentWindow - arr[left];
            left++;
            right++;
            currentWindow = currentWindow + arr[right];
            if (currentWindow > maxSumFound) {
                maxSumFound = currentWindow;
            }
        }

        return maxSumFound;
    }

    public static double findMaxAverage(int[] nums, int k) {
        // create first subarray?
        int left = 0;
        int right = k - 1;
        double currentWindow = 0;
        double maxAverage = -Double.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            currentWindow = currentWindow + nums[i];
        }
        if (currentWindow / k > maxAverage) {
            maxAverage = currentWindow / k;
        }

        // sliding window
        while (right < nums.length - 1) {
            currentWindow = currentWindow - nums[left];
            left++;
            right++;
            currentWindow = currentWindow + nums[right];
            if (currentWindow / k > maxAverage) {
                maxAverage = currentWindow / k;
            }
        }

        return maxAverage;
    }
}
