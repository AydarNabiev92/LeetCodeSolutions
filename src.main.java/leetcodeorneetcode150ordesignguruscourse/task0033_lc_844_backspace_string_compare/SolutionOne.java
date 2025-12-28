package leetcodeorneetcode150ordesignguruscourse.task0033_lc_844_backspace_string_compare;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-2-comparing-strings-containing-backspaces-medium
        // https://leetcode.com/problems/backspace-string-compare/description/
        // Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
        //Note that after backspacing an empty text, the text will continue empty.
        //Example 1:
        //Input: s = "ab#c", t = "ad#c"
        //Output: true
        //Explanation: Both s and t become "ac".
        //Example 2:
        //Input: s = "ab##", t = "c#d#"
        //Output: true
        //Explanation: Both s and t become "".
        //Example 3:
        //Input: s = "a#c", t = "b"
        //Output: false
        //Explanation: s becomes "c" while t becomes "b".
        // Follow up: Can you solve it in O(n) time and O(1) space?
        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a#c", "b")); // false
        System.out.println(backspaceCompare("bxj##tw", "bxj###tw")); // false
        System.out.println(backspaceCompare("xywrrmp", "xywrrm#p")); // false
        System.out.println(backspaceCompare("bxj##tw", "bxo#j##tw")); // true
        System.out.println(backspaceCompare("nzp#o#g", "b#nzp#o#g")); // true
        System.out.println(backspaceCompare("bbbextm", "bbb#extm")); // false
        System.out.println(backspaceCompare("a##c", "#a#c")); // true
    }

    public static boolean compare(String str1, String str2) {
        Integer sPointer = str1.length() - 1;
        Integer tPointer = str2.length() - 1;

        while (sPointer >= 0 || tPointer >= 0) {
            // guard against going out of bounds huh

            // correctly scan until reaching character

            // avoid using boolean

            sPointer = getCharacter(str1, sPointer);
            tPointer = getCharacter(str2, tPointer);

            if ((sPointer < 0 && tPointer >= 0) || (sPointer >= 0 && tPointer < 0)) {
                return false;
            }
            if (sPointer < 0 && tPointer < 0) {
                return true;
            }

            Character sCharacter = str1.charAt(sPointer);
            Character tCharacter = str2.charAt(tPointer);

            if (!sCharacter.equals(tCharacter)) {
                return false;
            } else {
                sPointer--;
                tPointer--;
            }
        }

        return true;
    }

    public static boolean backspaceCompare(String s, String t) {
        Integer sPointer = s.length() - 1;
        Integer tPointer = t.length() - 1;

        while (sPointer >= 0 || tPointer >= 0) {
            // guard against going out of bounds huh

            // correctly scan until reaching character

            // avoid using boolean

            sPointer = getCharacter(s, sPointer);
            tPointer = getCharacter(t, tPointer);

            if ((sPointer < 0 && tPointer >= 0) || (sPointer >= 0 && tPointer < 0)) {
                return false;
            }
            if (sPointer < 0 && tPointer < 0) {
                return true;
            }

            Character sCharacter = s.charAt(sPointer);
            Character tCharacter = t.charAt(tPointer);

            if (!sCharacter.equals(tCharacter)) {
                return false;
            } else {
                sPointer--;
                tPointer--;
            }
        }

        return true;
    }

    public static Integer getCharacter(String string, Integer pointer) {
        // now, screw backspaces and there respective deleted characters. we need the valid character from this. if ran out we probably need to do something else - maybe null?
        if (pointer < 0) {
            return -1;
        }

        int backSpaceCounter = 0;

        // gather backspaces and apply them, but also don't leave until backspaces are spent and correct character is found
        // need to keep in memory amount of met backspaces

        // REALLY NEED TO UNDERSTAND THIS PART
        while (pointer >= 0) {
            if (string.charAt(pointer) == '#') {
                backSpaceCounter++;
                pointer--;
            } else if (backSpaceCounter > 0) {
                backSpaceCounter--;
                pointer--;
            } else {
                break;
            }
        }

        return pointer;
    }
}
