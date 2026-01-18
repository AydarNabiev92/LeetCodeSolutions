package leetcodeorneetcode150ordesignguruscourse.task0017_lc_56_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionTwo {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/merge-intervals-medium
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
        System.out.println(Arrays.deepToString(merge(new int[][]{new int[]{1, 2}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}}))); // [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(merge(new int[][]{new int[]{1,4}, new int[]{4,5}}))); // [[1,5]]
        System.out.println(Arrays.deepToString(merge(new int[][]{new int[]{4,7}, new int[]{1,4}}))); // [[1,7]]
        System.out.println(Arrays.deepToString(merge(new int[][]{new int[]{1,4}, new int[]{2,3}}))); // [[1,4]]

        Interval interval1 = new Interval(4, 7);
        Interval interval2 = new Interval(1, 4);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        System.out.println(merge(intervals)); // [[1,7]]
        System.out.println(mergeByDGCanon(intervals)); // [[1,7]]
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));

        // now iterate through them, merge if they overlap
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length - 1; i++) {
            int[] current = intervals[i];
            int[] next = intervals[i + 1];
            if (current[1] >= next[0]) {
                intervals[i + 1] = new int[]{current[0], Math.max(current[1], next[1])};
            } else {
                list.add(current);
            }
        }

        // don't forget the last one
        list.add(intervals[intervals.length - 1]);

        return list.toArray(new int[list.size()][]);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));

        // now iterate through them, merge if they overlap
        List<Interval> list = new ArrayList<>();

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1);
            if (current.end >= next.start) {
                intervals.get(i + 1).start = current.start;
                intervals.get(i + 1).end = Math.max(current.end, next.end);
            } else {
                list.add(current);
            }
        }

        // don't forget the last one
        list.add(intervals.get(intervals.size() - 1));

        return list;
    }

    public static List<Interval> mergeByDGCanon(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }
        intervals.sort(Comparator.comparingInt(o -> o.start));

        // now iterate through them, merge if they overlap
        List<Interval> list = new ArrayList<>();

        // take the first one start and end
        // then iterate through
        Integer start = intervals.get(0).start;
        Integer end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start <= end) {
                end = Math.max(end, current.end);
            } else {
                list.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }

        list.add(new Interval(start, end));

        return list;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
