package leetcodeorneetcode150ordesignguruscourse.task0022_lc_1512_number_of_good_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/number-of-good-pairs-easy
        // https://leetcode.com/problems/number-of-good-pairs/description/
        // Given an array of integers nums, return the number of good pairs.
        //A pair (i, j) is called good if nums[i] == nums[j] and i < j.
        //Example 1:
        //Input: nums = [1,2,3,1,1,3]
        //Output: 4
        //Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
        System.out.println(numIdenticalPairs(new int[]{1,2,3,1,1,3})); // 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed
        System.out.println(numIdenticalPairs(new int[]{1,1,1,1})); // 6
        System.out.println(numIdenticalPairs(new int[]{1,1,1,1,1})); // 10
        System.out.println(numIdenticalPairs(new int[]{1,1,1,1,1,1})); // 15
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3})); // 0
    }

    public static int numIdenticalPairs(int[] nums) {
        // map where key is number and value is list of its positions?
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            map.computeIfAbsent(current, value -> new ArrayList<>());
            map.get(current).add(i);
        }

        // go through map, but correctly count number of pairs
        int pairsCount = 0;

        // formula is: (size * (size - 1)) / 2 - how is one supposed to figure it out?
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            pairsCount = pairsCount + ((size * (size - 1)) / 2);
        }

        return pairsCount;
    }
}
