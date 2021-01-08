package fundamentals.bagsQueuesStacks;

import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/8/21
 * @comment: Stack generability. Suppose that we have a sequence of intermixed push and pop
 * operations as with our test stack client, where the integers 0, 1, ..., N-1 in that order (push
 * directives) are intermixed with N minus signs (pop directives). Devise an algorithm that
 * determines whether the intermixed sequence causes the stack to underflow. (You may use only an
 * amount of space independent of N—you cannot store the integers in a data structure.) Devise a
 * linear-time algorithm that determines whether a given permutation can be generated as output by
 * our test client (depending on where the pop directives occur).
 */
public class Exercise45 {

  public static void main(String[] args) {
    System.out.println(willUnderFlow("0 1 2 - - -".split("\\s")));
    System.out.println(willUnderFlow("0 1 2 - - - 3 4 5 - - 6 - - -".split("\\s")));
    System.out.println(willUnderFlow("0 - - 1 2 -".split("\\s")));

    System.out.println(possiblePermutation("4 3 2 1 0 9 8 7 6 5".split("\\s")));
    System.out.println(possiblePermutation("4 6 8 7 5 3 2 9 0 1".split("\\s")));
    System.out.println(possiblePermutation("2 5 6 7 4 8 9 3 1 0".split("\\s")));
    System.out.println(possiblePermutation("4 3 2 1 0 5 6 7 8 9".split("\\s")));
    System.out.println(possiblePermutation("1 2 3 4 5 6 9 8 7 0".split("\\s")));
    System.out.println(possiblePermutation("0 4 6 5 3 8 1 7 2 9".split("\\s")));
    System.out.println(possiblePermutation("1 4 7 9 8 6 5 3 0 2".split("\\s")));
    System.out.println(possiblePermutation("2 1 4 3 6 5 8 7 9 0".split("\\s")));
    System.out.println(possiblePermutation("4 3 2 1 0 5 9 7 8 6".split("\\s")));
  }

  private static boolean possiblePermutation(String[] chars) {
    Stack<Integer> stack = new Stack<>();
    int currentElem = 0;

    for (String ch : chars) {
      int newElem = Integer.parseInt(ch);

      if (stack.isEmpty() || newElem > stack.peek()) {
        while (currentElem < newElem) {
          stack.push(currentElem++);
        }
        currentElem++;
      } else if (newElem == stack.peek()) {
        stack.pop();
      } else {
        return false;
      }
    }

    return true;
  }

  private static boolean willUnderFlow(String[] chars) {
    int count = 0;

    for (String ch : chars) {
      if (ch.equals("-")) {
        count--;
      } else {
        count++;
      }

      if (count < 0) {
        return true;
      }
    }

    return false;
  }
}
