package leetcodeorneetcode150ordesignguruscourse.task0029_lc_16_three_sum_closest;

import java.util.Arrays;

public class SolutionTwo {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/triplet-sum-close-to-target-medium
        // https://leetcode.com/problems/3sum-closest/description/
        // Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
        //Return the sum of the three integers.
        //You may assume that each input would have exactly one solution.
        //Example 1:
        //Input: nums = [-1,2,1,-4], target = 1
        //Output: 2
        //Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
        //Example 2:
        //Input: nums = [0,0,0], target = 1
        //Output: 0
        //Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1)); // 2
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1)); // 0
        System.out.println(threeSumClosest(new int[]{10,20,30,40,50,60,70,80,90}, 1)); // 60
    }

    public static int threeSumClosest(int[] nums, int target) {
        // sorting and using two pointers seems to be a given
        // the main challenge seems to be that we can encounter a situation when target is not hit, but we need to track the closes to the target
        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int firstElement = nums[i];
            int requiredForSum = target - firstElement;

            // now, two pointer
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int actualSum = nums[left] + nums[right];
                // how do i move left and right? maybe i need to move them one by one instead of looking if I'm closer to it?
                // but i definitely need to return their sum if it hit the target
                if (actualSum == requiredForSum) {
                    return target;
                } else if (actualSum > requiredForSum) {
                    // update closest correctly, it must closest to the target
                    if (target - closest  > target - (firstElement + actualSum)) {
                        closest = firstElement + actualSum;
                    }
                    right--;
                } else {
                    if (target - closest > target - (firstElement + actualSum)) {
                        closest = firstElement + actualSum;
                    }
                    left++;
                }
            }
        }

        return closest;
    }
}
