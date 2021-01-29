package fundamentals.analysisOfAlgorithm;

import java.util.Arrays;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/29/21
 * @comment: Closest pair (in one dimension). Write a program that, given an array a[] of N double
 * values, finds a closest pair : two values whose difference is no greater than the the difference
 * of any other pair (in absolute value). The running time of your program should be linearithmic in
 * the worst case.
 */
public class Exercise16 {

  public static void main(String[] args) {
    double[] array = {0, 2.9, 3, -5, -4, 6, 1, 9, 13, 15, -20};
    double[] closestPair = findClosestPair(array);

    System.out.println("Closest pair is: " + closestPair[0] + ", " + closestPair[1]);
  }

  private static double[] findClosestPair(double[] array) {
    double[] pair = new double[2];
    Arrays.sort(array);
    double absDiff = Integer.MAX_VALUE;
    for (int i = 1; i < array.length; i++) {
      double currentDiff = Math.abs(array[i] - array[i - 1]);
      if (currentDiff < absDiff) {
        pair[0] = array[i - 1];
        pair[1] = array[i];
        absDiff = currentDiff;
      }
    }
    return pair;
  }
}
