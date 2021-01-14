package fundamentals.analysisOfAlgorithm;

import java.math.BigInteger;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/14/21
 * @comment: Modify ThreeSum to work properly even when the int values are so large that adding two
 * of them might cause overflo
 */
public class Exercise2 {

  public static void main(String[] args) {
    int[] numbers = {10, -20, 30, -1234567899, 123456789, 987654321};
    System.out.println("Number of three-sums are: " + getNumOf3Sums(numbers));
  }

  private static int getNumOf3Sums(int[] numbers) {
    int length = numbers.length;
    int count = 0;

    BigInteger bigInteger;

    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        for (int k = j + 1; k < length; k++) {
          bigInteger = BigInteger.valueOf(numbers[i]);
          bigInteger = bigInteger.add(BigInteger.valueOf(numbers[j]));
          bigInteger = bigInteger.add(BigInteger.valueOf(numbers[k]));

          if (bigInteger.intValue() == 0) {
            count++;
          }
        }
      }
    }
    return count;
  }
}
