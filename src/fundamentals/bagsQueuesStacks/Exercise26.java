package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/21/20
 * @comment: Write a method remove() that takes a linked list and a string key as arguments and
 * removes all of the nodes in the list that have key as its item field.
 */
public class Exercise26 {

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

    System.out.println("Removing 10");
    linkedList.remove("10");
    System.out.print("LinkedList: ");
    for (String i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    linkedList.addToLast("50");
    linkedList.addToLast("50");
    System.out.print("LinkedList: ");
    for (String i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Removing 50");
    linkedList.remove("50");
    System.out.print("LinkedList: ");
    for (String i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    linkedList.addToFront("10");
    linkedList.addToFront("10");
    linkedList.addToLast("10");
    linkedList.addToLast("10");
    System.out.print("LinkedList: ");
    for (String i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Removing 10");
    linkedList.remove("10");
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

    public void remove(T data) {
      int size = numOfElms;

      Node<T> node = firstNode;
      for (int i = 0; i < size - 1; i++) {
        if (node.nextNode.data == data) {
          if (node.nextNode == lastNode) {
            lastNode = node;
          }
          node.nextNode = node.nextNode.nextNode;
          numOfElms--;
        } else {
          node = node.nextNode;
        }
      }

      if (firstNode.data == data) {
        firstNode = firstNode.nextNode;
        numOfElms--;
      }
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
