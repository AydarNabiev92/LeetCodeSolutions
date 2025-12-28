package leetcodeorneetcode150ordesignguruscourse.task0025_lc_26_remove_duplicates_from_sorted_array;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/find-nonduplicate-number-instances-easy
        // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/ not really the same according to chatgpt
        // Given an array of sorted numbers, move all non-duplicate number instances at the beginning of the array in-place.
        // The non-duplicate numbers should be sorted and you should not use any extra space so that the solution has constant space complexity i.e.,
        //Move all the unique number instances at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.
        //Example 1:
        //Input: [2, 3, 3, 3, 6, 9, 9]
        //Output: 4
        //Explanation: The first four elements after moving element will be [2, 3, 6, 9].
        //Example 2:
        //Input: [2, 2, 2, 11]
        //Output: 2
        //Explanation: The first two elements after moving elements will be [2, 11].
        System.out.println(moveElements(new int[]{2, 3, 3, 3, 6, 9, 9})); // 4
        System.out.println(moveElements(new int[]{2, 2, 2, 11})); // 2
        System.out.println(moveElements(new int[]{1, 1, 2})); // 2
        System.out.println(moveElements(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})); // 5
        System.out.println(moveElements(new int[]{1, 1, 2})); // 2
        System.out.println(moveElements(new int[]{1, 1})); // 1
        System.out.println(moveElements(new int[]{1, 2})); // 2
    }

    public static int moveElements(int[] arr) {
        // can one of the pointers hold the first duplicate position while the other pointer find the first non unique
        // next number? then they are swapped and the cycle continues
        // well what happens after the first swap? for example 2, 3, 4, 3, 5, 6, 7
        if (arr.length == 1) {
            return 1;
        }

        int left = 0;
        int right = 0;
        while (right < arr.length - 1) {
            System.out.println("Start of while: Array is " + Arrays.toString(arr) + ", left is " + arr[left] + " right is " + arr[right]);
            // left stays at the second non unique, right catches the next change. then we swap
            // after that left needs to check how much it needs to move by checking its new value with the previous indice
            while (left < arr.length - 1
                    && arr[left] != arr[left + 1]
                    && arr[left] < arr[left + 1]
            ) {
                left++;
            }
            left++;
            // I need to determine right as the first new value but also do not mix it up with left
            while (right < arr.length - 1
                    && (arr[right] == arr[right + 1] || (left < arr.length && arr[left] > arr[right]))
            ) {
                right++;
            }
            // there is also a general rule that I can't go out of array's bounds. how do i make sure of that?
            // can I do it by keeping the last couple of elements and then do one special piece of logic for them?
            if (right != arr.length - 1) {
                right++;
            }
            if (right != arr.length + 1 && left < arr.length && right != arr.length && arr[left] != arr[right]) {
                System.out.println("Before swap: Array is " + Arrays.toString(arr) + ", left is " + left + " right is " + right);
                arr[left] = arr[right];
                while (arr[left] < arr[left + 1]) {
                    left++;
                }
            }
        }
        if (right != arr.length && left < arr.length) {
            System.out.println("Before swap: Array is " + Arrays.toString(arr) + ", left is " + left + " right is " + right);
            arr[left] = arr[right];
        }
        while (left != 0 && left < arr.length && arr[left] == arr[left - 1]) {
            left--;
        }
        while (left < arr.length - 1 && arr[left] < arr[left + 1]) {
            left++;
        }

        return (left == arr.length - 1 || left == arr.length) ? left : left + 1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length - 1) {
            // left stays at the second non unique, right catches the next change. then we swap
            // after that left needs to check how much it needs to move by checking its new value with the previous indice
            while (left < nums.length - 1
                    && nums[left] != nums[left + 1]
                    && nums[left] < nums[left + 1]
            ) {
                left++;
            }
            left++;
            // I need to determine right as the first new value but also do not mix it up with left
            while (right < nums.length - 1
                    && (nums[right] == nums[right + 1] || (left < nums.length && nums[left] > nums[right]))
            ) {
                right++;
            }
            // there is also a general rule that I can't go out of array's bounds. how do i make sure of that?
            // can I do it by keeping the last couple of elements and then do one special piece of logic for them?
            if (right != nums.length - 1) {
                right++;
            }
            if (right != nums.length + 1 && left < nums.length && right != nums.length && nums[left] != nums[right]) {
                nums[left] = nums[right];
                while (nums[left] < nums[left + 1]) {
                    left++;
                }
            }
        }
        if (right != nums.length && left < nums.length) {
            nums[left] = nums[right];
        }
        while (left != 0 && left < nums.length && nums[left] == nums[left - 1]) {
            left--;
        }
        while (left < nums.length - 1 && nums[left] < nums[left + 1]) {
            left++;
        }

        return (left == nums.length - 1 || left == nums.length) ? left : left + 1;
    }
}
