package leetcodeorneetcode150ordesignguruscourse.task0048_lc_567_permutation_in_string;

import java.util.HashMap;
import java.util.Map;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-1-permutation-in-a-string-hard
        // https://leetcode.com/problems/permutation-in-string/description/
        // Given a string and a pattern, find out if the string contains any permutation of the pattern.
        //Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following
        // six permutations:
        //    abc
        //    acb
        //    bac
        //    bca
        //    cab
        //    cba
        //If a string has ‘n’ distinct characters, it will have n! permutations.
        //Example 1:
        //Input: str="oidbcaf", pattern="abc"
        //Output: true
        //Explanation: The string contains "bca" which is a permutation of the given pattern.
        //Example 2:
        //Input: str="odicf", pattern="dc"
        //Output: false
        //Explanation: No permutation of the pattern is present in the given string as a substring.
        //Example 3:
        //Input: str="bcdxabcdy", pattern="bcdyabcdx"
        //Output: true
        //Explanation: Both the string and the pattern are a permutation of each other.

        // KEEP IN MIND! FOR LEETCODE AND DG THESE ARE REVERSED! Meaning str1 and str2, for DG left must be bigger, for LC right must be bigger
        System.out.println(checkInclusion("oidbcaf", "abc")); // true
        System.out.println(checkInclusion("odicf", "dc")); // false
        System.out.println(checkInclusion("bcdxabcdy", "bcdyabcdx")); // true
        System.out.println(checkInclusion("eidbaooo", "ab")); // true
