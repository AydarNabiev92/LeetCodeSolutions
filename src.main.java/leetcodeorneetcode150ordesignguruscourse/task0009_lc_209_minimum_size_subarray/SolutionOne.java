package leetcodeorneetcode150ordesignguruscourse.task0009_lc_209_minimum_size_subarray;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/minimum-size-subarray-sum/description/
        // Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
        // sum is greater than or equal to target. If there is no such subarray, return 0 instead.
        // Example 1:
        // Input: target = 7, nums = [2,3,1,2,4,3]
        // Output: 2
        // Explanation: The subarray [4,3] has the minimal length under the problem constraint.
        // Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
        System.out.println(minSubArrayLen(4, new int[]{1,4,4})); // 1
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})); // 0
        System.out.println(minSubArrayLen(80, new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8})); // 6
    }

    /*public static int minSubArrayLen(int target, int[] nums) {
        // MY SOLUTION
        int left = 0;
        int currentSum = nums[left];
        Integer bestFound = null;
        if (currentSum >= target) {
            bestFound = 1;
        }
        int right;
        for (right = 0; right < nums.length; right++) {
            if (left == right) {
                currentSum = nums[left];
            } else {
                currentSum = currentSum + nums[right];
            }
            if (currentSum >= target) {
                if (Objects.isNull(bestFound) || right - left + 1 < bestFound) {
                    bestFound = right - left + 1;
                }
                // move the left part
                while (left < right && currentSum >= target) {
                    currentSum = currentSum - nums[left];
                    left++;
                    if (currentSum >= target && right - left + 1 < bestFound) {
                        bestFound = right - left + 1;
                    }
                }
            }
        }
        // only change if case is fulfilled
        if (Objects.nonNull(bestFound) && (currentSum >= target && currentSum < bestFound)) {
            bestFound = right - left + 1;
        }

        return Objects.isNull(bestFound) ? 0 : bestFound;
    }*/

    // TOP SOLUTION
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
