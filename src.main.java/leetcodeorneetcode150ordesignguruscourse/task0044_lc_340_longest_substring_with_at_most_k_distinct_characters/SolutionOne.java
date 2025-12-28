package leetcodeorneetcode150ordesignguruscourse.task0044_lc_340_longest_substring_with_at_most_k_distinct_characters;

import java.util.HashMap;
import java.util.Map;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/longest-substring-with-k-distinct-characters-medium
        // https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
        // Given a string, find the length of the longest substring in it with no more than K distinct characters.
        //You can assume that K is less than or equal to the length of the given string.
        //Example 1:
        //Input: String="araaci", K=2
        //Output: 4
        //Explanation: The longest substring with no more than '2' distinct characters is "araa".
        //Example 2:
        //Input: String="araaci", K=1
        //Output: 2
        //Explanation: The longest substring with no more than '1' distinct characters is "aa".
        System.out.println(findLength("araaci", 2)); // 4
        System.out.println(findLength("araaci", 1)); // 2
        System.out.println(findLength("abcabcabc", 2)); // 2
    }

    public static int findLength(String str, int k) {
        // must be there separate place for current distinct and current window?
        // or is there enough to keep current distinct?

        // seems like we need to work with a map, where key is character and value is number of times it was met
        // so, two places? map and current length which updates max length

        if (k == 0) {
            return 0;
        }

        int maxLength = 0;

        char[] chars = str.toCharArray();
        int left = 0;
        Map<Character, Integer> timesMetByCharacter = new HashMap<>();
        timesMetByCharacter.put(chars[left], timesMetByCharacter.getOrDefault(chars[left], 0) + 1);

        int right;
        for (right = 1; right < chars.length; right++) {
            Character rightChar = chars[right];

            // cases
            // current is already in the map - increase map value and length
            if (timesMetByCharacter.containsKey(rightChar)) {
                timesMetByCharacter.put(rightChar, timesMetByCharacter.getOrDefault(rightChar, 0) + 1);
            } else { // current is not in the map
                // check if map reached its limit
                // if it did - we need to move left until map's keysize is less than limit k THEN add new char
                // if it didn't - simply add new char
                if (timesMetByCharacter.keySet().size() >= k) {
                    maxLength = Math.max(maxLength, right - left);
                    // move left until map's keysize is less than limit k or until left reached right
                    while (left < right && timesMetByCharacter.keySet().size() >= k) {
                        Character leftChar = chars[left];
                        timesMetByCharacter.put(leftChar, timesMetByCharacter.get(leftChar) - 1);
                        if (timesMetByCharacter.get(leftChar) == 0) {
                            timesMetByCharacter.remove(leftChar);
                        }
                        left++;
                    }
                }
                timesMetByCharacter.put(rightChar, timesMetByCharacter.getOrDefault(rightChar, 0) + 1);
            }

        }
        maxLength = Math.max(maxLength, right - left);

        return maxLength;
    }
}
