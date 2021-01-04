package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.SinglyLinkedList;
import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/4/21
 * @comment: Steque. A stack-ended queue or steque is a data type that supports push, pop, and
 * enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
 */
public class Exercise32 {

  public static void main(String[] args) {
    Steque<Integer> steque = new Steque<Integer>();

    steque.push(10);
    steque.push(20);
    steque.enqueue(30);
    steque.enqueue(40);
    steque.push(50);

    System.out.println("Steque-");
    for (int i : steque) {
      System.out.print(i + " ");
    }
    System.out.println();

    steque.pop();
    steque.pop();
    System.out.println("Steque-");
    for (int i : steque) {
      System.out.print(i + " ");
    }
  }

  public static class Steque<T> implements Iterable<T> {

    SinglyLinkedList<T> linkedList;

    public Steque() {
      this.linkedList = new SinglyLinkedList<>();
    }

    public boolean isEmpty() {
      return linkedList.isEmpty();
    }

    public int size() {
      return linkedList.size();
    }

    public void push(T elem) {
      linkedList.addToFront(elem);
    }

    public T pop() {
      return linkedList.removeFromFront();
    }

    public void enqueue(T elem) {
      linkedList.addToLast(elem);
    }

    @Override
    public Iterator<T> iterator() {
      return linkedList.iterator();
    }
  }
}
