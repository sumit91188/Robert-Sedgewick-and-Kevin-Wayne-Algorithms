package fundamentals.analysisOfAlgorithm;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/16/21
 * @comment:
 */
public class Exercise10 {

  public static void main(String[] args) {
    int[] testArray1 = {3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21};
    int elementToSearch1 = 4;
    int elementToSearch2 = 20;
    int elementToSearch3 = -5;

    StdOut.println("Binary search: " + binarySearch(testArray1, elementToSearch1) +
        " Expected: 1");
    StdOut.println("Binary search: " + binarySearch(testArray1, elementToSearch2) +
        " Expected: 7");
    StdOut.println("Binary search: " + binarySearch(testArray1, elementToSearch3) +
        " Expected: -1");

    int[] testArray2 = {4, 4, 4, 4, 4, 4, 15, 20, 20, 20, 20, 21};
    int elementToSearch4 = 4;

    StdOut.println("Binary search: " + binarySearch(testArray2, elementToSearch4) +
        " Expected: 0");
  }

  private static int binarySearch(int[] ints, int element) {
    return binarySearch(ints, element, 0, ints.length);
  }

  private static int binarySearch(int[] ints, int element, int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      return -1;
    }

    int minIndex = (startIndex + endIndex) / 2;

    if (ints[minIndex] == element) {
      int smallestIndex = binarySearch(ints, element, startIndex, minIndex - 1);
      if (smallestIndex == -1) {
        return minIndex;
      } else {
        return smallestIndex;
      }
    } else if (ints[minIndex] > element) {
      return binarySearch(ints, element, startIndex, minIndex - 1);
    } else {
      return binarySearch(ints, element, minIndex + 1, endIndex);
    }
  }
}
