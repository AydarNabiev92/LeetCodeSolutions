package leetcodeorneetcode150ordesignguruscourse.task0034_lc_581_shortest_unsorted_continuous_subarray;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-3-minimum-window-sort-medium
        // https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
        // Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray
        // in non-decreasing order, then the whole array will be sorted in non-decreasing order.
        //Return the shortest such subarray and output its length.
        //Example 1:
        //Input: nums = [2,6,4,8,10,9,15]
        //Output: 5
        //Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
        //Example 2:
        //Input: nums = [1,2,3,4]
        //Output: 0
        // Follow up: Can you solve it in O(n) time complexity?
        System.out.println(findUnsortedSubarray(new int[]{2,6,4,8,10,9,15})); // 5
        System.out.println(findUnsortedSubarray(new int[]{1,2,3,4})); // 0
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 5, 3, 7, 10, 9, 12})); // 5
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 0, -1, 7, 10})); // 5
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3})); // 0
        System.out.println(findUnsortedSubarray(new int[]{3, 2, 1})); // 3
    }

    public static int findUnsortedSubarray(int[] nums) {
        int result = 0;
        if (nums.length == 0 || nums.length == 1) {
            return result;
        }

        // reconsider algorithm. maybe once we track that next element is smaller than the previous we need to track how
        // deep the problem goes and go both sides. however I need to determine at which point we can be sure that
        // problematic part is over

        // or do we start from both ends and keep track of min and max? if we suddenly meet a new min and max then what we do?

        // probably an important thing - from left to right it must increase (or equal), whereas from right to left it must decrease (or equal)
        // is this the key to understanding how to solve this problem?

        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        while (leftPointer < rightPointer) {
            // from left to right - increase
            // from right to left - decrease

            // this breaks the logic! maybe because left and right ARE checked and we only need to check inside the problematic part
//            if (nums[leftPointer] < minValue) {
//                minValue = nums[leftPointer];
//            }
//            if (nums[rightPointer] > maxValue) {
//                maxValue = nums[rightPointer];
//            }

            // is there a special case where leftest is bigger than rightest? NO
            if (nums[leftPointer] > nums[leftPointer + 1] && nums[rightPointer] < nums[rightPointer - 1]) {
                // this doesn't always work properly, maybe there must be some additional logic
                // okay we found our window that is probably the whole window or it should be even bigger

                // {1, 3, 2, 0, -1, 7, 10} -> to sort {1, 3, 2, 0, -1} the answer is 5. my algo thinks it's
                // {3, 2, 0, -1} because 1 < 3, but answer is incorrect, because -1 is smaller than 1

                // {1, 3, -1, 0, 2, 7, 10} -> {1, 3, -1, 0, 2}
                // the problem is that unsorted window also has an element that is smaller than 1. and that's the thing -
                // after I determined the problem window it actually could be bigger - do I need find min and max elements
                // in the problematic window? or do I need to track numbers and their smallest/biggest positions to update
                // the window correctly? but how do I apply those correctly?

                // {1, 3, 2, 0, -1, 7, 10} -> [{1 : 0}; {3 : 1}; {2 : 2}; {0 : 3}; {-1 : 4}; {7 : 5}; {10 : 6} - unsorted
                // {1, 3, 2, 0, -1, 7, 10} -> [{-1 : 4}; {0 : 3}; {1 : 0}; {2 : 2}; {3 : 1}; {7 : 5}; {10 : 6} - sorted
                // it could be that I need to track the smallest and biggest number, but the discrepancy could start
                // not at edges, but somewhere deeper

                // so by judging an incorrect case we are not done after finding the problematic window, we somehow need
                // to determine if checked (before left and after right) is actually incorrect based on data inside the window
                // it could be that we continue scanning inside space that is between left and right to look for smallest and
                // biggest. then we start moving to the left of the left and to the right of the right comparing them to min and
                // max. if to the left is bigger than min than our left moves -1, if to the right is smaller than max than our
                // max moves +1

                // plus one because it's the size of the window. for example for this array {2,6,4,8,10,9,15} sized 7 we
                // need to sort {6,4,8,10,9}, that is from index 1 to index 5. 5 - 1 is 4, but the size is 5

                for (int i = leftPointer; i <= rightPointer; i++) {
                    int current = nums[i];
                    if (current < minValue) {
                        minValue = current;
                    }
                    if (current > maxValue) {
                        maxValue = current;
                    }
                }
                // now scan to the left and to the right
                while (leftPointer > 0 && nums[leftPointer - 1] > minValue) {
                    leftPointer--;
                }
                while (rightPointer < nums.length - 1 && nums[rightPointer + 1] < maxValue) {
                    rightPointer++;
                }

                return rightPointer - leftPointer + 1;
            }

            if (nums[leftPointer] <= nums[leftPointer + 1]) {
                leftPointer++;
            }
            if (nums[rightPointer] >= nums[rightPointer - 1]) {
                rightPointer--;
            }


        }

        return result;
    }

    public static int sort(int[] arr) {
        int result = 0;
        if (arr.length == 0 || arr.length == 1) {
            return result;
        }

        // reconsider algorithm. maybe once we track that next element is smaller than the previous we need to track how
        // deep the problem goes and go both sides. however I need to determine at which point we can be sure that
        // problematic part is over

        // or do we start from both ends and keep track of min and max? if we suddenly meet a new min and max then what we do?

        // probably an important thing - from left to right it must increase (or equal), whereas from right to left it must decrease (or equal)
        // is this the key to understanding how to solve this problem?

        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        while (leftPointer < rightPointer) {
            // from left to right - increase
            // from right to left - decrease
            if (arr[leftPointer] > arr[leftPointer + 1] && arr[rightPointer] < arr[rightPointer - 1]) {
                for (int i = leftPointer; i <= rightPointer; i++) {
                    int current = arr[i];
                    if (current < minValue) {
                        minValue = current;
                    }
                    if (current > maxValue) {
                        maxValue = current;
                    }
                }
                // now scan to the left and to the right
                while (leftPointer > 0 && arr[leftPointer - 1] > minValue) {
                    leftPointer--;
                }
                while (rightPointer < arr.length - 1 && arr[rightPointer + 1] < maxValue) {
                    rightPointer++;
                }

                return rightPointer - leftPointer + 1;
            }

            if (arr[leftPointer] <= arr[leftPointer + 1]) {
                leftPointer++;
            }
            if (arr[rightPointer] >= arr[rightPointer - 1]) {
                rightPointer--;
            }


        }

        return result;
    }
}
