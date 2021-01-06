package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.ArrayQueue;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/6/21
 * @comment: Josephus problem. In the Josephus problem from antiquity, N people are in dire straits
 * and agree to the following strategy to reduce the population. They arrange themselves in a circle
 * (at positions numbered from 0 to N–1) and proceed around the circle, eliminating every Mth person
 * until only one person is left. Legend has it that Josephus figured out where to sit to avoid
 * being eliminated. Write a Queue client Josephus that takes N and M from the command line and
 * prints out the order in which people are eliminated (and thus would show Josephus where to sit in
 * the circle). % java Josephus 7 2 :- 1 3 5 0 4 2 6
 */
public class Exercise37 {

  public static void main(String[] args) {

    int n = 7;
    int m = 2;

    System.out.print("Order in which people will be eliminated: ");
    josephusLogic(n, m);
  }

  private static void josephusLogic(int n, int m) {
    ArrayQueue<Integer> queue = new ArrayQueue<>();

    for (int i = 0; i < n; i++) {
      queue.offer(i);
    }

    while (n > 0) {
      for (int i = 1; i < m; i++) {
        queue.offer(queue.poll());
      }
      System.out.print(queue.poll() + " ");
      n--;
    }
  }
}
