package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/21/20
 * @comment: Give a code fragment that removes the last node in a linked list whose first node is
 * first.
 */
public class Exercise20 {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<Integer>();

    linkedList.addToFront(30);
    linkedList.addToFront(20);
    linkedList.addToFront(10);
    linkedList.addToLast(40);
    linkedList.addToLast(50);

    System.out.println("Is empty: " + linkedList.isEmpty());
    System.out.println("LinkedList's size: " + linkedList.size());
    System.out.print("LinkedList: ");
    for (int i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Remove 0th element: " + linkedList.delete(0));
    System.out.print("LinkedList: ");
    for (int i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Remove 1st element: " + linkedList.delete(1));
    System.out.print("LinkedList: ");
    for (int i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Remove 2nd element: " + linkedList.delete(2));
    System.out.print("LinkedList: ");
    for (int i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Remove 3rd element: " + linkedList.delete(3));
    System.out.print("LinkedList: ");
    for (int i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Remove 2nd element: " + linkedList.delete(2));
    System.out.print("LinkedList: ");
    for (int i : linkedList) {
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

    public T delete(int index) {
      if (isEmpty() || index <= 0) {
        return null;
      }

      if (index == 1) {
        return removeFromFront();
      }

      Node<T> node = firstNode;
      for (int i = 2; i < index; i++) {
        if (node != null) {
          node = node.nextNode;
        } else {
          return null;
        }
      }

      T data = node.nextNode.data;
      node.nextNode = node.nextNode.nextNode;
      if (index == size()) {
        lastNode = node.nextNode;
      }
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
