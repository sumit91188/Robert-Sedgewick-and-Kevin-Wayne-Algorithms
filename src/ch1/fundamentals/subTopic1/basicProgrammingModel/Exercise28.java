package ch1.fundamentals.subTopic1.basicProgrammingModel;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sumit Deo
 */
public class Exercise28 {

    public static void main(String[] args) {

        int[] integers = {1,2,3,4,5,6,3,4,5,1,2,5,7,8,9,10};
        Arrays.sort(integers);

        System.out.println("Array with duplicates.");
        for (int index = 0; index < integers.length; index++) {
            System.out.println(integers[index]);
        }

        int[] intWithoutDups = removeDuplicates(integers);
        System.out.println("Array without duplicates.");
        for (int index = 0; index < intWithoutDups.length; index++) {
            System.out.println(intWithoutDups[index]);
        }

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int key = in.nextInt();
            if (rank(key, intWithoutDups) < 0) {
                System.out.println(key);
            }
        }
    }

    private static int[] removeDuplicates(int[] ints) {
        int dups = 0;
        int len = ints.length;
        for (int i = 1; i < ints.length; i++) {
            while (ints[i] == ints[i - 1]) {
                dups++;
                i++;
                len--;
            }
            ints[i - dups] = ints[i];
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = ints[i];
        }
        return result;
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
