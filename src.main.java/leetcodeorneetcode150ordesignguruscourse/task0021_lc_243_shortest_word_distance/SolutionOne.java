package leetcodeorneetcode150ordesignguruscourse.task0021_lc_243_shortest_word_distance;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/shortest-word-distance/description/ Premium
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/shortest-word-distance-easy
        // Given an array of strings 'words' and two different strings that already exist in the array 'word1' and 'word2',
        // return the shortest distance between these two words in the list.
        //Example 1:
        //Input: words = ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"], word1 = "fox", word2 = "dog"
        //Output: 5
        //Explanation: The distance between "fox" and "dog" is 5 words.
        // Example 2:
        //Input: words = ["a", "c", "d", "b", "a"], word1 = "a", word2 = "b"
        //Output: 1
        //Explanation: The shortest distance between "a" and "b" is 1 word. Please note that "a" appeared twice.
        // Example 3:
        //Input: words = ["a", "b", "c", "d", "e"], word1 = "a", word2 = "e"
        //Output: 4
        //Explanation: The distance between "a" and "e" is 4 words.
        //Constraints:
        //    2 <= words.length <= 3 * 104
        //    1 <= words[i].length <= 10
        //    words[i] consists of lowercase English letters.
        //    word1 and word2 are in words.
        //    word1 != word2
        System.out.println(shortestDistance(new String[]{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"}, "fox", "dog")); // 5
        System.out.println(shortestDistance(new String[]{"a", "c", "d", "b", "a"}, "a", "b")); // 1
        System.out.println(shortestDistance(new String[]{"a", "b", "c", "d", "e"}, "a", "e")); // 4

        System.out.println(shortestDistance(new String[]{"same", "same","different","differents"}, "same", "differents")); // 2
        System.out.println(shortestDistance(new String[]{"repeated", "words", "in", "the", "array", "words"}, "repeated", "words")); // 1

        System.out.println(shortestDistance(new String[]{"a", "a", "b", "b"}, "a", "b")); // 1
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        // pointers for both words, once found get the distance
        int shortestDistance = words.length;
        int pointer1 = -1;
        int pointer2 = -1;

        for (int i = 0; i < words.length; i++) {
            String current = words[i];

            if (current.equals(word1)) {
                pointer1 = i;
            } else if (current.equals(word2)) {
                pointer2 = i;
            }

            if (pointer1 != -1 && pointer2 != -1) {
                int candidate;
                if (pointer1 > pointer2) {
                    candidate = pointer1 - pointer2;
                } else {
                    candidate = pointer2 - pointer1;
                }
                shortestDistance = Math.min(shortestDistance, candidate);
            }
        }

        return shortestDistance;
    }

//    public static int shortestDistance(String[] words, String word1, String word2) {
//        // my solution - i gather positions and then check one against another
//        List<Integer> word1Positions = new ArrayList<>();
//        List<Integer> word2Positions = new ArrayList<>();
//
//        for (int i = 0; i < words.length; i++) {
//            String current = words[i];
//            if (current.equals(word1)) {
//                word1Positions.add(i);
//            } else if (current.equals(word2)) {
//                word2Positions.add(i);
//            }
//        }
//
//        // now check one against the other. how tho?
//        int p1 = 0;
//        int p2 = 0;
//        int shortest = Integer.MAX_VALUE;
//
//        // how do i go one pointer increase at a time? I also need to increment
//        while (p1 < word1Positions.size() || p2 < word2Positions.size()) {
//            // don't go out of the lists for both pointers
//            int candidate;
//            int position1 = p1 == word1Positions.size() ? word1Positions.get(p1 - 1) : word1Positions.get(p1);
//            int position2 = p2 == word2Positions.size() ? word2Positions.get(p2 - 1) : word2Positions.get(p2);
//
//            // do we actually need to compare them? well it shouldn't be a deciding factor for moving
//
//
//            if (p1 != word1Positions.size() && p2 == word2Positions.size()) {
//                // we definitely iterate through p1
//                candidate = Math.max(position1, position2) - Math.min(position1, position2);
//                p1++;
//            } else if (p1 == word1Positions.size()) {
//                candidate = Math.max(position1, position2) - Math.min(position1, position2);
//                p2++;
//            } else if (position1 > position2) {
//                candidate = position1 - position2;
//                p2++; // the ones which lost must proceed
//            } else {
//                candidate = position2 - position1;
//                p1++; // the ones which lost must proceed
//            }
//
//
//            if (shortest > candidate) {
//                shortest = candidate;
//            }
//        }
//
//        return shortest;
//    }
}
