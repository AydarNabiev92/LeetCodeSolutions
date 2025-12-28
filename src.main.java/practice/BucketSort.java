package practice;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        // given by chatgpt - bucket sort task
        // You are given an integer array where each value is guaranteed to be between 0 and 5. Sort the array.
        // Example: Input: [3, 1, 4, 1, 0, 2, 5, 3]
        // Output: [0, 1, 1, 2, 3, 3, 4, 5]
        System.out.println(Arrays.toString(bucketSortSimple(new int[]{3, 1, 4, 1, 0, 2, 5, 3})));
    }

    /*public static int[] bucketSortSimple(int[] arr) {

        int[] bucket = new int[6]; // numbers are 0..5. but universally number of buckets = maxValue - minValue + 1

        // fill buckets - each bucket counts number of occurrences of each element
        for (int x : arr) {
            bucket[x]++;
        }

        // we counted occurrences - now we need to go bucket by bucket and fill it. for example our buckets shown that
        // we have one element that is 0, two elements that are 1, three elements that are 2. we need to make first
        // element of the result 0, then have two 1s, then have three 2s and we end up with a sorted array
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int count = 0; count < bucket[i]; count++) {
                arr[index++] = i;
            }
        }

        return arr;
    }*/

    public static int[] bucketSortSimple(int[] arr) {
        // my solution based on how I understood it
        int[] bucket = new int[6]; // numbers are 0..5. but universally number of buckets = maxValue - minValue + 1

        // fill buckets - each bucket counts number of occurrences of each element
        for (int i : arr) {
            bucket[i]++;
        }

        // we counted occurrences - now we need to go bucket by bucket and fill it. for example our buckets shown that
        // we have one element that is 0, two elements that are 1, three elements that are 2. we need to make first
        // element of the result 0, then have two 1s, then have three 2s and we end up with a sorted array
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] != 0) {
                arr[index] = i;
                bucket[i]--;
                index++;
            }
        }

        return arr;
    }
}
