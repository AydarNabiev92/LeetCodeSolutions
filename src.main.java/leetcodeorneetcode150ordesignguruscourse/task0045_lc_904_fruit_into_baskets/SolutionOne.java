package leetcodeorneetcode150ordesignguruscourse.task0045_lc_904_fruit_into_baskets;

import java.util.HashMap;
import java.util.Map;

public class SolutionOne {
    public static void main(String[] args) {
        // https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/fruits-into-baskets-medium
        // https://leetcode.com/problems/fruit-into-baskets/
        // You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented
        // by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
        //You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
        //You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
        //Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
        //Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
        //Given the integer array fruits, return the maximum number of fruits you can pick.
        //Example 1:
        //Input: fruits = [1,2,1]
        //Output: 3
        //Explanation: We can pick from all 3 trees.
        //Example 2:
        //Input: fruits = [0,1,2,2]
        //Output: 3
        //Explanation: We can pick from trees [1,2,2].
        //If we had started at the first tree, we would only pick from trees [0,1].
        //Example 3:
        //Input: fruits = [1,2,3,2,2]
        //Output: 4
        //Explanation: We can pick from trees [2,3,2,2].
        //If we had started at the first tree, we would only pick from trees [1,2].
        // Constraints:
        //1 <= fruits.length <= 10squared5
        //0 <= fruits[i] < fruits.length
        System.out.println(totalFruit(new int[]{1, 2, 1})); // 3
        System.out.println(totalFruit(new int[]{0, 1, 2, 2})); // 3
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2})); // 4
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4})); // 5
    }

    public static int totalFruit(int[] fruits) {
        if (fruits.length < 2) {
            return fruits.length;
        }

        int left = 0;
        Map<Integer, Integer> basketsWithFruits = new HashMap<>();
        basketsWithFruits.put(fruits[left], 1);

        int max = 1;

        int right;
        for (right = 1; right < fruits.length; right++) {
            int rightFruit = fruits[right];
            // if window is filled and this fruit is not there, we need to check if new max is found and adjust
            // if window is not filled then we add this fruit
            if (!basketsWithFruits.containsKey(rightFruit)) {
                if (basketsWithFruits.size() == 2) {
                    while (left < right && basketsWithFruits.size() == 2) {
                        int leftFruit = fruits[left];
                        if (basketsWithFruits.get(leftFruit) == 1) {
                            basketsWithFruits.remove(leftFruit);
                        } else {
                            basketsWithFruits.put(leftFruit, basketsWithFruits.get(leftFruit) - 1);
                        }
                        left++;
                    }
                }
                basketsWithFruits.put(rightFruit, 1);
            } else {
                basketsWithFruits.put(rightFruit, basketsWithFruits.get(rightFruit) + 1);
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public int findLength(char[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }

        int left = 0;
        Map<Character, Integer> basketsWithFruits = new HashMap<>();
        basketsWithFruits.put(arr[left], 1);

        int max = 1;

        int right;
        for (right = 1; right < arr.length; right++) {
            char rightFruit = arr[right];
            // if window is filled and this fruit is not there, we need to check if new max is found and adjust
            // if window is not filled then we add this fruit
            if (!basketsWithFruits.containsKey(rightFruit)) {
                if (basketsWithFruits.size() == 2) {
                    while (left < right && basketsWithFruits.size() == 2) {
                        char leftFruit = arr[left];
                        if (basketsWithFruits.get(leftFruit) == 1) {
                            basketsWithFruits.remove(leftFruit);
                        } else {
                            basketsWithFruits.put(leftFruit, basketsWithFruits.get(leftFruit) - 1);
                        }
                        left++;
                    }
                }
                basketsWithFruits.put(rightFruit, 1);
            } else {
                basketsWithFruits.put(rightFruit, basketsWithFruits.get(rightFruit) + 1);
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
