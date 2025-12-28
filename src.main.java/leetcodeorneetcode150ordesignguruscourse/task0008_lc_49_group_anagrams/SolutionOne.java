package leetcodeorneetcode150ordesignguruscourse.task0008_lc_49_group_anagrams;

import java.util.*;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/group-anagrams/description/

        // Given an array of strings strs, group the
        //together. You can return the answer in any order.
        //
        //Example 1:
        //Input: strs = ["eat","tea","tan","ate","nat","bat"]
        //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        //Explanation:
        //    There is no string in strs that can be rearranged to form "bat".
        //    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
        //    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    /*public static List<List<String>> groupAnagrams(String[] strs) {
        // my solution
        // map where key is anagram map and value are strings that are anagrams of each other
        Map<Map<Character, Integer>, List<String>> stringListByAnagramMap = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> timesCharByChar = new HashMap<>();
            for (int j = 0; j < str.length(); j++) {
                Character character = str.charAt(j);
                timesCharByChar.put(character, timesCharByChar.getOrDefault(character, 0) + 1);
            }
            if (Objects.isNull(stringListByAnagramMap.get(timesCharByChar))) {
                stringListByAnagramMap.put(timesCharByChar, new ArrayList<>());
            }
            stringListByAnagramMap.get(timesCharByChar).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : stringListByAnagramMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }*/

    public static List<List<String>> groupAnagrams(String[] strs) {
        // not my solution
        Map<String, List<String>> listOfAnagramsBySortedString = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = Arrays.toString(chars);

            if (Objects.isNull(listOfAnagramsBySortedString.get(sorted))) {
                listOfAnagramsBySortedString.put(sorted, new ArrayList<>());
            }
            listOfAnagramsBySortedString.get(sorted).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : listOfAnagramsBySortedString.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
