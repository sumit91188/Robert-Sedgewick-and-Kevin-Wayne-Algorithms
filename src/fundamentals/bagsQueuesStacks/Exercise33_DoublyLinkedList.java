package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.DoublyLinkedList;
import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/4/21
 * @comment: Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or a queue but
 * supports adding and removing items at both ends. A deque stores a collection of items and
 * supports the following API. Write a class Deque that uses a doubly-linked list to implement this
 * API.
 */
public class Exercise33_DoublyLinkedList {

  public static void main(String[] args) {
    Deque<Integer> deque = new Deque<>();

    deque.pushLeft(10);
    deque.pushLeft(20);
    deque.pushRight(30);
    deque.pushRight(40);
    deque.pushLeft(50);

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

  private static class Deque<T> implements Iterable<T> {

    DoublyLinkedList<T> list;

    public Deque() {
      this.list = new DoublyLinkedList<>();
    }

    public boolean isEmpty() {
      return list.isEmpty();
    }

    public int size() {
      return list.size();
    }

    public void pushLeft(T elem) {
      list.addFirst(elem);
    }

    public void pushRight(T elem) {
      list.addLast(elem);
    }

    public T popLeft() {
      return list.removeFirst();
    }

    public T popRight() {
      return list.removeLast();
    }

    @Override
    public Iterator<T> iterator() {
      return list.iterator();
    }
  }
}
