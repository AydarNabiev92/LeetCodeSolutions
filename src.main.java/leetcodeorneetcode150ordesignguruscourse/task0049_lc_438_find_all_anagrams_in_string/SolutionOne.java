package leetcodeorneetcode150ordesignguruscourse.task0049_lc_438_find_all_anagrams_in_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-2string-anagrams-hard
        // https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
        // Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
        //Example 1:
        //Input: s = "cbaebabacd", p = "abc"
        //Output: [0,6]
        //Explanation:
        //The substring with start index = 0 is "cba", which is an anagram of "abc".
        //The substring with start index = 6 is "bac", which is an anagram of "abc".
        //Example 2:
        //Input: s = "abab", p = "ab"
        //Output: [0,1,2]
        //Explanation:
        //The substring with start index = 0 is "ab", which is an anagram of "ab".
        //The substring with start index = 1 is "ba", which is an anagram of "ab".
        //The substring with start index = 2 is "ab", which is an anagram of "ab".
        System.out.println(findAnagrams("cbaebabacd", "abc")); // [0,6]
        System.out.println(findAnagrams("abab", "ab")); // [0,1,2]
        System.out.println(findAnagrams("ppqp", "pq")); // [1,2]
        System.out.println(findAnagrams("abbcabc", "abc")); // [2, 3, 4]
        System.out.println(findAnagrams("hellothere", "there")); // [5]
        System.out.println(findAnagrams("baa", "aa")); // [1]
    }

    public static List<Integer> findAnagrams(String s, String p) {
        // definitely build a map
        Map<Character, Integer> permutationRequirement = new HashMap<>();
        for (char pChar : p.toCharArray()) {
            permutationRequirement.put(pChar, permutationRequirement.getOrDefault(pChar, 0) + 1);
        }

        // now, correctly look for our pattern, multiple times. need to also remember correctly handling multiple starts in one substring
        // maybe shrinking left by one already does this for me?
        int left = 0;
        int matched = 0;
        char[] sChars = s.toCharArray();
        List<Integer> result = new ArrayList<>();

        for (int right = 0; right < sChars.length; right++) {
            char rightChar = sChars[right];
            if (permutationRequirement.containsKey(rightChar)) {
                permutationRequirement.put(rightChar, permutationRequirement.get(rightChar) - 1);
                if (permutationRequirement.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == permutationRequirement.size()) {
                result.add(left);
            }

            if (right >= p.length() - 1) { // treadmill!
                char leftChar = sChars[left];
                left++;
                if (permutationRequirement.containsKey(leftChar)) {
                    if (permutationRequirement.get(leftChar) == 0) {
                        matched--;
                    }
                    permutationRequirement.put(leftChar, permutationRequirement.get(leftChar) + 1);
                }
            }
        }

        return result;
    }

    public List<Integer> findStringAnagrams(String str, String pattern) {
        // definitely build a map
        Map<Character, Integer> permutationRequirement = new HashMap<>();
        for (char pChar : pattern.toCharArray()) {
            permutationRequirement.put(pChar, permutationRequirement.getOrDefault(pChar, 0) + 1);
        }

        // now, correctly look for our pattern, multiple times. need to also remember correctly handling multiple starts in one substring
        // maybe shrinking left by one already does this for me?
        int left = 0;
        int matched = 0;
        char[] sChars = str.toCharArray();
        List<Integer> result = new ArrayList<>();

        for (int right = 0; right < sChars.length; right++) {
            char rightChar = sChars[right];
            if (permutationRequirement.containsKey(rightChar)) {
                permutationRequirement.put(rightChar, permutationRequirement.get(rightChar) - 1);
                if (permutationRequirement.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == permutationRequirement.size()) {
                result.add(left);
            }

            if (right >= pattern.length() - 1) { // treadmill!
                char leftChar = sChars[left];
                left++;
                if (permutationRequirement.containsKey(leftChar)) {
                    if (permutationRequirement.get(leftChar) == 0) {
                        matched--;
                    }
                    permutationRequirement.put(leftChar, permutationRequirement.get(leftChar) + 1);
                }
            }
        }

        return result;
    }
}
