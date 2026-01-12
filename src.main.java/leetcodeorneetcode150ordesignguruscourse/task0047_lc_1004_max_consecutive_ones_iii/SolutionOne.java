package leetcodeorneetcode150ordesignguruscourse.task0047_lc_1004_max_consecutive_ones_iii;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/longest-subarray-with-ones-after-replacement-hard
        // https://leetcode.com/problems/max-consecutive-ones-iii/description/
        // Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length
        // of the longest contiguous subarray having all 1s.
        //Example 1:
        //Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
        //Output: 6
        //Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
        //Example 2:
        //Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
        //Output: 9
        //Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
        //Example 3:
        //Input: Array=[1, 0, 0, 1, 1, 0, 1, 1], k=2
        //Output: 6
        //Explanation: By flipping 0 at the second and fifth index in the list, we get [1, 0, 1, 1, 1, 1, 1, 1], which has 6 consecutive 1s.
        System.out.println(longestOnes(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2)); // 6
        System.out.println(longestOnes(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3)); // 9
        System.out.println(longestOnes(new int[]{1, 0, 0, 1, 1, 0, 1, 1}, 2)); // 6
    }

    public static int longestOnes(int[] nums, int k) {
        if (nums.length < 2) {
            return nums.length;
        }

        // even easier than the previous one? because it's just 1s and 0s. use boolean?
        int left = 0;
        int maxFound = 0;
        int currentZeros = 0;

        for (int right = 0; right < nums.length; right++) {
            int rightElement = nums[right];
            if (rightElement == 0) {
                currentZeros++;
            }

            if (currentZeros > k) {
                int leftElement = nums[left];
                if (leftElement == 0) {
                    currentZeros--;
                }
                left++;
            }

            maxFound = Math.max(right - left + 1, maxFound);
        }

        return maxFound;
    }

    public int findLength(int[] arr, int k) {
        if (arr.length < 2) {
            return arr.length;
        }

        // even easier than the previous one? because it's just 1s and 0s. use boolean?
        int left = 0;
        int maxFound = 0;
        int currentZeros = 0;

        for (int right = 0; right < arr.length; right++) {
            int rightElement = arr[right];
            if (rightElement == 0) {
                currentZeros++;
            }

            if (currentZeros > k) {
                int leftElement = arr[left];
                if (leftElement == 0) {
                    currentZeros--;
                }
                left++;
            }

            maxFound = Math.max(right - left + 1, maxFound);
        }

        return maxFound;
    }
}
