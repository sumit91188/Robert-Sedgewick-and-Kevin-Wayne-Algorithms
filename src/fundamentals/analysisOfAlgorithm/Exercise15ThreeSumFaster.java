package fundamentals.analysisOfAlgorithm;

import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/22/21
 * @comment:
 */
public class Exercise15ThreeSumFaster {

  public static void main(String[] args) {
    int[] array = {-10, -10, -5, 0, 5, 10, 10, 15, 20};
    int[] arrayTest1 = {-3, -2, 2, 3, 5, 99};
    int[] arrayTest2 = {-10, -10, -10, 10};
    int[] arrayTest3 = {0, 0, 0, 0, 0, 0, 0};
    int[] arrayTest4 = {-2, -1, 0, 0, 0, 0, 0, 0, 3};

    StdOut.println("Method 1");
    StdOut.println("ThreeSumFaster: " + threeSumFaster(array) + " Expected: 8");
    StdOut.println("ThreeSumFaster: " + threeSumFaster(arrayTest1) + " Expected: 1");
    StdOut.println("ThreeSumFaster: " + threeSumFaster(arrayTest2) + " Expected: 0");
    StdOut.println("ThreeSumFaster: " + threeSumFaster(arrayTest3) + " Expected: 35");
    StdOut.println("ThreeSumFaster: " + threeSumFaster(arrayTest4) + " Expected: 21");

    StdOut.println("\nMethod 2");
    StdOut.println("ThreeSumFaster: " + threeSumFaster2(array) + " Expected: 8");
    StdOut.println("ThreeSumFaster: " + threeSumFaster2(arrayTest1) + " Expected: 1");
    StdOut.println("ThreeSumFaster: " + threeSumFaster2(arrayTest2) + " Expected: 0");
    StdOut.println("ThreeSumFaster: " + threeSumFaster2(arrayTest3) + " Expected: 35");
    StdOut.println("ThreeSumFaster: " + threeSumFaster2(arrayTest4) + " Expected: 21");
  }

  private static int threeSumFaster2(int[] array) {
    int start = 0;
    int end = array.length - 1;

    int count = 0;

    for (int i : array) {
      if (i == 0) {
        count++;
      }
    }

    count = (count * (count - 1) * (count - 2)) / 6;
    return count;
  }

  private static int threeSumFaster(int[] array) {
    Map<Integer, List<Integer>> elementIndexes = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
      if (!elementIndexes.containsKey(array[i])) {
        elementIndexes.put(array[i], new ArrayList<>());
      }

      elementIndexes.get(array[i]).add(i);
    }

    int count = 0;

    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        int sum = array[i] + array[j];

        if (elementIndexes.containsKey(-sum)) {
          for (int elemIndex : elementIndexes.get(-sum)) {
            if (elemIndex > j) {
              count++;
            }
          }
        }
      }
    }
    return count;
  }
}
