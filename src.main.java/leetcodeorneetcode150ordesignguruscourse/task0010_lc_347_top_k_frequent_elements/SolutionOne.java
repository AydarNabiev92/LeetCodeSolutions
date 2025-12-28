package leetcodeorneetcode150ordesignguruscourse.task0010_lc_347_top_k_frequent_elements;

import java.util.*;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/top-k-frequent-elements/description/
        // https://neetcode.io/problems/top-k-elements-in-list?list=neetcode150

        // Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
        // Example 1:
        //Input: nums = [1,1,1,2,2,3], k = 2
        //Output: [1,2]
        //Example 2:
        //Input: nums = [1], k = 1
        //Output: [1]
        topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // first we create how many times each number is met
        Map<Integer, Integer> timesMetByNumber = new HashMap<>();

        for (int n : nums) {
            timesMetByNumber.put(n, timesMetByNumber.getOrDefault(n, 0) + 1);
        }

        System.out.println(timesMetByNumber);

        // We need to reverse a map (its keys and values) - it's going to be how which numbers by how many times they are met.
        // Since values can overlap, new map's value must be List of ints
        Map<Integer, List<Integer>> numberByTimesMet = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : timesMetByNumber.entrySet()) {
            if (Objects.isNull(numberByTimesMet.get(entry.getValue()))) {
                numberByTimesMet.put(entry.getValue(), new ArrayList<>());
            }
            numberByTimesMet.get(entry.getValue()).add(entry.getKey());
        }
        System.out.println(numberByTimesMet);


        List<Integer> reversed = new ArrayList<>(numberByTimesMet.keySet());
        // now reverse this so make it descending by number meaning biggest come first. we can take first elements - that would be our most frequent numbers
        reversed.sort(Collections.reverseOrder());
        System.out.println(reversed);

        List<Integer> sortedByFrequency = new ArrayList<>();
        for (Integer i : reversed) {
            List<Integer> list = numberByTimesMet.get(i);
            sortedByFrequency.addAll(list);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedByFrequency.get(i);
        }

        System.out.println(Arrays.toString(result));
        return result;
    }
}
