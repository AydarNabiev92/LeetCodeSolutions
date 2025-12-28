package leetcodeorneetcode150ordesignguruscourse.task0002_lc_03_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class SolutionOne {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public static void main(String[] args) {
        // Given a string s, find the length of the longest substring without duplicate characters.
        //Example 1:
        //Input: s = "abcabcbb"
        //Output: 3
        //Explanation: The answer is "abc", with the length of 3.
        //Example 2:
        //Input: s = "bbbbb"
        //Output: 1
        //Explanation: The answer is "b", with the length of 1.
        //Example 3:
        //Input: s = "pwwkew"
        //Output: 3
        //Explanation: The answer is "wke", with the length of 3.
        //Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        // Constraints:
        //0 <= s.length <= 5 * 104
        //s consists of English letters, digits, symbols and spaces.

        System.out.println("Expected 3, actual " + lengthOfLongestSubstring("abcabcbb") + " for abcabcbb"); // expected 3
        System.out.println("Expected 3, actual " + lengthOfLongestSubstring("pwwkew") + " for pwwkew"); // expected 3
        System.out.println("Expected 1, actual " + lengthOfLongestSubstring(" ") + " for "); // expected 1
        System.out.println("Expected 3, actual " + lengthOfLongestSubstring("dvdf") + " for dvdf"); // expected 3
        System.out.println("Expected 5, actual " + lengthOfLongestSubstring("anviaj") + " for anviaj"); // expected 5
    }

    public static int lengthOfLongestSubstring(String s) {
        // Go through the string - gather nonrepeating, but once duplicate found - remember to count and empty vessel
        Map<Character, Integer> characterPlaceByCharacter = new HashMap<>();
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (!characterPlaceByCharacter.containsKey(character)) {
                characterPlaceByCharacter.put(character, i);
            } else {
                // Renew max length if needed
                if (characterPlaceByCharacter.keySet().size() > counter) {
                    counter = characterPlaceByCharacter.keySet().size();
                }
                // Move pointer just after repeated character
                i = characterPlaceByCharacter.get(character); // Pointer will move after this iteration is done
                characterPlaceByCharacter = new HashMap<>();
            }
        }
        // Last check for possible max length
        if (characterPlaceByCharacter.keySet().size() > counter) {
            counter = characterPlaceByCharacter.keySet().size();
        }

        return counter;
    }
}
