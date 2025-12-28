package leetcodeorneetcode150ordesignguruscourse.task0026_lc_27_remove_element;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/remove-element/description/
        // Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
        //Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
        //Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
        //Return k.
        // Example 1:
        //Input: nums = [3,2,2,3], val = 3
        //Output: 2, nums = [2,2,_,_]
        //Explanation: Your function should return k = 2, with the first two elements of nums being 2.
        //It does not matter what you leave beyond the returned k (hence they are underscores).
        System.out.println(removeElement(new int[]{3,2,2,3}, 3)); // 2
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2)); // 5
    }

    public static int removeElement(int[] nums, int val) {
        int current = 0;
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != val) {
                nums[current] = nums[read];
                current++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return current;
    }
}
