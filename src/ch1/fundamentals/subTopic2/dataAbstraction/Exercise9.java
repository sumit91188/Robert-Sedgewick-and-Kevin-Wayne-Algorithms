package ch1.fundamentals.subTopic2.dataAbstraction;

import edu.princeton.cs.algs4.Counter;

import java.util.Arrays;

/**
 * @author Sumit Deo
 */
public class Exercise9 {

    public static void main(String[] args) {

        int[] integers = {1,2,3,4,5,6,7,8,9,10};
        int[] keys = {3,11,9};
        Arrays.sort(integers);

        for (int index = 0; index < integers.length; index++) {
            System.out.println(integers[index]);
        }

        Counter counter = new Counter("IterationCounter");

        System.out.print("Found keys: ");
        for (int i = 0; i < keys.length; i++) {
            if (rank(keys[i], integers, counter) != -1) {
                System.out.print(keys[i] + " ");
            }
        }
        System.out.println();
        System.out.println("Iterated over " + counter.tally() + " times.");
    }

    private static int rank(int key, int[] a, Counter counter) {

        int lowerBound = 0;
        int upperBound = a.length - 1;
        int mid;

        while (lowerBound <= upperBound) {
            counter.increment();
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
