package fundamentals.basicProgrammingModel;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sumit Deo
 */
public class Exercise22 {

    public static void main(String[] args) {

        int[] integers = {1,2,3,4,5,6,7,8,9,10};
        Arrays.sort(integers);

        for (int index = 0; index < integers.length; index++) {
            System.out.println(integers[index]);
        }

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int key = in.nextInt();
            if (rank(key, integers) < 0) {
                System.out.println(key);
            }
        }
    }

    private static int rank(int key, int[] a) {

        int lowerBound = 0;
        int upperBound = a.length - 1;
        int mid;
        int depth = 0;

        while (lowerBound <= upperBound) {
            int indentation = depth;
            while (indentation > 0) {
                System.out.print(" ");
                indentation--;
            }
            System.out.println("Lo: " + lowerBound + " - hi: " + upperBound);
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
            depth++;
        }

        return -1;
    }
}
