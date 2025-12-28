package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveSum {
    public static void main(String[] args) {
        // grokking algo, page 85 - recursive
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));

        System.out.println(sum(array));
    }

    private static int sum(List<Integer> array) {
        if (array.size() == 0) { // base case
            return 0;
        } else { // recursive case
            int firstElement = array.get(0);
            array.remove(0);
            return firstElement + sum(array);
        }
    }
}
