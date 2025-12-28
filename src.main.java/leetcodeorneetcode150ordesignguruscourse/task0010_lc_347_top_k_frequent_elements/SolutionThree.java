package leetcodeorneetcode150ordesignguruscourse.task0010_lc_347_top_k_frequent_elements;

import java.util.*;

public class SolutionThree {
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
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{-1, -1}, 1)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // chatgpt bucket sort solution
        // 1) Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // 2) Buckets: index = frequency, value = list of numbers with that frequency
        // max possible frequency = nums.length
        // Why nums.length + 1?
        //Max frequency any number can have = nums.length (if array exists of one number)
        //We want buckets[f] = all numbers that appear exactly f times
        //We ignore index 0, because frequency 0 makes no sense
        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();

            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(number);
        }

        // 3) Go from highest frequency to lowest, collect k elements
        int[] result = new int[k];
        int idx = 0;

        for (int f = buckets.length - 1; f >= 0 && idx < k; f--) {
            if (buckets[f] == null) continue;

            for (int num : buckets[f]) {
                result[idx++] = num;
                if (idx == k) break; // we have k elements, stop
            }
        }

        return result;
    }
}
