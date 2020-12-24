package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/21/20
 * @comment: Write a method max() that takes a reference to the first node in a linked list as
 * argument and returns the value of the maximum key in the list. Assume that all keys are positive
 * integers, and return 0 if the list is empty.
 */
public class Exercise27 {

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();

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

    System.out.println("Maximum element is the list: " + linkedList.max());

    linkedList.addToFront(60);
    System.out.print("LinkedList: ");
    for (int i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Maximum element is the list: " + linkedList.max());
  }

  private static class LinkedList implements Iterable<Integer> {

    private Node firstNode;
    private Node lastNode;
    private int numOfElms;

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void addToFront(int data) {
      Node node = new Node(data, firstNode);
      firstNode = node;

      if (isEmpty()) {
        lastNode = node;
      }

      numOfElms++;
    }

    public void addToLast(int data) {
      Node node = new Node(data, null);
      Node oldLastNode = lastNode;
      lastNode = node;

      if (isEmpty()) {
        firstNode = node;
      } else {
        oldLastNode.nextNode = lastNode;
      }

      numOfElms++;
    }

    public int removeFromFront() {
      if (isEmpty()) {
        throw new RuntimeException("Empty LinkedList");
      }

      int data = firstNode.data;
      firstNode = firstNode.nextNode;
      numOfElms--;
      return data;
    }

    @Override
    public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {

        Node iteratorNode = firstNode;

        @Override
        public boolean hasNext() {
          return iteratorNode != null;
        }

        @Override
        public Integer next() {
          Integer data = null;
          if (hasNext()) {
            data = iteratorNode.data;
            iteratorNode = iteratorNode.nextNode;
          }
          return data;
        }
      };
    }

    public int max() {
      int max = 0;
      if (isEmpty()) {
        return max;
      }

      Node node = firstNode;
      for (int i = 0; i < size(); i++) {
        if (node.data > max) {
          max = node.data;
        }
        node = node.nextNode;
      }
      return max;
    }

    private class Node {

      private final int data;
      private Node nextNode;

      public Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
      }

      @Override
      public String toString() {
        return String.valueOf(data);
      }
    }
  }
}
