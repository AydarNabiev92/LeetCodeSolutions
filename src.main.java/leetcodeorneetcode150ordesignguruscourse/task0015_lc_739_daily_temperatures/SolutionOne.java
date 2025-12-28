package leetcodeorneetcode150ordesignguruscourse.task0015_lc_739_daily_temperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/daily-temperatures/description/
        // Given an array of integers temperatures represents the daily temperatures, return an array answer such that
        // answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
        //Example 1:
        //Input: temperatures = [73,74,75,71,69,72,76,73]
        //Output: [1,1,4,2,1,1,0,0]
        //Example 2:
        //Input: temperatures = [30,40,50,60]
        //Output: [1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}))); // [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,40,50,60}))); // [1,1,1,0]
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        // how to use stack here?

        // we start from the right. either way we push to the stack

        // stack keeps indices of the array. we only pop if our top of the stack loses to the current (that's because we

        // no longer need it for next numbers because the current already won!). that way we always keep champions and get

        // rid of losers (losers for the elements lefter)


        int[] result = new int[temperatures.length];


        Deque<Integer> temperatureChampionIndices = new ArrayDeque<>();


        for (int i = temperatures.length - 1; i >= 0; i--) {

            // algo - check for stack by peeking. if it wins the match then we keep it (we need our champions) otherwise

            // we pop and continue to peek. if stack ends up being empty then it needs to be 0

            int currentTemperature = temperatures[i];

            boolean foundHigher = false;

            // we keep popping until we find higher or we run out of elements


            while (!temperatureChampionIndices.isEmpty()) {

                if (currentTemperature >= temperatures[temperatureChampionIndices.peek()]) {

                    temperatureChampionIndices.pop();

                } else {

                    result[i] = temperatureChampionIndices.peek() - i;

                    foundHigher = true;

                    break;

                }

            }



            // made a mistake here and put this into lower if. but we always need to push for next elements - they CAN be

            // lower than the current one in that case we must check them against this one, not the global champion

            temperatureChampionIndices.push(i);


            if (!foundHigher) {

                result[i] = 0;

            }


        }


        return result;

    }

//    public static int[] dailyTemperatures(int[] temperatures) {
//        // Time complexity. Outer loop: runs n times. Inner loop: in worst case iterates over all distinct temperatures → up to u.
//        //So: Time=O(n⋅u)
//        //For this specific problem, LeetCode constrains temperatures to something like [30..100], so u ≤ ~71 → effectively O(71·n) ≈ O(n) in practice.
//
//        // Space complexity
//        //result → size n
//        //leftestPositionByTemperature → at most u entries
//        //So: Extra space for the algorithm: O(u)
//        //Overall (including result array): O(n + u), typically written as O(n).
//        //Given the temp bounds, the map is effectively O(1) size, but it’s fine to say O(n) in generic terms.
//
//        // go from right to left remembering all positions?
//        int[] result = new int[temperatures.length];
//        Map<Integer, Integer> leftestPositionByTemperature = new HashMap<>();
//
//        for (int i = temperatures.length - 1; i >= 0; i--) {
//            int currentTemperature = temperatures[i];
//            leftestPositionByTemperature.put(currentTemperature, i);
//            // now check for position
//            // let's find the closest to the current
//            int closestPosition = Integer.MAX_VALUE;
//            for (Map.Entry<Integer, Integer> entry : leftestPositionByTemperature.entrySet()) {
//                if (entry.getKey() > currentTemperature) {
//                    if (entry.getValue() < closestPosition) {
//                        closestPosition = entry.getValue();
//                    }
//                }
//            }
//            if (closestPosition == Integer.MAX_VALUE) {
//                closestPosition = 0;
//            }
//            result[i] = closestPosition == 0 ? closestPosition : closestPosition - i;
//        }
//
//        return result;
//    }

//    public static int[] dailyTemperatures(int[] temperatures) {
//        // this is n^2, way too long
//        int[] result = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            int current = temperatures[i];
//            int counter = 0;
//            for (int j = i + 1; j < temperatures.length; j++) {
//                // if we hit the end and we didn't yet find higher then this needs to be zero
//                counter++;
//                if (temperatures[j] > current) {
//                    break;
//                }
//                if (j == temperatures.length - 1) {
//                    counter = 0;
//                }
//            }
//            result[i] = counter;
//        }
//
//        return result;
//    }
}
