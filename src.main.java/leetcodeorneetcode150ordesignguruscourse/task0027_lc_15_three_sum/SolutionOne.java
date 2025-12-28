package leetcodeorneetcode150ordesignguruscourse.task0027_lc_15_three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/triplet-sum-to-zero-medium
        // https://leetcode.com/problems/3sum/description/
        // Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        //Notice that the solution set must not contain duplicate triplets.
        //Example 1:
        //Input: nums = [-1,0,1,2,-1,-4]
        //Output: [[-1,-1,2],[-1,0,1]]
        //Explanation:
        //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        //The distinct triplets are [-1,0,1] and [-1,-1,2].
        //Notice that the order of the output and the order of the triplets does not matter.
        //Example 2:
        //Input: nums = [0,1,1]
        //Output: []
        //Explanation: The only possible triplet does not sum up to 0.
        //Example 3:
        //Input: nums = [0,0,0]
        //Output: [[0,0,0]]
        //Explanation: The only possible triplet sums up to 0.
        // Constraints:
        //3 <= nums.length <= 3000
        //-105 <= nums[i] <= 105
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{0,1,1})); // []
        System.out.println(threeSum(new int[]{0,0,0})); // [[0,0,0]]
        System.out.println(threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10})); // [[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]
        System.out.println(threeSum(new int[]{11,3,13,-14,12,-13,14,-7,-1,14,5,-15,-11,-15,9,11,-6,-11,-15,-5,-3,5,-7,10,11,11,-10,-3,-4,8,-15,-15,-4,6,8,
                -6,8,7,-6,-8,6,6,-8,11,-1,8,-1,8,13,-1,-11,-5,-11,-3,12,8,-15,-13,-10,-11,3,12,11,14,3,4,-15,-4,-4,-13,-5,9,8,2,-3,-8,-12,12,-14,-14,-12,12,
                -12,-7,-14,8,8,9,10,13,13,-10,2,9,-10,-9,-10,12,2,1,14,13,-13,8,-8,0,7,-5,-11,0,-12,-8,-11,-8,-8,-9,-15,-15}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        // sort array and then we go from left to right, this will be first from the sum. the remaining two are going
        // to be found using two pointers - left is after the first element of the sum and right starts at the end. if
        // our sum is bigger than 0 then we move right pointer, otherwise left until we find our sum

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int firstElementOfTheSum = nums[i];
            int requiredSumForZero = -firstElementOfTheSum;
            // now let's check the remaining array with two pointers
            int secondIndice = i + 1;
            int thirdIndice = nums.length - 1;
            while (secondIndice < thirdIndice) {
                int sum = nums[secondIndice] + nums[thirdIndice];
                if (sum == requiredSumForZero) {
                    result.add(Arrays.asList(nums[i], nums[secondIndice], nums[thirdIndice]));

                    int currentLeftVal = nums[secondIndice];
                    int currentRightVal = nums[thirdIndice];

                    while (secondIndice < thirdIndice && nums[secondIndice] == currentLeftVal) {
                        secondIndice++;
                    }
                    while (secondIndice < thirdIndice && nums[thirdIndice] == currentRightVal) {
                        thirdIndice--;
                    }
                } else if (sum > requiredSumForZero) {
                    thirdIndice--;
                } else {
                    secondIndice++;
                }
            }

        }

        return result;
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        if (arr.length < 3) {
            return new ArrayList<>();
        }

        // sort array and then we go from left to right, this will be first from the sum. the remaining two are going
        // to be found using two pointers - left is after the first element of the sum and right starts at the end. if
        // our sum is bigger than 0 then we move right pointer, otherwise left until we find our sum

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i <= arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int firstElementOfTheSum = arr[i];
            int requiredSumForZero = -firstElementOfTheSum;
            // now let's check the remaining array with two pointers
            int secondIndice = i + 1;
            int thirdIndice = arr.length - 1;
            while (secondIndice < thirdIndice) {
                int sum = arr[secondIndice] + arr[thirdIndice];
                if (sum == requiredSumForZero) {
                    result.add(Arrays.asList(arr[i], arr[secondIndice], arr[thirdIndice]));

                    int currentLeftVal = arr[secondIndice];
                    int currentRightVal = arr[thirdIndice];

                    while (secondIndice < thirdIndice && arr[secondIndice] == currentLeftVal) {
                        secondIndice++;
                    }
                    while (secondIndice < thirdIndice && arr[thirdIndice] == currentRightVal) {
                        thirdIndice--;
                    }
                } else if (sum > requiredSumForZero) {
                    thirdIndice--;
                } else {
                    secondIndice++;
                }
            }

        }

        return result;
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        if (nums.length < 3) {
//            return new ArrayList<>();
//        }
//
//        // maybe I need to sort the array and then use sliding window?
//
//        List<List<Integer>> result = new ArrayList<>();
////        Arrays.sort(nums);
//
//        // now use two pointers - one from the beginning, another from the end
//        // but how do I approach this for 3 sum? for 2 sum it's fairly easy
//        // {-4, -1, -1, 0, 1, 2}
//        // do I also create hashmap that stores values and their indices? then I work with two pointers - they create
//        // sums and then I look for the remainder in the map so that it results in zero
//        Map<Integer, List<Integer>> indicesByNumber = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int currentValue = nums[i];
//            if (!indicesByNumber.containsKey(currentValue)) {
//                indicesByNumber.put(currentValue, new ArrayList<>());
//            }
//            indicesByNumber.get(currentValue).add(i);
//        }
//
//        // now, go for two pointers
//        int left = 0;
//        int right = 1;
//        while (left < nums.length - 1 && right < nums.length) {
//            // simply changing end pointers is no use. however scanning all possible combinations can work
//            int neededRemainder = - nums[left] - nums[right];
//            if (indicesByNumber.containsKey(neededRemainder)) {
//                List<Integer> indices = indicesByNumber.get(neededRemainder);
//                for (Integer indice : indices) {
//                    if (indice != left && indice != right && left != right) {
//                        List<Integer> threeSum = Arrays.asList(nums[left], nums[right], nums[indice]);
//                        Collections.sort(threeSum);
//                        if (!result.contains(threeSum)) {
//                            result.add(threeSum);
//                        }
//                    }
//                }
//            }
//            // now, how do I move? it could be useful to change one at a time. but only until one of the pointers reaches the end
//            // well also, both need to travel the same distance, so there should be no problem, right?
//            // UPD. this part has to change - no squeezing space between pointers, instead pointer 1 stays with one of the elements
//            // while the others goes from pointer 1 + 1 to end of array
//            if (right != nums.length - 1) {
//                right++;
//            } else {
//                left++;
//                right = left + 1;
//            }
//        }
//
//        // main problem - it's too slow. maybe I can sort array somehow to make it faster? how to transfer from 2sum to 3sum?
//
//        return result;
//    }
}
