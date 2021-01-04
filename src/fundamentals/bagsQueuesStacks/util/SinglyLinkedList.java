package fundamentals.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/17/20
 * @comment:
 */
public class SinglyLinkedList<Item> implements Iterable<Item> {

  private Node<Item> firstNode;
  private Node<Item> lastNode;
  private int numOfElms;

  public boolean isEmpty() {
    return numOfElms == 0;  // or numOfElms == 0;
  }

  public int size() {
    return numOfElms;
  }

  public void addToFront(Item data) {
    Node<Item> node = new Node<>(data, firstNode);
    firstNode = node;
    if (isEmpty()) {
      lastNode = node;
    }
    numOfElms++;
  }

  public void addToLast(Item data) {
    Node<Item> oldLastNode = lastNode;
    lastNode = new Node<>(data, null);
    if (isEmpty()) {
      firstNode = lastNode;
    } else {
      oldLastNode.nextNode = lastNode;
    }
    numOfElms++;
  }

  public Item removeFromFront() {
    if (isEmpty()) {
      return null;
    }

    Item data = firstNode.data;
    firstNode = firstNode.nextNode;
    numOfElms--;
    return data;
  }

  @Override
  public Iterator<Item> iterator() {
    return new Iterator<Item>() {

      Node<Item> iteratorNode = firstNode;

      @Override
      public boolean hasNext() {
        return iteratorNode != null;
      }

      @Override
      public Item next() {
        Item data = null;
        if (hasNext()) {
          data = iteratorNode.data;
          iteratorNode = iteratorNode.nextNode;
        }
        return data;
      }
    };
  }

  private class Node<Item> {

    private final Item data;
    private Node<Item> nextNode;

    public Node(Item data, Node<Item> nextNode) {
      this.data = data;
      this.nextNode = nextNode;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }
}
