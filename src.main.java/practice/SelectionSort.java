package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10));
        // grokking algo, page 57 - selection sort
//        int[] array = new int[]{5, 3, 6, 2, 10};

        System.out.println(Arrays.toString(selectionSort(array)));
    }

    private static int[] selectionSort(List<Integer> array) {
        int[] result = new int[array.size()];
        int iterations = array.size(); // because if we put it into for loop, it will get downsized (because we remove from an array) and we will not fill our array

        for (int i = 0; i < iterations; i++) {
            int smallestLocation = findSmallestLocation(array);
            result[i] = array.get(smallestLocation);
            array.remove(smallestLocation);
        }

        return result;
    }

    private static int findSmallestLocation(List<Integer> array) {
        int smallestLocation = 0;
        int smallestValue = array.get(smallestLocation);
        for (int i = 1; i < array.size(); i++) {
            if (smallestValue > array.get(i)) {
                smallestLocation = i;
                smallestValue = array.get(smallestLocation);
            }
        }

        return smallestLocation;
    }
}
