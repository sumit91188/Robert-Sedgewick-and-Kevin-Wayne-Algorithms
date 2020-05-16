package fundamentals.basicProgrammingModel;

import java.util.Arrays;

/**
 * @author Sumit Deo
 */
public class Exercise29 {

    public static void main(String[] args) {

        int[] integers = {1,2,3,4,5,6,3,4,5,1,2,5,7,8,9,10};
        Arrays.sort(integers);

        for (int index = 0; index < integers.length; index++) {
            System.out.println(integers[index]);
        }

        int key = 5;
        System.out.println(rank(key, integers) - 1 + " elements are lower than " + key + ".");

        System.out.println(count(key, integers) + " elements are equal to " + key + ".");
    }

    private static int count(int key, int[] integers) {
        int rank = rank(key, integers);
        int index = rank - 1;
        int count = 0;
        if (rank != -1) {
            count++;
            while (integers[index] == integers[index + 1]) {
                count++;
                index++;
            }
        }
        return count;
    }

    private static int rank(int key, int[] a) {

        int lowerBound = 0;
        int upperBound = a.length - 1;
        int mid;

        while (lowerBound <= upperBound) {
            mid = (lowerBound + upperBound) / 2;
            if (key < a[mid]) {
                upperBound = mid - 1;
            }
            else if (key > a[mid]) {
                lowerBound = mid + 1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }
}
