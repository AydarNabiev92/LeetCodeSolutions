package practice;

public class BinarySearch {
    public static void main(String[] args) {
        // grokking algo, page 26 - first binary search
        int[] array = new int[]{1, 3, 5, 7, 9};
        System.out.println(getPosition(array, 3));
        System.out.println(getPosition(array, -1));
    }

    private static Integer getPosition(int[] sortedArray, int number) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int middlePosition = (low + high) / 2;
            int middleNumber = sortedArray[middlePosition];

            if (number > middleNumber) {
                low = middlePosition + 1;
            } else if (number < middleNumber) {
                high = middlePosition - 1;
            } else {
                return middlePosition;
            }
        }

        return null;
    }
}
