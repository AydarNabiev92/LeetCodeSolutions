package leetcodeorneetcode150ordesignguruscourse.task0002_lc_03_longest_substring_without_repeating_characters;

public class SolutionThree {
    // Longest Substring Without Repeating Characters
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
        // use sliding window pattern - left and right pointers
        // we have left pointer and right pointer. until there are no duplicates we move to the right. when we get duplicate
        // we adjust - move left pointer to the right of the duplicate

        int left = 0;
        int maxLengthFound = 0;
        String currentString = "";

        for (int right = 0; right < s.length(); right++) {

            Character currentCharacter = s.charAt(right);
            String currentStringCharacter = currentCharacter.toString();


            if (!currentString.contains(currentStringCharacter)) {
                // increase the current string
                currentString = currentString + currentStringCharacter;
            } else {
                if (maxLengthFound < currentString.length()) {
                    maxLengthFound = currentString.length();
                }

                // Make window smaller by increasing left
                // we must identify where left is, not right, because left must be AFTER the letter that ended up being repeated
                left = left + currentString.indexOf(currentCharacter) + 1;

                currentString = s.substring(left, right + 1);
            }
        }
        if (maxLengthFound < currentString.length()) {
            maxLengthFound = currentString.length();
        }

        return maxLengthFound;
    }
}
