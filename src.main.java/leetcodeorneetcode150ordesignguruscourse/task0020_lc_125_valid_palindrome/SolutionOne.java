package leetcodeorneetcode150ordesignguruscourse.task0020_lc_125_valid_palindrome;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/valid-palindrome/description/
        // A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
        // non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
        //Given a string s, return true if it is a palindrome, or false otherwise.
        //Example 1:
        //Input: s = "A man, a plan, a canal: Panama"
        //Output: true
        //Explanation: "amanaplanacanalpanama" is a palindrome.
        // Example 2:
        //Input: s = "race a car"
        //Output: false
        //Explanation: "raceacar" is not a palindrome.
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome("0P")); // false
        System.out.println(isPalindrome(".a")); // true
    }

    public static boolean isPalindrome(String s) {
        String alphanumeric = "qwertyuiopasdfghjklzxcvbnm0123456789";
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        // two pointers? they also ignore everything non character
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (alphanumeric.indexOf(Character.toLowerCase(s.charAt(left))) == -1 && left < right) {
                left++;
            }
            while (alphanumeric.indexOf(Character.toLowerCase(s.charAt(right))) == -1 && left < right) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
