package leetcodeorneetcode150ordesignguruscourse.task0050_lc_57_insert_interval;

import java.util.*;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/insert-interval-medium
        // https://leetcode.com/problems/insert-interval/description/
        // Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct
        // position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
        //Example 1:
        //Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
        //Output: [[1,3], [4,7], [8,12]]
        //Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
        //Example 2:
        //Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
        //Output: [[1,3], [4,12]]
        //Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
        //Example 3:
        //Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
        //Output: [[1,4], [5,7]]
        //Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
        System.out.println("Case one, Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]");
        System.out.println("Result is " + Arrays.deepToString(insert(new int[][]{new int[]{1, 3}, new int[]{4, 7}, new int[]{8, 12}}, new int[]{4, 6})) + ", must be [[1,3], [4,7], [8,12]]"); // [[1,3], [4,7], [8,12]]
        System.out.println("===========================================================================");
        System.out.println("Case two, Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]");
        System.out.println("Result is " + Arrays.deepToString(insert(new int[][]{new int[]{1, 3}, new int[]{4, 7}, new int[]{8, 12}}, new int[]{4, 10})) + ", must be [[1,3], [4,12]]"); // [[1,3], [4,12]]
        System.out.println("===========================================================================");
        System.out.println("Case three, Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]");
        System.out.println("Result is " + Arrays.deepToString(insert(new int[][]{new int[]{2, 3}, new int[]{5, 7}}, new int[]{1, 4})) + ", must be [[1,4], [5,7]]"); // [[1,4], [5,7]]
        System.out.println("===========================================================================");
        System.out.println("Case four, Input: Intervals=[[1,5]], New Interval=[0,0]");
        System.out.println("Result is " + Arrays.deepToString(insert(new int[][]{new int[]{1, 5}}, new int[]{0, 0})) + ", must be [[0,0],[1,5]]"); // [[0,0],[1,5]]
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length < 1) {
            return new int[][]{newInterval};
        }
        // until we meet interval where its end is before new's start, we simply add to the list
        // then we determine the new end by understanding which end is bigger - the new one or the current one
        // then we skip all intervals until the one which start is after the new end
        List<int[]> list = new ArrayList<>();
        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];
        boolean foundOverlap = false;
        boolean addedNewInterval = false;

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            int currentStart = current[0];
            int currentEnd = current[1];

            // WE ALWAYS ADD:
            // until we meet our interval meaning current end is smaller than new start
            // after we added new, meaning current start is bigger than new end
            // WHEN DO WE ADD NEW THO?
            // when current end is bigger than new end
            if (!foundOverlap) {
                // 1 ADD UNTIL NEW INTERVAL OVERLAPS WITH CURRENT
                if (currentStart > newIntervalEnd) {
                    list.add(new int[]{newIntervalStart, newIntervalEnd});
                    foundOverlap = true;
                    addedNewInterval = true;
                    list.add(current);
                } else if (currentEnd < newIntervalStart) {
                    list.add(current);
                } else {
                    // 2 THEN GET THE SMALLEST START AND BIGGEST END
                    newIntervalStart = Math.min(currentStart, newIntervalStart);
                    newIntervalEnd = Math.max(currentEnd, newIntervalEnd);
                    foundOverlap = true;
                }
            } else {
                // 3 THEN USE BIGGEST END TO SKIP INTERVALS AFTER - IF CURRENT END IS SMALLER THEN BIGGEST END WE SKIP
                if (!addedNewInterval) {
                    // 4 NOW YOU'VE MET END THAT IS BIGGER THAN BIGGEST - ADD NEWLY CREATED INTERVAL
                    if (currentEnd >= newIntervalEnd) { // otherwise we skip
                        // we need to correctly understand cases here - they can overlap and they can be two independent intervals
                        if (currentStart > newIntervalEnd) {
                            list.add(new int[]{newIntervalStart, newIntervalEnd});
                            addedNewInterval = true;
                            list.add(current);
                        } else {
                            list.add(new int[]{newIntervalStart, currentEnd});
                            addedNewInterval = true;
                        }
                    }
                } else {
                    // 5 ADD THE REST OF THE INTERVALS
                    list.add(current);
                }

            }
        }
        if (!addedNewInterval) {
            list.add(new int[]{newIntervalStart, newIntervalEnd});
        }

        return list.toArray(new int[list.size()][]);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() < 1) {
            return List.of(newInterval);
        }
        // until we meet interval where its end is before new's start, we simply add to the list
        // then we determine the new end by understanding which end is bigger - the new one or the current one
        // then we skip all intervals until the one which start is after the new end
        List<Interval> list = new ArrayList<>();
        int newIntervalStart = newInterval.start;
        int newIntervalEnd = newInterval.end;
        boolean foundOverlap = false;
        boolean addedNewInterval = false;

        for (int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            int currentStart = current.start;
            int currentEnd = current.end;

            // WE ALWAYS ADD:
            // until we meet our interval meaning current end is smaller than new start
            // after we added new, meaning current start is bigger than new end
            // WHEN DO WE ADD NEW THO?
            // when current end is bigger than new end
            if (!foundOverlap) {
                // 1 ADD UNTIL NEW INTERVAL OVERLAPS WITH CURRENT
                if (currentStart > newIntervalEnd) {
                    list.add(new Interval(newIntervalStart, newIntervalEnd));
                    foundOverlap = true;
                    addedNewInterval = true;
                    list.add(current);
                } else if (currentEnd < newIntervalStart) {
                    list.add(current);
                } else {
                    // 2 THEN GET THE SMALLEST START AND BIGGEST END
                    newIntervalStart = Math.min(currentStart, newIntervalStart);
                    newIntervalEnd = Math.max(currentEnd, newIntervalEnd);
                    foundOverlap = true;
                }
            } else {
                // 3 THEN USE BIGGEST END TO SKIP INTERVALS AFTER - IF CURRENT END IS SMALLER THEN BIGGEST END WE SKIP
                if (!addedNewInterval) {
                    // 4 NOW YOU'VE MET END THAT IS BIGGER THAN BIGGEST - ADD NEWLY CREATED INTERVAL
                    if (currentEnd >= newIntervalEnd) { // otherwise we skip
                        // we need to correctly understand cases here - they can overlap and they can be two independent intervals
                        if (currentStart > newIntervalEnd) {
                            list.add(new Interval(newIntervalStart, newIntervalEnd));
                            addedNewInterval = true;
                            list.add(current);
                        } else {
                            list.add(new Interval(newIntervalStart, currentEnd));
                            addedNewInterval = true;
                        }
                    }
                } else {
                    // 5 ADD THE REST OF THE INTERVALS
                    list.add(current);
                }

            }
        }
        if (!addedNewInterval) {
            list.add(new Interval(newIntervalStart, newIntervalEnd));
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
