package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/1/21
 * @comment: Write a Queue implementation that uses a circular linked list, which is the same as a
 * linked list except that no links are null and the value of last.next is first whenever the list
 * is not empty. Keep only one Node instance variable (last).
 */
public class Exercise29 {

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue();

    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.enqueue(50);

    System.out.println("Is Queue empty: " + queue.isEmpty());
    System.out.println("Queue's size: " + queue.size());
    System.out.print("Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.println("Removing an element:" + queue.dequeue());
    System.out.print("Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();

    queue.enqueue(60);
    System.out.print("Queue: ");
    for (int i : queue) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class Queue<T> implements Iterable<T> {

    CircularLinkedList<T> linkedList;

    public Queue() {
      linkedList = new CircularLinkedList();
    }

    @Override
    public Iterator<T> iterator() {
      return linkedList.iterator();
    }

    public void enqueue(T i) {
      linkedList.addToLast(i);
    }

    public boolean isEmpty() {
      return linkedList.isEmpty();
    }

    public int size() {
      return linkedList.size();
    }

    public T dequeue() {
      return linkedList.removeFromFront();
    }
  }

  private static class CircularLinkedList<T> implements Iterable<T> {

    Node<T> lastNode;
    int numOfElms;

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void addToLast(T data) {
      Node<T> node = new Node<>(data);

      if (isEmpty()) {
        lastNode = node;
        lastNode.nextNode = lastNode;
      } else {
        node.nextNode = lastNode.nextNode;
        lastNode.nextNode = node;
        lastNode = node;
      }

      numOfElms++;
    }

    public T removeFromFront() {
      T data;
      if (isEmpty()) {
        throw new RuntimeException("Empty");
      } else if (size() == 1) {
        data = lastNode.data;
        lastNode = null;
        numOfElms--;
      } else {
        data = lastNode.nextNode.data;
        lastNode.nextNode = lastNode.nextNode.nextNode;
        numOfElms--;
      }
      return data;
    }

    @Override
    public Iterator<T> iterator() {
      return new Iterator<T>() {

        int iteratorIndex = 0;
        Node<T> iteratorNode = lastNode.nextNode;

        @Override
        public boolean hasNext() {
          return iteratorIndex < size();
        }

        @Override
        public T next() {
          T data = null;
          if (hasNext()) {
            data = iteratorNode.data;
            iteratorNode = iteratorNode.nextNode;
            iteratorIndex++;
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

      public Node(T data) {
        this.data = data;
      }

      @Override
      public String toString() {
        return data.toString();
      }
    }
  }
}
