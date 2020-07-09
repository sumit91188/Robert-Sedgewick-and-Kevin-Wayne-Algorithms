package ch1.fundamentals.subTopic1.basicProgrammingModel;

import java.util.Arrays;

/**
 * @author Sumit Deo
 */
public class Exercise23 {

    public static void main(String[] args) {

        int[] integers = {1,2,3,4,5,6,7,8,9,10};
        int[] numbers = {1, 4 , 5, 9, 12, 13};
        Arrays.sort(integers);

        for (int index = 0; index < integers.length; index++) {
            System.out.println(integers[index]);
        }

        String foundItems = "";
        String notFoundItems = "";

        for (int i = 0; i < numbers.length; i++) {
            if (rank(numbers[i], integers) < 0) {
                notFoundItems = notFoundItems + numbers[i] + ", ";
            }
            else {
                foundItems = foundItems + numbers[i] + ", ";
            }
        }

        System.out.println(notFoundItems + " is/are not in the WHITELIST.");
        System.out.println(foundItems + " is/are in the WHITELIST.");
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
