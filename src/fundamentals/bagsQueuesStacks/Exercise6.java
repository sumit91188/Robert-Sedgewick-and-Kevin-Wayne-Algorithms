package fundamentals.bagsQueuesStacks;

import edu.princeton.cs.algs4.Queue;
import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/19/20
 * @comment: What does the following code fragment do to the queue q?
 */
public class Exercise6 {

  public static void main(String[] args) {
    Queue<String> q = new Queue<>();
    q.enqueue("a");
    q.enqueue("b");
    q.enqueue("c");
    q.enqueue("d");
    q.enqueue("e");
    q.enqueue("f");

    System.out.println("Queue: ");
    for (String i : q) {
      System.out.print(i + " ");
    }
    System.out.println();

    Stack<String> stack = new Stack<String>();
    while (!q.isEmpty()) {
      stack.push(q.dequeue());
    }

    System.out.println("Stack: ");
    for (String i : stack) {
      System.out.print(i + " ");
    }
    System.out.println();

    while (!stack.isEmpty()) {
      q.enqueue(stack.pop());
    }

    System.out.println("Queue: ");
    for (String i : q) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}

// Reverses the order of a queue.