package leetcodeorneetcode150ordesignguruscourse.task0031_lc_75_sort_colors;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/dutch-national-flag-problem-medium
        // https://leetcode.com/problems/sort-colors/description/
        // Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
        // color are adjacent, with the colors in the order red, white, and blue.
        //We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
        //You must solve this problem without using the library's sort function.
        //Example 1:
        //Input: nums = [2,0,2,1,1,0]
        //Output: [0,0,1,1,2,2]
        //Example 2:
        //Input: nums = [2,0,1]
        //Output: [0,1,2]
        sortColors(new int[]{2,0,2,1,1,0}); // [0,0,1,1,2,2]
        sortColors(new int[]{2,0,1}); // [0,1,2]
    }

    public static void sortColors(int[] nums) {
        // all 0s are BEFORE left, all 2s are AFTER right. that way 1s are between left and right
        if (nums.length == 1) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i <= right;) {
            int current = nums[i];
            if (current == 1) {
                i++;
            } else if (current == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                i++;
                left++;
            } else if (current == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            }
        }

        System.out.println(Arrays.toString(nums));

    }

    //    public int[] sort(int[] arr) {
//        // accepted for leetcode but not for designgurus
//        if (arr.length == 1) {
//            return arr;
//        }
//        int count0 = 0;
//        int count1 = 0;
//        int count2 = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int current = arr[i];
//            if (current == 0) {
//                count0++;
//            } else if (current == 1) {
//                count1++;
//            } else {
//                count2++;
//            }
//        }
//        for (int i = 0; i < count0; i++) {
//            arr[i] = 0;
//        }
//        for (int i = count0; i < count0 + count1; i++) {
//            arr[i] = 1;
//        }
//        for (int i = count0 + count1; i < count0 + count1 + count2; i++) {
//            arr[i] = 2;
//        }
//
//        return arr;
//    }
}
