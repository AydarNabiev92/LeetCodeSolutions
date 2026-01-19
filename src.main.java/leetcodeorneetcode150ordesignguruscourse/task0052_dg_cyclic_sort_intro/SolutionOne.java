package leetcodeorneetcode150ordesignguruscourse.task0052_dg_cyclic_sort_intro;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/cyclic-sort-easy
        // We are given an array containing n objects. Each object, when created, was assigned a unique number from the
        // range 1 to n based on their creation sequence. This means that the object with sequence number 3 was created
        // just before the object with sequence number 4.
        //Write a function to sort the objects in-place on their creation sequence number in  without using any extra space.
        // For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each
        // number is actually an object.
        //Example 1:
        //Input: [3, 1, 5, 4, 2]
        //Output: [1, 2, 3, 4, 5]
        //Example 2:
        //Input: [2, 6, 4, 3, 1, 5]
        //Output: [1, 2, 3, 4, 5, 6]
        // Constraints:
        //n == nums.length
        //1 <= n <=
        //0 <= nums[i] <= n
        System.out.println(Arrays.toString(sort(new int[]{3, 1, 5, 4, 2}))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(sort(new int[]{2, 6, 4, 3, 1, 5}))); // [1, 2, 3, 4, 5, 6]
    }

    public static int[] sort(int[] nums) {
        // designGurus/canon way
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                // swap
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] sortMyWay(int[] nums) {
        // my solution without looking
        // go indice by indice
        // if it's in wrong place, swap and work with a what was swapped
        // if it's in right place, go on
        for (int i = 0; i < nums.length; i++) {
            // value 1 goes to indice 0, value 2 goes to indice 1, value 3 goes to indice 2, etc.
            // meaning - VALUE IS ALWAYS INDICE+1
            int current = nums[i]; // example, 3 = nums[0]
            while (current != i + 1) { // 3 != 1
                int temp = nums[current - 1]; // 5 = nums[3-1]
                nums[current - 1] = current; // nums[3-1=2] = 3
                nums[i] = temp; // nums[0] = 5
                current = nums[i]; // current = nums[0] -> now it's 5
            }
        }

        return nums;
    }
}
