package leetcodeorneetcode150ordesignguruscourse.task0012_lc_66_plus_one;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/plus-one/description/

        // You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
        // The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
        //Increment the large integer by one and return the resulting array of digits.
        //Example 1:
        //Input: digits = [1,2,3]
        //Output: [1,2,4]
        //Explanation: The array represents the integer 123.
        //Incrementing by one gives 123 + 1 = 124.
        //Thus, the result should be [1,2,4].
        // Example 3:
        //Input: digits = [9]
        //Output: [1,0]
        //Explanation: The array represents the integer 9.
        //Incrementing by one gives 9 + 1 = 10.
        //Thus, the result should be [1,0].
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3}))); // [1,2,4]
        System.out.println(Arrays.toString(plusOne(new int[]{9}))); // [1,0]
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9}))); // [1,0,0,0]
        System.out.println(Arrays.toString(plusOne(new int[]{1}))); // [2]
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        // we can only get here if we have digits[0] as 0 (because otherwise we returned array already
        // this works because members of int array is initialized with zeros, which is exacly what we need
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

//    public static int[] plusOne(int[] digits) {
//        // my initial solution. time O(n), space O(n) for worst case all 9s
//        // we start from the most right element
//        // if it's 9 then we need to increment the next element to the left and so on
//        // if the most left element is 9 then the resulting array must be bigger by 1
//        // how to determine that case? is that only relevant if array only has 9s?
//        int [] result;
//        if (Arrays.stream(digits).allMatch(digit -> digit == 9)) {
//            result = new int[digits.length + 1];
//        } else {
//            result = digits; // they point to the same place in memory (result == digits -> true)
//        }
//
//        boolean needToIncrease = true; // because we increase overall number by one
//        for (int i = digits.length - 1; i >= 0; i--) {
//            int newDigit;
//
//            if (needToIncrease) {
//                if (digits[i] == 9) {
//                    newDigit = 0;
//                    needToIncrease = true;
//                } else {
//                    newDigit = digits[i] + 1;
//                    needToIncrease = false;
//                }
//            } else {
//                newDigit = digits[i];
//            }
//            result[i] = newDigit;
//        }
//        if (needToIncrease) {
//            result[0] = 1;
//        }
//
//        return result;
//    }
}
