package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/21/20
 * @comment: Write a method insertAfter() that takes two linked-list Node arguments and inserts the
 * second after the first on its list (and does nothing if either argument is null).
 */
public class Exercise25 {

  public static void main(String[] args) {
    LinkedList<String> linkedList = new LinkedList<String>();

    linkedList.addToFront("30");
    linkedList.addToFront("20");
    linkedList.addToFront("10");
    linkedList.addToLast("40");
    linkedList.addToLast("50");

    System.out.println("Is empty: " + linkedList.isEmpty());
    System.out.println("LinkedList's size: " + linkedList.size());
    System.out.print("LinkedList: ");
    for (String i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Insert after node = 60");
    linkedList.insertAfterNode("60", "60");
    System.out.print("LinkedList: ");
    for (String i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Insert after node = null");
    linkedList.insertAfterNode(null, "60");
    System.out.print("LinkedList: ");
    for (String i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Insert after node = 50");
    linkedList.insertAfterNode("50", "60");
    System.out.print("LinkedList: ");
    for (String i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Insert after node = 10");
    linkedList.insertAfterNode("10", "15");
    System.out.print("LinkedList: ");
    for (String i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class LinkedList<T> implements Iterable<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int numOfElms;

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void addToFront(T data) {
      Node<T> node = new Node<>(data, firstNode);
      firstNode = node;

      if (isEmpty()) {
        lastNode = node;
      }

      numOfElms++;
    }

    public void addToLast(T data) {
      Node<T> node = new Node<>(data, null);
      Node<T> oldLastNode = lastNode;
      lastNode = node;

      if (isEmpty()) {
        firstNode = node;
      } else {
        oldLastNode.nextNode = lastNode;
      }

      numOfElms++;
    }

    public T removeFromFront() {
      if (isEmpty()) {
        throw new RuntimeException("Empty LinkedList");
      }

      T data = firstNode.data;
      firstNode = firstNode.nextNode;
      numOfElms--;
      return data;
    }

    public void insertAfterNode(T data, T insertData) {
      if (isEmpty() || data == null || insertData == null) {
        return;
      }

      Node<T> node;

      for (node = firstNode; node != lastNode; node = node.nextNode) {
        if (node.data == data) {
          break;
        }
      }

      Node<T> newNode = new Node<>(insertData, node.nextNode);
      if (node.nextNode == lastNode) {
        lastNode = newNode;
      }
      node.nextNode = newNode;
      numOfElms++;
    }

    @Override
    public Iterator<T> iterator() {
      return new Iterator<T>() {

        Node<T> iteratorNode = firstNode;

        @Override
        public boolean hasNext() {
          return iteratorNode != null;
        }

        @Override
        public T next() {
          T data = null;
          if (hasNext()) {
            data = iteratorNode.data;
            iteratorNode = iteratorNode.nextNode;
          }
          return data;
        }
      };
    }

    private class Node<T> {

      private final T data;
      private Node<T> nextNode;

      public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
      }

      @Override
      public String toString() {
        return data.toString();
      }
    }
  }
}
