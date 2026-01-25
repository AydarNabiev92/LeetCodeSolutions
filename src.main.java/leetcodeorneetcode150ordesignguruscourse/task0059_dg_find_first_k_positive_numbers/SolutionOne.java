package leetcodeorneetcode150ordesignguruscourse.task0059_dg_find_first_k_positive_numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-3-find-the-first-k-missing-positive-numbers-hard
        // Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.
        //Example 1:
        //Input: [3, -1, 4, 5, 5], k=3
        //Output: [1, 2, 6]
        //Explanation: The smallest missing positive numbers are 1, 2 and 6.
        //Example 2:
        //Input: [2, 3, 4], k=3
        //Output: [1, 5, 6]
        //Explanation: The smallest missing positive numbers are 1, 5 and 6.
        //Example 3:
        //Input: [-2, -3, 4], k=2
        //Output: [1, 2]
        //Explanation: The smallest missing positive numbers are 1 and 2.
        System.out.println(findNumbers(new int[]{3, -1, 4, 5, 5}, 3)); // [1, 2, 6]
        System.out.println(findNumbers(new int[]{2, 3, 4}, 3)); // [1, 5, 6]
        System.out.println(findNumbers(new int[]{-2, -3, 4}, 2)); // [1, 2]
    }

    public static List<Integer> findNumbers(int[] nums, int k) {
        // this is my version of the given solution by memory. step 3 is slightly different in the implementation
        int i = 0;

        // Step 1: Rearrange elements in the array to their correct positions
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();

        // Step 2: Find missing numbers up to 'k' by comparing each element to its position
        for (i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                missingNumbers.add(i + 1);
                extraNumbers.add(nums[i]);
                k--;
                if (k == 0) {
                    break;
                }
            }
        }

        // Step 3: Add the remaining missing numbers if needed
        if (k == 0) {
            return missingNumbers;
        }
        i = 1;
        while (k > 0) {
            int newNumber = i + nums.length;
            if (!extraNumbers.contains(newNumber)) {
                missingNumbers.add(newNumber);
                k--;
            }
            i++;
        }


        return missingNumbers;
    }

    public static List<Integer> findNumbersDesignGurusSolution(int[] nums, int k) {
        int i = 0;

        // Step 1: Rearrange elements in the array to their correct positions
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();

        // Step 2: Find missing numbers up to 'k' by comparing each element to its position
        for (i = 0; i < nums.length && missingNumbers.size() < k; i++) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
                extraNumbers.add(nums[i]);
            }
        }

        // Step 3: Add the remaining missing numbers if needed
        for (i = 1; missingNumbers.size() < k; i++) {
            int candidateNumber = i + nums.length;

            // Ignore if the array contains the candidate number
            if (!extraNumbers.contains(candidateNumber)) {
                missingNumbers.add(candidateNumber);
            }
        }

        return missingNumbers;
    }

    public static List<Integer> findNumbersMyFirstInstinctSolution(int[] nums, int k) {
        // the problem - creates potentially huge cyclic array and doesn't work in space with nums
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            size = Math.max(size, nums[i]);
        }

        int[] cyclic = new int[size];
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= cyclic.length) {
                cyclic[nums[i] - 1] = nums[i];
            }
            i++;
        }

        List<Integer> result = new ArrayList<>();

        for (int j = 0; j < cyclic.length; j++) {
            if (j + 1 != cyclic[j]) {
                result.add(j + 1);
                k--;
                if (k == 0) {
                    return result;
                }
            }
        }

        int addition = 1;
        while (k > 0) {
            result.add(cyclic.length + addition);
            k--;
            addition++;
        }

        return result;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

