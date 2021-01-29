package fundamentals.analysisOfAlgorithm;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/29/21
 * @comment: Farthest pair (in one dimension). Write a program that, given an array a[] of N double
 * values, finds a farthest pair : two values whose difference is no smaller than the the difference
 * of any other pair (in absolute value). The running time of your program should be linear in the
 * worst case.
 */
public class Exercise17 {

  public static void main(String[] args) {
    double[] array = {0, 2.9, 3, -5, -4, 6, 1, 9, 13, 15, -20};
    double[] farthestPair = findFarthestPair(array);

    System.out.println("Closest pair is: " + farthestPair[0] + ", " + farthestPair[1]);
  }

  private static double[] findFarthestPair(double[] array) {
    double[] pair = new double[2];
    double currentMin = array[0];
    double currentMax = array[0];

    pair[0] = currentMin;
    pair[1] = currentMax;

    for (int i = 1; i < array.length; i++) {
      if (array[i] < currentMin) {
        currentMin = array[i];
        pair[0] = currentMin;
      }

      if (array[i] > currentMax) {
        currentMax = array[i];
        pair[1] = currentMax;
      }
    }
    return pair;
  }
}
