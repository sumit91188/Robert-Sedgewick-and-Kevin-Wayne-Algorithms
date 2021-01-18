package fundamentals.analysisOfAlgorithm;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/17/21
 * @comment: 4-sum. Develop an algorithm for the 4-sum problem.
 */
public class Exercise14 {

  public static void main(String[] args) {
    // Method 1
    StdOut.println("Method 1");
    int[] array1 = {5, 2, -2, -5, -2};
    StdOut.println("4 sum: " + fourSum(array1));
    StdOut.println("Expected: 2");

    int[] array2 = {1, 2, 3, 4, -4, -5, -6, 2, 4, -1};
    StdOut.println("4 sum: " + fourSum(array2));
    StdOut.println("Expected: 13");

    // Method 2
    StdOut.println("\nMethod 2");
    StdOut.println("4 sum: " + fourSumFast(array1));
    StdOut.println("Expected: 2");

    StdOut.println("4 sum: " + fourSumFast(array2));
    StdOut.println("Expected: 13");
  }

  private static int fourSum(int[] array) {
    int numOfElms = array.length;
    int count = 0;
    for (int i = 0; i < numOfElms; i++) {
      for (int j = i + 1; j < numOfElms; j++) {
        for (int k = j + 1; k < numOfElms; k++) {
          for (int l = k + 1; l < numOfElms; l++) {
            if (array[i] + array[j] + array[k] + array[l] == 0) {
              count++;
            }
          }
        }
      }
    }
    return count;
  }

  private static int fourSumFast(int[] array) {
    Arrays.sort(array);
    int numOfElms = array.length;
    int count = 0;
    for (int i = 0; i < numOfElms; i++) {
      for (int j = i + 1; j < numOfElms; j++) {
        for (int k = j + 1; k < numOfElms; k++) {
          if (BinarySearch.rank(-(array[i] + array[j] + array[k]), array) > k) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
