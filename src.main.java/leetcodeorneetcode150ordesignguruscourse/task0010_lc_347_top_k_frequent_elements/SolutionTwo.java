package leetcodeorneetcode150ordesignguruscourse.task0010_lc_347_top_k_frequent_elements;

import java.util.*;

public class SolutionTwo {
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
        // redo solution using buckets
        // create buckets. how many? number of elements in nums
        if (nums.length == 1) {
            return nums;
        }
        int[] buckets = new int[nums.length];

        TreeMap<Integer, List<Integer>> frequencyMap = new TreeMap<>();
        // fill buckets then move this to map?
        for (int i : nums) {
            buckets[i]++;
        }

//        for (int i = 0; i < buckets.length; i++) {
        for (int i = buckets.length - 1; i >= 0; i--) {
            int bucket = buckets[i];
            if (Objects.isNull(frequencyMap.get(bucket))) {
                frequencyMap.put(bucket, new ArrayList<>());
            }
            frequencyMap.get(bucket).add(i);
        }

        System.out.println(frequencyMap);
        int[] result = new int[k];
        int currentIndex = 0;
        for (Map.Entry<Integer, List<Integer>> entry : frequencyMap.descendingMap().entrySet()) {
            if (currentIndex == k) {
                break;
            }
            List<Integer> numbers = entry.getValue();
            if (!numbers.isEmpty()) {
                for (int number : numbers) {
                    result[currentIndex] = number;
                    currentIndex++;
                    if (currentIndex == k) {
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(result));

        return null;
    }
}
