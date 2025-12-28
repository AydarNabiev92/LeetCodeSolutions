package leetcodeorneetcode150ordesignguruscourse.task0032_lc_18_four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-1-quadruple-sum-to-target-medium
        // https://leetcode.com/problems/4sum/description/
        // Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
        //0 <= a, b, c, d < n
        //a, b, c, and d are distinct.
        //nums[a] + nums[b] + nums[c] + nums[d] == target
        //You may return the answer in any order.
        // Example 1:
        //Input: nums = [1,0,-1,0,-2,2], target = 0
        //Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)); // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        System.out.println(fourSum(new int[]{2, 2, 2, 2}, 8)); // [[2, 2, 2, 2]]
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296)); // []
    }

    public static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr.length < 4) {
            return result;
        }

        Arrays.sort(arr);

        // for 3 sum it was - find first element and then use two pointers for the rest. is this the three pointers problem?
        for (int i = 0; i <= arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int firstElement = arr[i];


            for (int j = i + 1; j <= arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int secondElement = arr[j];

                // now can we use two pointers?
                long requiredRemainsForSum = (long) target - firstElement - secondElement;

                int left = j + 1;
                int right = arr.length - 1;

                while (left < right) {
                    long actualRemainsForSum = (long) arr[left] + arr[right];

                    if (actualRemainsForSum > requiredRemainsForSum) {
                        right--;
                    } else if (actualRemainsForSum < requiredRemainsForSum) {
                        left++;
                    } else {
                        result.add(Arrays.asList(firstElement, secondElement, arr[left], arr[right]));

                        int currentLeftVal = arr[left];
                        int currentRightVal = arr[right];

                        // skip duplicates?
                        while (left < right && currentLeftVal == arr[left]) {
                            left++;
                        }
                        while (left < right && currentRightVal == arr[right]) {
                            right--;
                        }
                    }
                }
            }

        }

        return result;
    }
}
