package leetcodeorneetcode150ordesignguruscourse.task0004_lc_09_palindrome_number;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/palindrome-number/description/
        // Given an integer x, return true if x is a
        //, and false otherwise.

        //Example 1:
        //Input: x = 121
        //Output: true
        //Explanation: 121 reads as 121 from left to right and from right to left.

        //Example 2:
        //Input: x = -121
        //Output: false
        //Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

        //Example 3:
        //Input: x = 10
        //Output: false
        //Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

        // Follow up: Could you solve it without converting the integer to a string?
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(103));
        // palindromic with even - 1221
        // palindromic with odd - 121

    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int divider = 10;
        List<Integer> digits = new ArrayList<>();
        int digit = x % divider;
        while (x >= 1)  {
            digits.add(digit);
            x = x / 10;
            digit = x % divider;
        }

        // go through list
        for (int i = 0; i < digits.size() / 2; i++) {
            int left = digits.get(i);
            int right = digits.get(digits.size() - i - 1);
            if (left != right) {
                return false;
            }
        }

        return true;
    }
}
