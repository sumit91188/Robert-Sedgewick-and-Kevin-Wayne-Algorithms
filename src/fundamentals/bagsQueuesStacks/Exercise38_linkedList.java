package fundamentals.bagsQueuesStacks;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/6/21
 * @comment: First, develop an implementation that uses an array implementation, and then develop
 * one that uses a linked-list implementation. Note : the algorithms and data structures that we
 * introduce in Chapter 3 make it possible to develop an implementation that can guarantee that both
 * insert() and delete() take time prortional to the logarithm of the number of items in the
 * queue—see Exercise 3.5.27.
 */
public class Exercise38_linkedList {

  public static void main(String[] args) {
    GeneralizedQueue<Integer> queue = new GeneralizedQueue<>();

    queue.insert(10);
    queue.insert(20);
    queue.insert(30);
    queue.insert(40);
    queue.insert(50);
    queue.insert(60);
    queue.insert(70);

    System.out.print("Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Delete and return the 2nd least recently inserted item " + queue.delete(2));

    System.out.print("Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Delete and return the 3rd least recently inserted item " + queue.delete(3));
  }

  private static class GeneralizedQueue<T> implements Iterable<T> {

    private final LinkedList<T> list;

    public GeneralizedQueue() {
      list = new LinkedList<>();
    }

    public boolean isEmpty() {
      return list.isEmpty();
    }

    public void insert(T elem) {
      list.add(elem);
    }

    public T delete(int k) {
      if (isEmpty() || list.size() < k) {
        throw new RuntimeException();
      }
      return list.remove(list.size() - k);
    }

    @Override
    public Iterator<T> iterator() {
      return list.iterator();
    }
  }
}
