package fundamentals.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/17/20
 * @comment:
 */
public class SinglyLinkedListStack<Item> implements Iterable<Item> {

  private final SinglyLinkedList<Item> linkedList;

  public SinglyLinkedListStack() {
    linkedList = new SinglyLinkedList<>();
  }

  public boolean isEmpty() {
    return linkedList.isEmpty();
  }

  public int size() {
    return linkedList.size();
  }

  public void push(Item data) {
    linkedList.addToFront(data);
  }

  public Item pop() {
    return linkedList.removeFromFront();
  }

  @Override
  public Iterator<Item> iterator() {
    return linkedList.iterator();
  }
}
