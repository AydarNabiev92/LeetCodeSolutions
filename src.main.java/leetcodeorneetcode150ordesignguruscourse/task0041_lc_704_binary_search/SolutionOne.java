package leetcodeorneetcode150ordesignguruscourse.task0041_lc_704_binary_search;

public class SolutionOne {
    public static void main(String[] args) {
        // https://leetcode.com/problems/binary-search/description/
        // Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
        // to search target in nums. If target exists, then return its index. Otherwise, return -1.
        //You must write an algorithm with O(log n) runtime complexity.
        //Example 1:
        //Input: nums = [-1,0,3,5,9,12], target = 9
        //Output: 4
        //Explanation: 9 exists in nums and its index is 4
        //Example 2:
        //Input: nums = [-1,0,3,5,9,12], target = 2
        //Output: -1
        //Explanation: 2 does not exist in nums so return -1
        //Constraints:
        //1 <= nums.length <= 104
        //-104 < nums[i], target < 104
        //All the integers in nums are unique.
        //nums is sorted in ascending order.
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9)); // 4
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2)); // -1
        System.out.println(search(new int[]{5}, 5)); // 0
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // simple binary search, huh
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middleIndex = (left + right) / 2;
            if (nums[middleIndex] == target) {
                return middleIndex;
            } else if (nums[middleIndex] < target) {
                left = middleIndex + 1;
            } else {
                right = middleIndex - 1;
            }
        }

        return -1;
    }
}
