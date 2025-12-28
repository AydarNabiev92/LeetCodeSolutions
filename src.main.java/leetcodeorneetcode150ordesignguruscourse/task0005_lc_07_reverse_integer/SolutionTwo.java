package leetcodeorneetcode150ordesignguruscourse.task0005_lc_07_reverse_integer;

public class SolutionTwo {
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
        // https://www.youtube.com/watch?v=CRgXG1vK-wg
        int reversed = 0;
        int pop;

        int upperBound = Integer.MAX_VALUE / 10;
        int lowerBound = Integer.MIN_VALUE / 10;

        while (x != 0) {
            pop = x % 10;
            x /= 10;

            if (reversed > upperBound || reversed == upperBound && pop > 7) {
                return 0;
            }
            if (reversed < lowerBound || reversed == lowerBound && pop < -8) {
                return 0;
            }

            reversed = (reversed * 10) + pop;
        }

        return reversed;
    }
}
