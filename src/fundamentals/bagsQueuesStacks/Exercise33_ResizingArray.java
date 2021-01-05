package fundamentals.bagsQueuesStacks;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/5/21
 * @comment: Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or a queue but
 * supports adding and removing items at both ends. A deque stores a collection of items and
 * supports the following API. Write a class Deque that uses a class ResizingArrayDeque that uses a
 * resizing array.
 */
public class Exercise33_ResizingArray {

  public static void main(String[] args) {
    ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();

    deque.pushLeft(10);
    deque.pushLeft(20);
    deque.pushRight(30);
    deque.pushRight(40);
    deque.pushLeft(50);
    deque.pushLeft(60);
    deque.pushRight(70);

    System.out.print("Deque- ");
    for (int i : deque) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Remove left: " + deque.popLeft());
    System.out.println("Remove right: " + deque.popRight());

    System.out.print("Deque- ");
    for (int i : deque) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class ResizingArrayDeque<T> implements Iterable<T> {

    T[] array;
    int numOfElms;
    int maxNumOfElms;

    public ResizingArrayDeque() {
      this.maxNumOfElms = 5;
      array = (T[]) new Object[maxNumOfElms];
    }

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void pushLeft(T elem) {
      if (numOfElms == maxNumOfElms) {
        increaseCapacity();
      }

      for (int i = numOfElms; i > 0; i--) {
        array[i] = array[i - 1];
      }
      array[0] = elem;
      numOfElms++;
    }

    private void increaseCapacity() {
      maxNumOfElms *= 2;
      array = Arrays.copyOf(array, maxNumOfElms);
    }

    public void pushRight(T elem) {
      if (numOfElms == maxNumOfElms) {
        increaseCapacity();
      }
      array[numOfElms++] = elem;
    }

    public T popLeft() {
      if (isEmpty()) {
        throw new RuntimeException();
      }

      T elem = array[0];
      for (int i = 1; i < numOfElms; i++) {
        array[i - 1] = array[i];
      }
      array[numOfElms - 1] = null;
      numOfElms--;
      return elem;
    }

    public T popRight() {
      if (isEmpty()) {
        throw new RuntimeException();
      }
      return array[--numOfElms];
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
