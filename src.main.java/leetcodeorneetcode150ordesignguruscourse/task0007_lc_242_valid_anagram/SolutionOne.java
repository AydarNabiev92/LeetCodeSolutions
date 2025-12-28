package leetcodeorneetcode150ordesignguruscourse.task0007_lc_242_valid_anagram;

import java.util.HashMap;
import java.util.Map;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/valid-anagram/description/

        // Given two strings s and t, return true if t is an
        //of s, and false otherwise.
        //
        //Example 1:
        //Input: s = "anagram", t = "nagaram"
        //Output: true
        //
        //Example 2:
        //Input: s = "rat", t = "car"
        //Output: false
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("aa", "bb")); // false
    }

    public static boolean isAnagram(String s, String t) {
        // runtime beats 9%. neetcode says O(n)
        // memory beats 55%. neetcode says O(n)

        // Time complexity: O(n)
        //Explanation: n is the length of the input strings s and t; i is the loop index; numberOfTimesMetByCharacter stores counts per character.
        //Space complexity: O(n)
        //Explanation: The map stores counts for up to n distinct characters.

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> numberOfTimesMetByCharacter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            numberOfTimesMetByCharacter.put(sChar, numberOfTimesMetByCharacter.getOrDefault(sChar, 0) + 1);
            numberOfTimesMetByCharacter.put(tChar, numberOfTimesMetByCharacter.getOrDefault(tChar, 0) - 1);
        }

        for (Integer numberOfTimes : numberOfTimesMetByCharacter.values()) {
            if (numberOfTimes != 0) {
                return false;
            }
        }

        return true;
    }
}
