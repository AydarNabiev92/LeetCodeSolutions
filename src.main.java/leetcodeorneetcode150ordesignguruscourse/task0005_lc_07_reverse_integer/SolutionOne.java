package leetcodeorneetcode150ordesignguruscourse.task0005_lc_07_reverse_integer;

import java.util.ArrayList;
import java.util.List;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/reverse-integer/description/

        // Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
        // the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
        // Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

        // Example 1:
        //Input: x = 123
        //Output: 321

        //Example 2:
        //Input: x = -123
        //Output: -321

        //Example 3:
        //Input: x = 120
        //Output: 21

        // Minimum value: -2,147,483,648 (which is -2^31)
        // Maximum value: 2,147,483,647 (which is 2^31 - 1)

        System.out.println(reverse(123)); // 321
        System.out.println(reverse(-123)); // -321
        System.out.println(reverse(120)); // 21
        System.out.println(reverse(10)); // 1
        System.out.println(reverse(1534236469)); // 0
        System.out.println(reverse(102)); // 201
        System.out.println(reverse(100)); // 1
    }

    public static int reverse(int x) {
        int originalX = x;
        // in this case we don't need to reverse anything
        if (x >= 0 && x < 10) {
            return x;
        }
        // special case
        if (x == 10) {
            return 1;
        }
        // another special case
        if (x == -10) {
            return -1;
        }
        // needed for proper negative number reversal
        boolean positive;
        if (x < 0) {
            positive = false;
            x = -x;
        } else {
            positive = true;
        }

        // place for digits
        List<Integer> digits = new ArrayList<>();
        while (x > 10) {
            int remainder = x % 10;
            x = x / 10;
            digits.add(remainder);
        }
        // need to properly add digits of what's left of x
        if (x == 10) {
            digits.add(0);
            digits.add(1);
        } else {
            digits.add(x);
        }

        /*int digit = x % 10;
        while (digit >= 1) {
            digits.add(digit);
            x = x / 10;
            digit = x % 10;
        }*/

        // don't forget about negative numbers
        StringBuilder number = positive ? new StringBuilder() : new StringBuilder("-");
        for (Integer resultDigit : digits) {
            number.append(resultDigit);
        }

        // don't forget about numbers that after being reversed fall out of limits
        try {
            return Integer.parseInt(number.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
