package leetcodeorneetcode150ordesignguruscourse.task0019_lc_345_reverse_vowels_of_a_string;

import java.util.Set;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/reverse-vowels-of-a-string/description/
        // Given a string s, reverse only all the vowels in the string and return it.
        //The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
        //Example 1:
        //Input: s = "IceCreAm"
        //Output: "AceCreIm"
        //Explanation:
        //The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
        System.out.println(reverseVowels("DesignGUrus")); // DusUgnGires
        System.out.println(reverseVowels(".,")); // .,
    }

    public static String reverseVowels(String s) {
        // Algo using two pointers without storing indices
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (!vowels.contains(s.charAt(left)) && left < right) {
                left++;
            }
            while (!vowels.contains(s.charAt(right)) && left < right) {
                right--;
            }
            if (left >= right) {
                break;
            }
            // now swap them
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    /*public static String reverseVowels(String s) {
        // My algo
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (vowels.contains(Character.toLowerCase(character))) {
                positions.add(i);
            }
        }

        // now revers using two pointers
        int left = 0;
        int right = positions.size() - 1;
        char[] chars = s.toCharArray();
        while (left <= right) {
            char temp = chars[positions.get(left)];
            chars[positions.get(left)] = chars[positions.get(right)];
            chars[positions.get(right)] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }*/
}