////        System.out.println(checkInclusion("ab", "eidbaooo")); // true LEETCODE VERSION
////        System.out.println(checkInclusion("mart", "karma")); // true LEETCODE VERSION
        System.out.println(checkInclusion("karma", "mart")); // false
        System.out.println(checkInclusion("sjfqzacmkijurdtkjsvcgvlapehhtxqypyrksepemqygkkwqruqgxhmssncuqnjhukwisexdfwgtbnxnvtzyjrvxvnexoqylquwvselycwlndpnstkusaqgtcqofznabnwxumvhmbbzpubpjbiuorxsqgccmwuxtzzmuiflydvwoshwbzmbzbvawqxnebksmhcezlemrkjasbgltnhwswmodlyjhpyrjfydvnugucmvemejxazfnjuyahbsyisquyeddwcdqqhfmldebhlcvqggzvysqbevtfvgztxoipycmoahotmfjzvycnxylelgvapprablydqhjzpbtzigeepznggnzvczvfmetuyernrjsijrbkqifwuzmoljylrogryeivdqrrqtmhgrvcyjkfbifxtzaacdpxnpbqlhjomktqgtzvoqixuntbnsyndkywkftqjbihdaodgdsxbyrabpjgrppegnomkkhfpyhtlhawbzvjjelayyxgimnsghqbybbsvofcgxhdumrpqdzmykeuzlyivzudshlomjhlkqnjmwwyyaxzsrtujzdokcrhaawlnwpxklgnzfgckujvntwzvupboahvbwjduaoojlvyldiokahefyppamdgrlwsaynuozppgqjaqmzpgrognbrvlupzsjkqhjopjilvjncigrczxwlojtgdqijcmumnhxvnvpbxoumtepzcjffpyiiryuwqbsrlprsnpvfbdlpcjalcoabmrsiemfstncgyspkmxskufzfheitdzzijhwqurywvypwzrbtygowqrhedtwgxcrvoubxqwwhqkyedzludawxknospjothpkcuzwntejjdjgwnajciplncmczthmjmhvbmanepldkechpkwmhcjytqiucweekeahnsjtllgwehclleiykibiihjyrpivpgxciyqitxwqmtncqbgtpogzlxyppdcbrwqtnhucsurkrkwcgapvcsavlfezhhdodgituntplwoqpuxawbftpqgybqwglkqbrslkcladxgilznmmurikhmivjhrpiuovbtucpufxltwnxtqkqsjvdpnkcjccjstpmssdsytfzlwgzcttfpjustxachhwzacpxexlbkpuqyqcvbhrqfcqynhgbkooaubyjatfltoryxesddapmzdqhizblmbivkbdamrbxrqyiyonhzhefvfhlqmtybxlkarfibkqcsdwovvpnlvdqubrewsdusrfromqlgmmqdchnbltxfskowkdzpndkvljvpfkazpbnwdosjmobdetqhfjutphqdsmrlazlbghkehntimokxjusticdnshqrlqxtwdooshkqvkdolkldknchzzhxkjisnnokjdrfhxcevjjuyyeczcvjdeoysxcqueasienqklyuaomeoqjkkmftmhieeuvktolbvazftzqqznonvejiidhbpkpejmqyvkytlncbpxjopomgomgxdktfxbkdbovtzkmvxbidzfjzpwxjvqrqscsppravwpjyevwjqwnwuoiamguqikctjqccnjqfcemyjjrcsxbdzxdgyokvbirlrtqublgoolziqttuunwtwmisdhhnzvazvpjrsfkcyjbaflfazmhttmaynpfqhragkrgzeeiqzwexozhj", "qiyjjmsiurfwzolbk")); // true
        System.out.println(checkInclusion("abdc", "abc")); // false
        System.out.println(checkInclusion("aaacaa", "aaaa")); // false
    }

    public static boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int matched = 0; // matching by characters (meaning a = 2 fulfilled, b = 1 fulfilled, etc)
        Map<Character, Integer> permutationRequirement = new HashMap<>();
        for (char c : s1.toCharArray()) {
            permutationRequirement.put(c, permutationRequirement.getOrDefault(c, 0) + 1);
        }

        char[] strChars = s2.toCharArray();
        for (int right = 0; right < strChars.length; right++) {
            char rightChar = strChars[right];
            if (permutationRequirement.containsKey(rightChar)) {
                permutationRequirement.put(rightChar, permutationRequirement.get(rightChar) - 1);
                if (permutationRequirement.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == permutationRequirement.size()) {
                return true;
            }

            // shrink. this 'if' means that once our window is of pattern size then we need to constantly move window -
            // - left moves and right moves
            if (right >= s1.length() - 1) {
                char leftChar = strChars[left];
                left++;
                // very confusing, because we don't need to reset our tracking map. this works because we always track our pattern and ignoring other chars in between is fine. still confusing, for now just remember
                if (permutationRequirement.containsKey(leftChar)) {
                    if (permutationRequirement.get(leftChar) == 0) {
                        matched--;
                    }
                    permutationRequirement.put(leftChar, permutationRequirement.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

    public static boolean checkInclusionDG(String str, String pattern) {
        int left = 0;
        int matched = 0; // matching by characters (meaning a = 2 fulfilled, b = 1 fulfilled, etc)
        Map<Character, Integer> permutationRequirement = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            permutationRequirement.put(c, permutationRequirement.getOrDefault(c, 0) + 1);
        }

        char[] strChars = str.toCharArray();
        for (int right = 0; right < strChars.length; right++) {
            char rightChar = strChars[right];
            if (permutationRequirement.containsKey(rightChar)) {
                permutationRequirement.put(rightChar, permutationRequirement.get(rightChar) - 1);
                if (permutationRequirement.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == permutationRequirement.size()) {
                return true;
            }

            // shrink. this 'if' means that once our window is of pattern size then we need to constantly move window -
            // - left moves and right moves
            if (right >= pattern.length() - 1) {
                char leftChar = strChars[left];
                left++;
                // very confusing, because we don't need to reset our tracking map. this works because we always track our pattern and ignoring other chars in between is fine. still confusing, for now just remember
                if (permutationRequirement.containsKey(leftChar)) {
                    if (permutationRequirement.get(leftChar) == 0) {
                        matched--;
                    }
                    permutationRequirement.put(leftChar, permutationRequirement.get(leftChar) + 1);
                }
            }
        }

        return false;
    }
}
