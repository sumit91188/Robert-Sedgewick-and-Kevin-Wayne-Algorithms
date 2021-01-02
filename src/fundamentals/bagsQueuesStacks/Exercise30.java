package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/2/21
 * @comment: Write a function that takes the first Node in a linked list as argument and
 * (destructively) reverses the list, returning the first Node in the result.
 */
public class Exercise30 {

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();

    linkedList.addToFront(50);
    linkedList.addToFront(40);
    linkedList.addToFront(30);
    linkedList.addToFront(20);
    linkedList.addToFront(10);

    System.out.print("LinkedList: ");
    for (int i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Last element in the linked list: " + linkedList.reverse_a());
    System.out.print("LinkedList: ");
    for (int i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Last element in the linked list: " + linkedList.reverse_b());
    System.out.print("LinkedList: ");
    for (int i : linkedList) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class LinkedList implements Iterable<Integer> {

    private LinkedList.Node firstNode;
    private LinkedList.Node lastNode;
    private int numOfElms;

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void addToFront(int data) {
      LinkedList.Node node = new LinkedList.Node(data, firstNode);
      firstNode = node;

      if (isEmpty()) {
        lastNode = node;
      }

      numOfElms++;
    }

    public void addToLast(int data) {
      LinkedList.Node node = new LinkedList.Node(data, null);
      LinkedList.Node oldLastNode = lastNode;
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

        LinkedList.Node iteratorNode = firstNode;

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

      return max(firstNode.nextNode, firstNode.data);
    }

    private int max(LinkedList.Node node, int maxData) {
      if (node == null) {
        return maxData;
      }

      if (node.data > maxData) {
        maxData = node.data;
      }

      return max(node.nextNode, maxData);
    }

    public Node reverse_a() {
      Node reverseNode = null;
      while (firstNode != null) {
        Node secondNode = firstNode.nextNode;
        firstNode.nextNode = reverseNode;
        reverseNode = firstNode;
        firstNode = secondNode;
      }
      firstNode = reverseNode;
      return reverseNode;
    }

    public Node reverse_b() {
      firstNode = reversRecursive(firstNode);
      return firstNode;
    }

    private Node reversRecursive(Node firstNode) {
      if (firstNode == null) {
        return null;
      }
      if (firstNode.nextNode == null) {
        return firstNode;
      }
      Node secondNode = firstNode.nextNode;
      Node restNode = reversRecursive(secondNode);
      secondNode.nextNode = firstNode;
      firstNode.nextNode = null;
      return restNode;
    }

    private class Node {

      private final int data;
      private LinkedList.Node nextNode;

      public Node(int data, LinkedList.Node nextNode) {
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
