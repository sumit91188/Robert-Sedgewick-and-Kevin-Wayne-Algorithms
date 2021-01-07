package fundamentals.bagsQueuesStacks;

import java.util.Arrays;
import java.util.Iterator;

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
public class Exercise38_array {

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

    T[] array;
    int numOfElms;
    int maxNumOfElms;

    public GeneralizedQueue() {
      this.maxNumOfElms = 5;
      array = (T[]) new Object[this.maxNumOfElms];
    }

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public void insert(T elem) {
      if (numOfElms == maxNumOfElms) {
        increaseCapacity();
      }
      array[numOfElms++] = elem;
    }

    private void increaseCapacity() {
      maxNumOfElms *= 2;
      array = Arrays.copyOf(array, maxNumOfElms);
    }

    public T delete(int k) {
      if (isEmpty() || k > numOfElms) {
        throw new RuntimeException();
      }

      T elem = array[numOfElms - k];
      for (int i = numOfElms - k; i < numOfElms - 1; i++) {
        array[i] = array[i + 1];
      }
      numOfElms--;
      return elem;
    }

    @Override
    public Iterator<T> iterator() {
      return new Iterator<T>() {

        int iteratorIndex;

        @Override
        public boolean hasNext() {
          return iteratorIndex < numOfElms;
        }

        @Override
        public T next() {
          T elem = null;
          if (hasNext()) {
            elem = array[iteratorIndex++];
          }
          return elem;
        }
      };
    }
  }
}
