package fundamentals.analysisOfAlgorithm;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 2/1/21
 * @comment: Queue with two stacks. Implement a queue with two stacks so that each queue operation
 * takes a constant amortized number of stack operations. Hint : If you push elements onto a stack
 * and then pop them all, they appear in reverse order. If you repeat this process, they’re now back
 * in order.
 */
public class Exercise27 {

  public static void main(String[] args) {
    QueueWithStacks<Integer> queue = new QueueWithStacks();

    queue.enQueue(10);
    queue.enQueue(20);
    queue.enQueue(30);
    queue.enQueue(40);
    queue.enQueue(50);
    queue.enQueue(60);

    System.out.println(queue.deQueue());
    System.out.println("Queue: ");

    for (int i : queue) {
      System.out.print(i + " ");
    }
  }

  private static class QueueWithStacks<T> implements Iterable<T> {

    Stack<T> headStack;
    Stack<T> tailStack;

    public QueueWithStacks() {
      headStack = new Stack<>();
      tailStack = new Stack<>();
    }

    public int size() {
      return headStack.size() + tailStack.size();
    }

    public boolean isEmpty() {
      return headStack.isEmpty() && tailStack.isEmpty();
    }

    public void enQueue(T data) {
      tailStack.push(data);
    }

    public T deQueue() {
      if (headStack.isEmpty()) {
        copyFromFailToHead();
      }
      return headStack.pop();
    }

    private void copyFromFailToHead() {
      while (!tailStack.isEmpty()) {
        headStack.push(tailStack.pop());
      }
    }

    @Override
    public Iterator<T> iterator() {
      return new QueueIterator<T>();
    }

    private class QueueIterator<T> implements Iterator<T> {

      Iterator iterator;

      public QueueIterator() {
        copyFromFailToHead();
        iterator = headStack.iterator();
      }

      @Override
      public boolean hasNext() {
        return iterator.hasNext();
      }

      @Override
      public T next() {
        return (T) iterator.next();
      }
    }
  }
}
