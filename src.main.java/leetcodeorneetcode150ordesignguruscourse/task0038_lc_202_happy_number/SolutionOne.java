package leetcodeorneetcode150ordesignguruscourse.task0038_lc_202_happy_number;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/happy-number-medium
        // https://leetcode.com/problems/happy-number/description/
        // Write an algorithm to determine if a number n is happy.
        //A happy number is a number defined by the following process:
        //Starting with any positive integer, replace the number by the sum of the squares of its digits.
        //Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        //Those numbers for which this process ends in 1 are happy.
        //Return true if n is a happy number, and false if not.
        // Example 1:
        //Input: n = 19
        //Output: true
        //Explanation:
        //12 + 92 = 82
        //82 + 22 = 68
        //62 + 82 = 100
        //12 + 02 + 02 = 1
        //Example 2:
        //Input: n = 2
        //Output: false
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(2)); // false
    }

    public boolean find(int num) {
        // seems like the core algo is going through digits
        // but checking whether it's not happy because of there being a cycle is by using fast and slow pointers

        int fastN = num;
        while (num != 1) {
            num = getSumOfDigitsSquared(num);
            fastN = getSumOfDigitsSquared(getSumOfDigitsSquared(fastN));

            if (fastN != 1 && num == fastN) {
                return false;
            }
        }

        return true;
    }

    public static boolean isHappy(int n) {
        // seems like the core algo is going through digits
        // but checking whether it's not happy because of there being a cycle is by using fast and slow pointers

        int fastN = n;
        while (n != 1) {
            n = getSumOfDigitsSquared(n);
            fastN = getSumOfDigitsSquared(getSumOfDigitsSquared(fastN));

            if (fastN != 1 && n == fastN) {
                return false;
            }
        }

        return true;
    }

    private static int getSumOfDigitsSquared(int n) {
        int newN = 0;
        while (n > 0) {
            int digit = n % 10;
            newN = newN + (digit * digit);
            n = n / 10;
        }

        return newN;
    }
}
