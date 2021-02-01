package fundamentals.analysisOfAlgorithm;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/31/21
 * @comment: Throwing eggs from a building. Suppose that you have an N-story building and plenty of
 * eggs. Suppose also that an egg is broken if it is thrown off floor F or higher, and unhurt
 * otherwise. First, devise a strategy to determine the value of F such that the number of broken
 * eggs is ~lg N when using ~lg N throws, then find a way to reduce the cost to ~2lg F.
 */
public class Exercise24 {

  public static void main(String[] args) {
    int[] floors = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1};
    System.out.println(findAFloor(floors));
  }

  private static int findAFloor(int[] floors) {
    return findAFloor(floors, 0, floors.length - 1);
  }

  private static int findAFloor(int[] floors, int lowIndex, int highIndex) {

    if (lowIndex >= highIndex) {
      return -1;
    }

    int midIndex = (lowIndex + highIndex) / 2;

    if (floors[midIndex] == 1) {
      int lowerFloor = findAFloor(floors, lowIndex, midIndex - 1);
      if (lowerFloor == -1) {
        return midIndex;
      } else {
        return lowerFloor;
      }
    } else {
      return findAFloor(floors, midIndex + 1, highIndex);
    }
  }
}
