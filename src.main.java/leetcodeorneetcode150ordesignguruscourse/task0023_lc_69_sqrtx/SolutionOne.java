package leetcodeorneetcode150ordesignguruscourse.task0023_lc_69_sqrtx;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/sqrtx/description/
        // Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
        //You must not use any built-in exponent function or operator.
        //    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
        // Example 1:
        //Input: x = 4
        //Output: 2
        //Explanation: The square root of 4 is 2, so we return 2.
        //Example 2:
        //Input: x = 8
        //Output: 2
        //Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
        System.out.println(mySqrt(4)); // 2
        System.out.println(mySqrt(8)); // 2
        System.out.println(mySqrt(9)); // 3
        System.out.println(mySqrt(10)); // 3
        System.out.println(mySqrt(2147395599)); // 46339
    }

    public static int mySqrt(int x) {
        // binary search - take the middle from the (0...x) and check it's square. if it's less than x, then we need to
        // go to the right part, otherwise go to the left part. but what if it's never going to hit x exactly?
        // then I need to take the smallest candidate

        int left = 0;
        int right = x;
        int smallestFound = 0;
        while (left <= right) {
            int pointer = left + (right - left) / 2;
            long squared = (long) pointer * pointer;
            if (squared == x) {
                return pointer;
            } else if (squared > x) {
                right = pointer - 1;
            } else {
                smallestFound = pointer;
                left = pointer + 1;
            }
        }

        return smallestFound;
    }

//    public static int mySqrt(int x) {
//        // too slow
//        int result = 0;
//        for (int i = 0; i <= x; i++) {
//            long sqr = i * i;
//            if (sqr == x) {
//                return i;
//            } else if (sqr > x) {
//                return result;
//            } else {
//                result = i;
//            }
//        }
//
//        return result;
//    }
}
