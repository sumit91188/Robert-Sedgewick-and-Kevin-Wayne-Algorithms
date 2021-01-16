package fundamentals.analysisOfAlgorithm;

import java.util.Arrays;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/16/21
 * @comment:
 */
public class Exercise8 {

  public static void main(String[] args) {
    int[] values1 = {1, 2, 4, 1, 2, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 5, 6, 7, 7, 8, 2, 1, 2, 4, 5};
    System.out.println("Equal pairs 1: " + countNumberOfPairs_quadratic(values1) + " Expected: 49");
    System.out
        .println("Equal pairs 1: " + countNumberOfPairs_linearithmic(values1) + " Expected: 49");

    int[] values2 = {1, 1, 1};
    System.out.println("Equal pairs 2: " + countNumberOfPairs_quadratic(values2) + " Expected: 3");
    System.out
        .println("Equal pairs 2: " + countNumberOfPairs_linearithmic(values2) + " Expected: 3");
  }

  private static int countNumberOfPairs_quadratic(int[] values) {
    int count = 0;
    for (int i = 0; i < values.length; i++) {
      for (int j = i + 1; j < values.length; j++) {
        if (values[i] == values[j]) {
          count++;
        }
      }
    }
    return count;
  }

  private static int countNumberOfPairs_linearithmic(int[] values) {
    Arrays.sort(values);
    int count = 0;
    for (int i = 1; i < values.length; i++) {
      if (values[i] == values[i - 1]) {
        count++;
      }
    }
    return count;
  }
}
