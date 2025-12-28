package leetcodeorneetcode150ordesignguruscourse.task0009_lc_209_minimum_size_subarray;

public class SolutionTwoLaterRetry {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/smallest-subarray-with-a-greater-sum-easy
        // https://leetcode.com/problems/minimum-size-subarray-sum/description/
        // Given an array of positive integers nums and a positive integer target, return the minimal length of a
        //whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
        //Example 1:
        //Input: target = 7, nums = [2,3,1,2,4,3]
        //Output: 2
        //Explanation: The subarray [4,3] has the minimal length under the problem constraint.
        //Example 2:
        //Input: target = 4, nums = [1,4,4]
        //Output: 1
        //Example 3:
        //Input: target = 11, nums = [1,1,1,1,1,1,1,1]
        //Output: 0
        // Constraints:
        //    1 <= target <= 109
        //    1 <= nums.length <= 105
        //    1 <= nums[i] <= 104
        //Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
        System.out.println(minSubArrayLen(4, new int[]{1,4,4})); // 1
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})); // 0
        System.out.println(minSubArrayLen(80, new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8})); // 6
        System.out.println(minSubArrayLen(6, new int[]{10,2,3})); // 1
    }

    public int findMinSubArray(int S, int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            if (arr[0] >= S) {
                return 1;
            } else {
                return 0;
            }
        }

        // use sliding window
        int left = 0;
        int right = 0;
        int sum = arr[left];
        int minLengthFound = (sum >= S) ? 1 : 0;

        // sum is getting smaller while left moves to the right
        // sum is getting bigger while right moves to the right
        for (right = 1; right < arr.length; right++) {
            // adjust left if sum is too small
            sum = sum + arr[right];
            if (sum >= S) {
                minLengthFound = minLengthFound == 0 ? right - left + 1 : Math.min(minLengthFound, right - left + 1);
                while (left < right && sum >= S) {
                    sum = sum - arr[left];
                    left++;
                    if (sum >= S) {
                        minLengthFound = minLengthFound == 0 ? right - left + 1 : Math.min(minLengthFound, right - left + 1);
                    }
                }
            }
        }

        return minLengthFound;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] >= target) {
                return 1;
            } else {
                return 0;
            }
        }

        // use sliding window
        int left = 0;
        int right = 0;
        int sum = nums[left];
        int minLengthFound = (sum >= target) ? 1 : 0;

        // sum is getting smaller while left moves to the right
        // sum is getting bigger while right moves to the right
        for (right = 1; right < nums.length; right++) {
            // adjust left if sum is too small
            sum = sum + nums[right];
            if (sum >= target) {
                minLengthFound = minLengthFound == 0 ? right - left + 1 : Math.min(minLengthFound, right - left + 1);
                while (left < right && sum >= target) {
                    sum = sum - nums[left];
                    left++;
                    if (sum >= target) {
                        minLengthFound = minLengthFound == 0 ? right - left + 1 : Math.min(minLengthFound, right - left + 1);
                    }
                }
            }
        }

        return minLengthFound;
    }
}
