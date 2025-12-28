package leetcodeorneetcode150ordesignguruscourse.task0017_lc_56_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/merge-intervals/description/
        // Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return
        // an array of the non-overlapping intervals that cover all the intervals in the input.
        //Example 1:
        //Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        //Output: [[1,6],[8,10],[15,18]]
        //Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
        //Example 2:
        //Input: intervals = [[1,4],[4,5]]
        //Output: [[1,5]]
        //Explanation: Intervals [1,4] and [4,5] are considered overlapping.
        System.out.println(Arrays.toString(merge(new int[][]{new int[]{1, 2}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}}))); // [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.toString(merge(new int[][]{new int[]{1,4}, new int[]{4,5}}))); // [[1,5]]
        System.out.println(Arrays.toString(merge(new int[][]{new int[]{4,7}, new int[]{1,4}}))); // [[1,7]]
        System.out.println(Arrays.toString(merge(new int[][]{new int[]{1,4}, new int[]{1,4}}))); // [[1,4]]
        System.out.println(Arrays.toString(merge(new int[][]{new int[]{1,4}, new int[]{2,3}}))); // [[1,4]]
        System.out.println(Arrays.toString(merge(new int[][]{new int[]{2, 3}, new int[]{5, 5}, new int[]{2, 2}, new int[]{3, 4}, new int[]{3, 4}}))); // [[1,5]]
    }

    public static int[][] merge(int[][] intervals) {
        // Time complexity: O(n * log n) - because Arrays.sort has that TC
        // Space complexity: O(n) extra

        // sort by starting value then merge one with another
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //            @Override
        //            public int compare(int[] o1, int[] o2) {
        //                return o1[0] - o2[0];
        //            }
        //        }); same thing below
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] current = intervals[i];
            int[] next = intervals[i + 1];
            if (current[1] >= next[0]) {
                // merge
                intervals[i + 1] = new int[]{current[0], Math.max(current[1], next[1])};
            } else {
                list.add(current);
            }
        }

        // don't forget the last one
        list.add(intervals[intervals.length - 1]);

        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    /*public static int[][] merge(int[][] intervals) {
        // brute-force - go through all of them
        // they seem like they are sorted - are they? if so, can I use that to my advantage?
        // HUGE CORRECTION - they are NOT sorted, look at an example 3
        // at most there can be as many intervals as there are given. at least there can be only one
        // overlapping is decided with comparing higher bound of one to the lower bound of another

        // can i use sliding window here? or can i have int array first for all intervals?

        // let's work with the map where key is start of the interval and value is its end. then we sort keys ascending and work with that
        if (intervals.length == 1) {
            return intervals;
        }

        Map<Integer, Integer> endByStart = new HashMap<>();

        // this WON'T work because we need to have our duplicate elements. or do I simply need to keep the biggest one?
        for (int[] interval : intervals) {
            endByStart.merge(interval[0], interval[1], Math::max);
        }

        // now let's order it properly
        TreeSet<Integer> set = new TreeSet<>(endByStart.keySet());

        int[][] ordered = new int[intervals.length][];
        Iterator<Integer> iterator = set.iterator();
        // now let's work through our ordered set
        for (int i = 0; i < set.size(); i++) {
            int currentStart = iterator.next();
            ordered[i] = new int[]{currentStart, endByStart.get(currentStart)};
        }

        if (endByStart.size() == 1) {
            return new int[][]{ordered[0]};
        }

        int[][] preResult = new int[intervals.length][];
        int counter = 0;
        boolean foundNull = false;
        // now let's go through each because they are sorted
        for (int i = 0; i < ordered.length - 1; i++) {
            // remember the algo? compare to the next one
            int[] current = ordered[i];
            int[] next = ordered[i + 1];
            // in case some of them were merged - we can't go into the null ones
            if (next == null) {
                foundNull = true;
                preResult[counter] = current;
                counter++;
                break;
            }
            if (current[1] >= next[0]) {
                // merge
                ordered[i + 1] = new int[]{current[0], Math.max(current[1], next[1])};
            } else {
                preResult[counter] = current;
                counter++;
            }
        }

        if (!foundNull) {
            preResult[counter] = ordered[ordered.length - 1];
            counter++;
        }

        int[][] result = new int[counter][];
        for (int i = 0; i < counter; i++) {
            result[i] = preResult[i];
        }

        return result;
    }*/
}
