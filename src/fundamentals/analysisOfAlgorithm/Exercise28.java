package fundamentals.analysisOfAlgorithm;

import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 2/1/21
 * @comment: Stack with a queue. Implement a stack with a single queue so that each stack operations
 * takes a linear number of queue operations. Hint : To delete an item, get all of the elements on
 * the queue one at a time, and put them at the end, except for the last one which you should delete
 * and return. (This solution is admittedly very inefficient.)
 */
public class Exercise28 {

  public static void main(String[] args) {
    StackWithQueue<Integer> stack = new StackWithQueue();

    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);

    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  private static class StackWithQueue<T> implements Iterable<T> {

    Queue<T> queue;

    public StackWithQueue() {
      queue = new Queue<>();
    }

    public int size() {
      return queue.size();
    }

    public boolean isEmpty() {
      return queue.isEmpty();
    }

    public void push(T data) {
      queue.enqueue(data);
    }

    public T pop() {
      if (queue.isEmpty()) {
        throw new RuntimeException();
      }

      int currentSize = size();

      for (int i = 0; i < currentSize - 1; i++) {
        queue.enqueue(queue.dequeue());
      }

      return queue.dequeue();
    }

    @Override
    public Iterator<T> iterator() {
      return null;
    }
  }
}
