package leetcodeorneetcode150ordesignguruscourse.task0018_lc_1832_check_if_the_sentence_is_pangram;

import java.util.HashSet;
import java.util.Set;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
        // A pangram is a sentence where every letter of the English alphabet appears at least once.
        //Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
        //Example 1:
        //Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
        //Output: true
        //Explanation: sentence contains at least one of every letter of the English alphabet.
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog")); // true
        System.out.println(checkIfPangram("leetcode")); // false
    }

    public static boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        char[] chars = sentence.toCharArray();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(chars[i]);
            if (set.size() == 26) {
                return true;
            }
        }

        return false;
    }
}
