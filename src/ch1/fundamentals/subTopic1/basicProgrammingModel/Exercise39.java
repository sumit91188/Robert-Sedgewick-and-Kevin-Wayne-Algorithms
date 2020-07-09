package ch1.fundamentals.subTopic1.basicProgrammingModel;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * @author Sumit Deo
 */
public class Exercise39 {

    public static void main(String[] args) {

        int t = 10; //default
        int n3 = (int) Math.pow(10, 3);
        int n4 = (int) Math.pow(10, 4);
        int n5 = (int) Math.pow(10, 5);
        int n6 = (int) Math.pow(10, 6);
        int[] results = new int[4];

        try {
            t = Integer.parseInt(args[0].trim());
        }
        catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: Input needs to be integer.");
            nfe.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Needs 1 int input");
            arrayIndexOutOfBoundsException.printStackTrace();
        }

        for (int i = 0; i < t; i++) {

            results[0] += runBinarySearch(n3);
            results[1] += runBinarySearch(n4);
            results[2] += runBinarySearch(n5);
            results[3] += runBinarySearch(n6);
        }

        System.out.println("Value of N\\ttAverage");
        System.out.format("10^3\t\t\t%.2f\n", (double)results[0]/t);
        System.out.format("10^4\t\t\t%.2f\n", (double)results[1]/t);
        System.out.format("10^5\t\t\t%.2f\n", (double)results[2]/t);
        System.out.format("10^6\t\t\t%.2f\n", (double)results[3]/t);
    }

    private static int runBinarySearch(int nElem) {

        int[] array1 = new int[nElem];
        int[] array2 = new int[nElem];

        for (int i = 0; i < nElem; i++) {
            array1[i] = StdRandom.uniform(99999, 1000000);
            array2[i] = StdRandom.uniform(99999, 1000000);
        }

        Arrays.sort(array1);
        Arrays.sort(array2);

        int numOfIntersection = 0;

        for (int i = 0; i < nElem; i++) {

            boolean foundInFirstArray = false;
            boolean foundInSecondArray = false;

            if (binarySearch(i , array1) != -1) {
                foundInFirstArray = true;
            }
            if (binarySearch(i , array2) != -1) {
                foundInSecondArray = true;
            }

            if (foundInFirstArray && foundInSecondArray) {
                numOfIntersection++;
            }
        }

        return numOfIntersection;
    }

    private static int binarySearch(int key, int[] a) {

        int lowerBound = 0;
        int upperBound = a.length - 1;
        int mid;

        while (lowerBound < upperBound) {
            mid = (lowerBound + upperBound) / 2;
            if (key < a[mid]) {
                upperBound = mid - 1;
            } else if (key > a[mid]) {
                lowerBound = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
