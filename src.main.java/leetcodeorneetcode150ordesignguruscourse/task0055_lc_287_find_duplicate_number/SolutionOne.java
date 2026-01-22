package leetcodeorneetcode150ordesignguruscourse.task0055_lc_287_find_duplicate_number;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/find-the-duplicate-number-easy
        // https://leetcode.com/problems/find-the-duplicate-number/description/
        // iven an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
        //There is only one repeated number in nums, return this repeated number.
        //You must solve the problem without modifying the array nums and using only constant extra space.
        //Example 1:
        //Input: nums = [1,3,4,2,2]
        //Output: 2
        //Example 2:
        //Input: nums = [3,1,3,4,2]
        //Output: 3
        //Example 3:
        //Input: nums = [3,3,3,3,3]
        //Output: 3
        System.out.println(findDuplicate(new int[]{3,1,3,4,2})); // 3
        System.out.println(findDuplicate(new int[]{1,3,4,2,2})); // 2
        System.out.println(findDuplicate(new int[]{3,3,3,3,3})); // 3
    }

    public static int findDuplicate(int[] nums) {
        int index = 0;
        while (index < nums.length) {

            if (nums[index] != index + 1) {  // Check if the current element is in its correct position
                if (nums[index] != nums[nums[index] - 1]) { // Check if there is a duplicate at the current position
                    swap(nums, index, nums[index] - 1);  // Swap elements to their correct positions
                } else {
                    // We have found the duplicate
                    return nums[index]; // Return the duplicate number
                }
            } else {
                index++; // Move to the next element
            }

        }

        return 0;
    }

    public static int findDuplicateMySolution(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1; // 2
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                return nums[j];
            }
        }

        return 0;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

