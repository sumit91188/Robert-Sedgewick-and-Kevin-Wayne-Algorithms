package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/24/20
 * @comment: Develop a recursive solution to the previous question.
 */
public class Exercise28 {

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

    private int max(Node node, int maxData) {
      if (node == null) {
        return maxData;
      }

      if (node.data > maxData) {
        maxData = node.data;
      }

      return max(node.nextNode, maxData);
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
