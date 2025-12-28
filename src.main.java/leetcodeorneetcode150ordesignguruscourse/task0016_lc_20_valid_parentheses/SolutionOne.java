package leetcodeorneetcode150ordesignguruscourse.task0016_lc_20_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/valid-parentheses/description/
        // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
        //An input string is valid if:
        //    Open brackets must be closed by the same type of brackets.
        //    Open brackets must be closed in the correct order.
        //    Every close bracket has a corresponding open bracket of the same type.
        //Example 1:
        //Input: s = "()"
        //Output: true
        // Example 3:
        //Input: s = "(]"
        //Output: false
        System.out.println(isValid("()")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("]")); // false
    }

    public static boolean isValid(String s) {
        // Since Util.Stack is deprecated (JAVA 1.0)
        // possible values - '(', ')', '{', '}', '[' and ']'
        Deque<Character> stack = new ArrayDeque<>();

        for (Character character : s.toCharArray()) {
            if (character == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (character == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (character == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else {
                stack.push(character);
            }
        }

        return stack.isEmpty();
    }

//    public static boolean isValid(String s) {
//        // possible values - '(', ')', '{', '}', '[' and ']'
//        Stack<Character> stack = new Stack<>();
//
//        for (Character character : s.toCharArray()) {
//            if (character == ')') {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                if (stack.pop() != '(') {
//                    return false;
//                }
//            } else if (character == '}') {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                if (stack.pop() != '{') {
//                    return false;
//                }
//            } else if (character == ']') {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                if (stack.pop() != '[') {
//                    return false;
//                }
//            } else {
//                stack.push(character);
//            }
//        }
//
//        return stack.isEmpty();
//    }
}
