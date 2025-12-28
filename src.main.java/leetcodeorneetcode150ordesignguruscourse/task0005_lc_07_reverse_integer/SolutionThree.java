package leetcodeorneetcode150ordesignguruscourse.task0005_lc_07_reverse_integer;

public class SolutionThree {
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

//        System.out.println(reverse(123)); // 321
//        System.out.println(reverse(-123)); // -321
//        System.out.println(reverse(120)); // 21
//        System.out.println(reverse(10)); // 1
        System.out.println(reverse(1534236469)); // 0
//        System.out.println(reverse(102)); // 201
//        System.out.println(reverse(100)); // 1
    }

    public static int reverse(int x) {
        // https://www.youtube.com/watch?v=1bfbV4jx0To
        int result = 0;
        int prev = 0;

        while (x != 0) {
            int cur = x % 10;
            x /= 10;

            result = result * 10 + cur;

            if ((result - cur) / 10 != prev) { // two's complement
                return 0;
            }

            prev = result;
        }

        return result;
    }
}
