package leetcodeorneetcode150ordesignguruscourse.task0046_lc_424_longest_repeating_character_replacement;

import java.util.HashMap;
import java.util.Map;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/longest-substring-with-same-letters-after-replacement-hard
        // https://leetcode.com/problems/longest-repeating-character-replacement/description/
        // Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
        //Example 1:
        //Input: str="aabccbb", k=2
        //Output: 5
        //Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
        //Example 2:
        //Input: str="abbcb", k=1
        //Output: 4
        //Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
        //Example 3:
        //Input: str="abccde", k=1
        //Output: 3
        //Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
        System.out.println(characterReplacement("A", 1)); // 1
        System.out.println(characterReplacement("AABCCBB", 2)); // 5
        System.out.println(characterReplacement("ABBCB", 1)); // 4
        System.out.println(characterReplacement("ABCCDE", 1)); // 3

        System.out.println(characterReplacement("AAAA", 2)); // 4
        System.out.println(characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4)); // 7
        System.out.println(characterReplacement("ERNFSSS", 4)); // 7
    }

    // DesignGurus
    public int findLength(String str, int k) {
        if (str.length() < 2) {
            return str.length();
        }

        int left = 0;
        int[] frequencyTracker = new int[26];
        int mostFrequent = 0;
        int maxFound = 0;

        char[] chars = str.toCharArray();

        for (int right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            frequencyTracker[index]++;
            mostFrequent = Math.max(mostFrequent, frequencyTracker[index]);

            // now shrink condition
            while ((right - left + 1) - mostFrequent > k) {
                // properly reduce frequency
                frequencyTracker[chars[left] - 'A']--;
                left++;
            }
            maxFound = Math.max(maxFound, right - left + 1);
        }

        return maxFound;
    }

    public static int characterReplacement(String s, int k) {
        if (s.length() < 2) {
            return s.length();
        }

        int[] freq = new int[26];
        int left = 0;
        int mostFrequent = 0; // max frequency in the current window
        int best = 0; // best window length

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A'; // 'A' for leetcode, 'a' for designgurus
            freq[idx]++;
            mostFrequent = Math.max(mostFrequent, freq[idx]);

            // that's how this works - we always keep track of the most frequent character, we need it to know if our windows
            // is valid for k condition. this is because we can have no more than k distinct (meaning wrong) characters. to know
            // whether we do we must get current window size and subtract most frequent character, because that's how we know
            // if we didn't exceed k distinct - by removing most frequent from the window
            while ((right - left + 1) - mostFrequent > k) {
                freq[s.charAt(left) - 'A']--; // 'A' for leetcode, 'a' for designgurus
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}
