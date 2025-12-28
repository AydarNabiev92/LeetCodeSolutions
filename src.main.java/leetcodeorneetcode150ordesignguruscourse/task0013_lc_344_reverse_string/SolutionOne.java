package leetcodeorneetcode150ordesignguruscourse.task0013_lc_344_reverse_string;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/reverse-string/description/
        // Write a function that reverses a string. The input string is given as an array of characters s.
        //You must do this by modifying the input array in-place with O(1) extra memory.
        // Example 1:
        //Input: s = ["h","e","l","l","o"]
        //Output: ["o","l","l","e","h"]
        //Example 2:
        //Input: s = ["H","a","n","n","a","h"]
        //Output: ["h","a","n","n","a","H"]
        reverseString(fromStringToCharArray("hello")); // olleh
        reverseString(fromStringToCharArray("Hannah")); // hannaH
    }

    private static char[] fromStringToCharArray(String s) {
        return s.toCharArray();
    }

    public static void reverseString(char[] s) {
        System.out.println(s);
        // how do I reverse a string? a for loop? remember - no extra memory, so extra place to store elements
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        System.out.println(s);
    }
}
