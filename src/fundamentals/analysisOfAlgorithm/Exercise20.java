package fundamentals.analysisOfAlgorithm;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/31/21
 * @comment: Bitonic search. An array is bitonic if it is comprised of an increasing sequence of
 * integers followed immediately by a decreasing sequence of integers. Write a program that, given a
 * bitonic array of N distinct int values, determines whether a given integer is in the array. Your
 * program should use ~3lg N compares in the worst case.
 */
public class Exercise20 {

  public static void main(String[] args) {
    int[] array1 = {1, 2, 3, 4, -1, -2, -3};
    int[] array2 = {1, 5, 4, 3, 2, 0};
    int[] array3 = {2, 4, 8, 16, 32, 1};
    int[] array4 = {2, 4, 8, 16, 32};
    int[] array5 = {2, 1};
    int[] array6 = {9};

    System.out.println(bitonicSearch(array1, -1));
    System.out.println(bitonicSearch(array2, 5));
    System.out.println(bitonicSearch(array3, 2));
    System.out.println(bitonicSearch(array3, 99));
    System.out.println(bitonicSearch(array4, 32));
    System.out.println(bitonicSearch(array5, 1));
    System.out.println(bitonicSearch(array6, 9));
    System.out.println(bitonicSearch(array6, 10));
  }

  private static int bitonicSearch(int[] array, int findElem) {

    if (array == null || array.length == 0) {
      return -1;
    }

    int trippingPoint = findTrippingPoint(array, 0, array.length - 1);
    int index = ascendingBinarySearch(array, 0, trippingPoint, findElem);
    if (index == -1) {
      index = descendingBinarySearch(array, trippingPoint + 1, array.length - 1, findElem);
    }

    return index;
  }

  private static int descendingBinarySearch(
      int[] array, int lowIndex, int highIndex, int findElem) {

    if (lowIndex > highIndex) {
      return -1;
    }

    int midIndex = (lowIndex + highIndex) / 2;

    if (findElem < array[midIndex]) {
      return descendingBinarySearch(array, midIndex + 1, highIndex, findElem);
    } else if (findElem > array[midIndex]) {
      return descendingBinarySearch(array, lowIndex, midIndex - 1, findElem);
    } else {
      return midIndex;
    }
  }

  private static int ascendingBinarySearch(int[] array, int lowIndex, int highIndex, int findElem) {
    if (lowIndex > highIndex) {
      return -1;
    }

    int midIndex = (lowIndex + highIndex) / 2;

    if (findElem < array[midIndex]) {
      return ascendingBinarySearch(array, lowIndex, midIndex - 1, findElem);
    } else if (findElem > array[midIndex]) {
      return ascendingBinarySearch(array, midIndex + 1, highIndex, findElem);
    } else {
      return midIndex;
    }
  }

  private static int findTrippingPoint(int[] array, int lowIndex, int highIndex) {
    if (lowIndex == highIndex) {
      return highIndex;
    }

    int midIndex = (lowIndex + highIndex) / 2;

    if (midIndex == 0) {
      if (array[midIndex] < array[midIndex + 1]) {
        return midIndex + 1;
      } else {
        return midIndex;
      }
    }

    if ((array[midIndex] < array[midIndex - 1]) && (array[midIndex] > array[midIndex + 1])) {
      return findTrippingPoint(array, lowIndex, midIndex - 1);
    } else if ((array[midIndex] > array[midIndex - 1]) && (array[midIndex] < array[midIndex + 1])) {
      return findTrippingPoint(array, midIndex + 1, highIndex);
    } else {
      return midIndex;
    }
  }
}
