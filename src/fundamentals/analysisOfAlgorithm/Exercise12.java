package fundamentals.analysisOfAlgorithm;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/17/21
 * @comment: Write a program that, given two sorted arrays of N int values, prints all elements that
 * appear in both arrays, in sorted order. The running time of your program should be proportional
 * to N in the worst case.
 */
public class Exercise12 {

  public static void main(String[] args) {
    int[] array1 = {0, 1, 2, 2, 5, 6, 6, 8, 25, 25};
    int[] array2 = {-2, 0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25, 25};

    System.out.println("Elements: ");
    printElementsThatAppearInBothArrays(array1, array2);
    System.out.println("\nExpected: 0 1 2 5 25");
  }

  private static void printElementsThatAppearInBothArrays(int[] array1, int[] array2) {
    int array1Index = 0;
    int array2Index = 0;
    Integer recentMatchedValue = null;

    while (array1Index < array1.length && array2Index < array2.length) {
      if (array1[array1Index] < array2[array2Index]) {
        array1Index++;
      } else if (array1[array1Index] > array2[array2Index]) {
        array2Index++;
      } else {
        if (recentMatchedValue == null || recentMatchedValue != array1[array1Index]) {
          System.out.print(array1[array1Index] + " ");
          recentMatchedValue = array1[array1Index];
        }

        array1Index++;
        array2Index++;
      }
    }
  }
}
