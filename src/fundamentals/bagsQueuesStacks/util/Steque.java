package fundamentals.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks.util
 * @date 1/4/21
 * @comment: A stack-ended queue or steque is a data type that supports push, pop, and enqueue.
 * Articulate an API for this ADT. Develop a linked-list-based implementation.
 */
public class Steque<T> implements Iterable<T> {

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
