package fundamentals.analysisOfAlgorithm;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/31/21
 * @comment: Binary search on distinct values. Develop an implementation of binary search for
 * StaticSETofInts (see page 98) where the running time of contains() is guaranteed to be ~ lg R,
 * where R is the number of different integers in the array given as argument to the constructor
 */
public class Exercise21 {

  public static void main(String[] args) {
    int[] array = {60, 50, 20, 30, 10, 40, 20, 80, 90, 70, 80};

    StaticSETofInts seTofInts = new StaticSETofInts(array);
    System.out.println(seTofInts.contains(10));
    System.out.println(seTofInts.contains(20));
    System.out.println(seTofInts.contains(100));
    System.out.println(seTofInts.contains(0));
  }

  private static class StaticSETofInts {

    private final HashSet<Integer> integerHashSet;
    private final int[] array;

    public StaticSETofInts(int[] inputArray) {
      integerHashSet = new HashSet<>();

      for (int i : inputArray) {
        integerHashSet.add(i);
      }

      array = new int[integerHashSet.size()];
      int arrayIndex = 0;

      for (int i : integerHashSet) {
        array[arrayIndex++] = i;
      }

      Arrays.sort(array);
    }

    public boolean contains(int key) {
      int rank = getRank(key);
      return rank != -1;
    }

    public int getRank(int key) {
      return getRank(key, 0, array.length - 1);
    }

    private int getRank(int key, int lowIndex, int highIndex) {
      if (lowIndex > highIndex) {
        return -1;
      }

      int midIndex = (lowIndex + highIndex) / 2;

      if (key < array[midIndex]) {
        return getRank(key, lowIndex, midIndex - 1);
      } else if (key > array[midIndex]) {
        return getRank(key, midIndex + 1, highIndex);
      } else {
        return midIndex;
      }
    }
  }
}
