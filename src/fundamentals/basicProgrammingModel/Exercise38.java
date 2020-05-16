package fundamentals.basicProgrammingModel;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sumit Deo
 */
public class Exercise38 {

    private static final String urlToLargeW = "https://algs4.cs.princeton.edu/11model/largeW.txt";
    private static final String urlToLargeT = "https://algs4.cs.princeton.edu/11model/largeT.txt";

    public static void main(String[] args) {

        int[] largeW = new int[1000000];
        int[] largeT = new int[10000000];
        int key = 760788;
        long startTime;
        long endTime;

        largeW = readFromTxtFile(urlToLargeW, largeW);
        Arrays.sort(largeW);

        System.out.println("Starting BruteForece Search in a file largeW.txt. Key to be searched is " + key);
        startTime = System.nanoTime();

        if (-1 != bruteForece(key, largeW)) {
            System.out.println(key + " found in largeW.txt file.");
        }
        else {
            System.out.println("Could not find " + key + " in largeW.txt file");
        }

        endTime = System.nanoTime();

        System.out.println((endTime - startTime) + " nano-seconds took by BruteForce algo.");

        System.out.println("Starting Binary Search in a file largeW.txt. Key to be searched is " + key);
        startTime = System.nanoTime();

        if (-1 != binarySearch(key, largeW)) {
            System.out.println(key + " found in largeW.txt file.");
        }
        else {
            System.out.println("Could not find " + key + " in largeW.txt file");
        }

        endTime = System.nanoTime();

        System.out.println((endTime - startTime) + " nano-seconds took by BinarySearch algo.");


        largeT = readFromTxtFile(urlToLargeT, largeT);
        Arrays.sort(largeT);

        System.out.println("Starting BruteForece Search in a file largeT.txt. Key to be searched is " + key);
        startTime = System.nanoTime();

        if (-1 != bruteForece(key, largeT)) {
            System.out.println(key + " found in largeT.txt file.");
        }
        else {
            System.out.println("Could not find " + key + " in largeT.txt file");
        }

        endTime = System.nanoTime();

        System.out.println((endTime - startTime) + " nano-seconds took by BruteForce algo.");

        System.out.println("Starting Binary Search in a file largeT.txt. Key to be searched is " + key);
        startTime = System.nanoTime();

        if (-1 != binarySearch(key, largeT)) {
            System.out.println(key + " found in largeW.txt file.");
        }
        else {
            System.out.println("Could not find " + key + " in largeT.txt file");
        }

        endTime = System.nanoTime();

        System.out.println((endTime - startTime) + " nano-seconds took by BinarySearch algo.");
    }


    private static int[] readFromTxtFile(String fileName, int[] array) {

        Scanner scanner = null;
        try {
            URL url = new URL(fileName);
            scanner = new Scanner(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        while (scanner.hasNextInt()) {
            array[i++] = scanner.nextInt();
        }

        return array;
    }

    private static int bruteForece(int key, int[] a) {

        for (int i = 0; i < a.length; i++) {
            if (key == a[i]) {
                return i;
            }
        }

        return -1;
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
