package leetcodeorneetcode150ordesignguruscourse.task0051_lc_986_interval_list_intersections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/intervals-intersection-medium
        // https://leetcode.com/problems/interval-list-intersections/description/
        // You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi]
        // and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
        //Return the intersection of these two interval lists.
        //A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
        //The intersection of two closed intervals is a set of real numbers that are either empty or represented as a
        // closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
        // Example 1
        // Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
        //Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        //Example 2:
        //Input: firstList = [[1,3],[5,9]], secondList = []
        //Output: []
        System.out.println("Case one, Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]");
        System.out.println("Result is " + Arrays.deepToString(intervalIntersection(new int[][]{new int[]{0, 2}, new int[]{5, 10}, new int[]{13, 23}, new int[]{24, 25}}, new int[][]{new int[]{1, 5}, new int[]{8, 12}, new int[]{15, 24}, new int[]{25, 26}})) + ", must be [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]"); // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        System.out.println("===========================================================================");
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][];
        }

        // we probably must create new intervals on the fly, but understanding their bounds is the hardest challenge here
        // two pointers, huh?
        int firstPointer = 0;
        int secondPointer = 0;
        List<int[]> list = new ArrayList<>();

        while (firstPointer < firstList.length && secondPointer < secondList.length) {
            int[] firstInterval = firstList[firstPointer];
            int[] secondInterval = secondList[secondPointer];

            // conditions:
            // first interval is fully before second interval - increase first
            // first interval is fully after second interval - increase second
            // intervals overlap - several cases, too?
            if (firstInterval[1] < secondInterval[0]) {
                firstPointer++;
            } else if (firstInterval[0] > secondInterval[1]) {
                secondPointer++;
            } else {
                // overlap! determine intersection and then move appropriate pointer appropriately
                // now, how to determine which one will need to go up after intersection?
                // also what if intersection still going from previous iterations?
                list.add(new int[]{Math.max(firstInterval[0], secondInterval[0]), Math.min(firstInterval[1], secondInterval[1])});
                if (firstInterval[1] < secondInterval[1]) {
                    firstPointer++;
                } else {
                    secondPointer++;
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public List<Interval> merge(Interval[] arr1, Interval[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            new ArrayList<>();
        }

        // we probably must create new intervals on the fly, but understanding their bounds is the hardest challenge here
        // two pointers, huh?
        int firstPointer = 0;
        int secondPointer = 0;
        List<Interval> list = new ArrayList<>();

        while (firstPointer < arr1.length && secondPointer < arr2.length) {
            Interval firstInterval = arr1[firstPointer];
            Interval secondInterval = arr2[secondPointer];

            // conditions:
            // first interval is fully before second interval - increase first
            // first interval is fully after second interval - increase second
            // intervals overlap - several cases, too?
            if (firstInterval.end < secondInterval.start) {
                firstPointer++;
            } else if (firstInterval.start > secondInterval.end) {
                secondPointer++;
            } else {
                // overlap! determine intersection and then move appropriate pointer appropriately
                // now, how to determine which one will need to go up after intersection?
                // also what if intersection still going from previous iterations?
                list.add(new Interval(Math.max(firstInterval.start, secondInterval.start), Math.min(firstInterval.end, secondInterval.end)));
                if (firstInterval.end < secondInterval.end) {
                    firstPointer++;
                } else {
                    secondPointer++;
                }
            }
        }

        return list;
    }

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
