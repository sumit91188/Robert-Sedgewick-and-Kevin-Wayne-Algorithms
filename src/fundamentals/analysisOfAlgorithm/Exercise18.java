package fundamentals.analysisOfAlgorithm;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/29/21
 * @comment: Local minimum of an array. Write a program that, given an array a[] of N distinct
 * integers, finds a local minimum: an index i such that a[i-1] < a[i] < a[i+1]. Your program should
 * use ~2lg N compares in the worst case.. Answer : Examine the middle value a[N/2] and its two
 * neighbors a[N/2 - 1] and a[N/2 + 1]. If a[N/2] is a local minimum, stop; otherwise search in the
 * half with the smaller neighbor.
 */
public class Exercise18 {

  public static void main(String[] args) {
    double[] array = {3.1, 2.9, 3, -5, -4, 6, 1, 9, 13, 15, -20, -21, -22};
    double[] array1 = {10, -9, 20, 25, 21, 40, 50, -20};
    double[] array2 = {-4, -3, 9, 4, 10, 2, 20};
    double[] array3 = {5, -3, -5, -6, -7, -8};
    double[] array4 = {5};
    double[] array5 = {10, 20};
    double[] array6 = {7, 20, 30};

    System.out.println("Local minimum is: " + findMinOfArray(array));
    System.out.println("Local minimum is: " + findMinOfArray(array1));
    System.out.println("Local minimum is: " + findMinOfArray(array2));
    System.out.println("Local minimum is: " + findMinOfArray(array3));
    System.out.println("Local minimum is: " + findMinOfArray(array4));
    System.out.println("Local minimum is: " + findMinOfArray(array5));
    System.out.println("Local minimum is: " + findMinOfArray(array6));
  }

  private static double findMinOfArray(double[] array) {
    int lowIndex = 0;
    int highIndex = array.length - 1;

    if (array.length == 0) {
      return -1;
    }

    if (array.length == 1) {
      return array[highIndex];
    }

    if (array.length == 2) {
      if (array[0] < array[1]) {
        return array[0];
      }
      return array[1];
    }

    while (lowIndex <= highIndex) {
      int midIndex = (lowIndex + highIndex) / 2;

      if (midIndex == 0) {
        if (array[midIndex] < array[midIndex + 1]) {
          return array[midIndex];
        } else {
          return -1;
        }
      }

      if (midIndex == array.length - 1) {
        if (array[midIndex] < array[midIndex - 1]) {
          return array[midIndex];
        } else {
          return -1;
        }
      }

      if ((array[midIndex] < array[midIndex - 1]) && (array[midIndex] < array[midIndex + 1])) {
        return array[midIndex];
      } else if (array[midIndex] > array[midIndex - 1]) {
        highIndex = midIndex - 1;
      } else if (array[midIndex] > array[midIndex + 1]) {
        lowIndex = midIndex + 1;
      }
    }

    return -1;
  }
}
