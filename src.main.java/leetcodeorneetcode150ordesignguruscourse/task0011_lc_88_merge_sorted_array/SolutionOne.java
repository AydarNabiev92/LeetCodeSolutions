package leetcodeorneetcode150ordesignguruscourse.task0011_lc_88_merge_sorted_array;

import java.util.Arrays;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/merge-sorted-array/description/
        // You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
        // representing the number of elements in nums1 and nums2 respectively.
        // Merge nums1 and nums2 into a single array sorted in non-decreasing order.
        // The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
        // To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should
        // be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

        // Example 1:
        //Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //Output: [1,2,2,3,5,6]
        //Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        //The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

        // case 1
        int[] nums1 = new int[]{1,2,3,0,0,0};
        merge(nums1, 3, new int[]{2,5,6}, 3);

        // case 2
        int[] nums2 = new int[]{2,0};
        merge(nums2, 1, new int[]{1}, 1);

        // case 3
        int[] nums3 = new int[]{4,5,6,0,0,0};
        merge(nums3, 3, new int[]{1,2,3}, 3);

        // case 4
        int[] nums4 = new int[]{-1,0,0,3,3,3,0,0,0};
        merge(nums4, 6, new int[]{1,2,2}, 3);

        System.out.println(Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]
        System.out.println(Arrays.toString(nums2)); // [1, 2]
        System.out.println(Arrays.toString(nums3)); // [1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(nums4));  // [-1,0,0,1,2,2,3,3,3]
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // last valid index in nums1
        int j = n - 1;        // last index in nums2
        int k = m + n - 1;    // last position in nums1

        // merge from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // if nums2 has remaining elements, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        // no need to copy remaining nums1 elements: they're already in place
    }

//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        // my solution where i create a new array and copy both there. it's not good tho for space complexity (O(m+n))
//
//        // new approach - do use two pointers, but use them to create new array which at the end gets assigned to nums1
//        int[] result = new int[m + n];
//        int resultP = 0;
//
//        // two pointers
//        // use m to determine if we got to the empty part yet
//        if (n == 0) {
//            return;
//        }
//        int p1 = 0;
//        int p2 = 0;
//
//        while ((p1 < m && p2 < n) && resultP < result.length) {
//            // use m and n as checks for pointers, never use length here
//            // what to do when one of the arrays ran out?
//            if (nums1[p1] < nums2[p2]) {
//                result[resultP] = nums1[p1];
//                p1++;
//            } else {
//                result[resultP] = nums2[p2];
//                p2++;
//            }
//            resultP++;
//        }
//
//        // now fill the rest
//        while (p1 < m && resultP < result.length) {
//            result[resultP] = nums1[p1];
//            p1++;
//            resultP++;
//        }
//        while (p2 < n && resultP < result.length) {
//            result[resultP] = nums2[p2];
//            p2++;
//            resultP++;
//        }
//
//        for (int i = 0; i < nums1.length; i++) {
//            nums1[i] = result[i];
//        }
//        System.out.println(Arrays.toString(nums1));
//    }
}
