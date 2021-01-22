package fundamentals.analysisOfAlgorithm;

import edu.princeton.cs.algs4.StdOut;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/20/21
 * @comment: Faster 3-sum. As a warmup, develop an implementation TwoSumFaster that uses a linear
 * algorithm to count the pairs that sum to zero after the array is sorted (instead of the
 * binary-search-based linearithmic algorithm). Then apply a similar idea to develop a quadratic
 * algorithm for the 3-sum problem.
 */
public class Exercise15TwoSumFaster {

  public static void main(String[] args) {
    int[] array = {-10, -10, -5, 0, 5, 10, 10, 15, 20};
    int[] arrayTest1 = {-3, -2, 2, 3, 5, 99};
    int[] arrayTest2 = {-10, -10, -10, 10, 10};
    int[] arrayTest3 = {0, 0, 0, 0, 0};
    int[] arrayTest4 = {-2, -1, 0, 0, 0, 0, 0, 0, 1};

    StdOut.println("TwoSumFaster: " + twoSumFaster(array) + " Expected: 5");
    StdOut.println("TwoSumFaster: " + twoSumFaster(arrayTest1) + " Expected: 2");
    StdOut.println("TwoSumFaster: " + twoSumFaster(arrayTest2) + " Expected: 6");
    StdOut.println("TwoSumFaster: " + twoSumFaster(arrayTest3) + " Expected: 10");
    StdOut.println("TwoSumFaster: " + twoSumFaster(arrayTest4) + " Expected: 16");

    StdOut.println("TwoSumFaster2: " + twoSumFaster2(array) + " Expected: 5");
    StdOut.println("TwoSumFaster2: " + twoSumFaster2(arrayTest1) + " Expected: 2");
    StdOut.println("TwoSumFaster2: " + twoSumFaster2(arrayTest2) + " Expected: 6");
    StdOut.println("TwoSumFaster2: " + twoSumFaster2(arrayTest3) + " Expected: 10");
    StdOut.println("TwoSumFaster2: " + twoSumFaster2(arrayTest4) + " Expected: 16");
  }

  private static int twoSumFaster(int[] array) {
    Map<Integer, Integer> elementMap = new HashMap<>();

    for (int key : array) {
      int frequency;

      frequency = elementMap.getOrDefault(key, 0);
      elementMap.put(key, frequency + 1);
    }

    int count = 0;

    for (int key : array) {
      if (elementMap.containsKey(-key)) {
        count += elementMap.get(-key);

        if (key == 0) {
          count--;
        }
      }
    }
    return count / 2;
  }

  private static int twoSumFaster2(int[] array) {
    int start = 0;
    int end = array.length - 1;

    int count = 0;

    for (int i : array) {
      if (i == 0) {
        count++;
      }
    }

    count = (count * (count - 1)) / 2;

    if ((array[start] > 0 && array[end] > 0) || (array[start] < 0 && array[end] < 0)) {
      return 0;
    }

    while (start < end) {
      if (array[start] + array[end] > 0) {
        end--;
      } else if (array[start] + array[end] < 0) {
        start++;
      } else {
        if (array[start] == 0 && array[end] == 0) {
          start++;
          end--;
          continue;
        }

        int startElem = array[start];
        int equalStartElem = 1;

        while (start + 1 < end && array[start + 1] == startElem) {
          equalStartElem++;
          start++;
        }

        int endElem = array[end];
        int equalEndElem = 1;

        while (end - 1 > start && array[end - 1] == endElem) {
          equalEndElem++;
          end--;
        }

        count += equalEndElem * equalStartElem;
        start++;
        end--;
      }
    }
    return count;
  }
}
