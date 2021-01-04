package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/3/21
 * @comment: Implement a nested class DoubleNode for building doubly-linked lists, where each node
 * contains a reference to the item preceding it and the item following it in the list (null if
 * there is no such item). Then implement static methods for the following tasks: insert at the
 * beginning, insert at the end, remove from the beginning, remove from the end, insert before a
 * given node, insert after a given node, and remove a given node.
 */
public class Exercise31 {

  public static void main(String[] args) {
    DoublyLinkedList<Integer> linkedList = new DoublyLinkedList();
  }

  private static class DoublyLinkedList<T> implements Iterable<T> {

    private int numOfElms;
    private Node<T> firstNode;
    private Node<T> lastNode;

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }


    public void insertAtBeginning(T data) {
      Node<T> node = new Node<>(data);
      if (isEmpty()) {
        firstNode = node;
        lastNode = node;
      } else {
        node.nextNode = firstNode;
        firstNode.previousNode = node;
        firstNode = node;
      }
      numOfElms++;
      node = null;
    }

    public void insertAtEnd(T data) {
      Node<T> node = new Node<>(data);
      if (isEmpty()) {
        firstNode = node;
        lastNode = node;
      } else {
        node.previousNode = lastNode;
        lastNode.nextNode = node;
        lastNode = node;
      }
      numOfElms++;
      node = null;
    }

    public void add(T elem) {
      insertAtEnd(elem);
    }

    public T removeAtBeginning() {
      if (isEmpty()) {
        throw new RuntimeException("Empty List");
      }

      T data = firstNode.data;
      firstNode = firstNode.nextNode;
      numOfElms--;

      if (isEmpty()) {
        lastNode = null;
      } else {
        firstNode.previousNode = null;
      }

      return data;
    }

    public T removeAtEnd() {
      if (isEmpty()) {
        throw new RuntimeException("Empty List");
      }

      T data = lastNode.data;
      lastNode = lastNode.previousNode;
      numOfElms--;

      if (isEmpty()) {
        firstNode = null;
      } else {
        lastNode.nextNode = null;
      }

      return data;
    }

    public void insertBefore(T insertBeforeNodeData, T data) {
      if (isEmpty()) {
        throw new RuntimeException("Empty List");
      }
      Node<T> currentNode;

      for (currentNode = firstNode; currentNode != null; currentNode = currentNode.nextNode) {
        if (currentNode.data == insertBeforeNodeData) {
          break;
        }
      }

      if (currentNode != null) {
        Node<T> node = new Node<>(data);
        if (currentNode == firstNode) {
          currentNode.previousNode = node;
          node.nextNode = currentNode;
          firstNode = node;
        } else {
          Node<T> previousNode = currentNode.previousNode;
          currentNode.previousNode = node;
          node.nextNode = currentNode;
          node.previousNode = previousNode;
          previousNode.nextNode = node;
        }
        numOfElms++;
      }
    }

    public void insertAfter(T insertAfterNodeData, T data) {
      if (isEmpty()) {
        throw new RuntimeException("Empty List");
      }
      Node<T> currentNode;

      for (currentNode = firstNode; currentNode != null; currentNode = currentNode.nextNode) {
        if (currentNode.data == insertAfterNodeData) {
          break;
        }
      }

      if (currentNode != null) {
        Node<T> node = new Node<>(data);
        if (currentNode == lastNode) {
          currentNode.nextNode = node;
          node.previousNode = currentNode;
          lastNode = node;
        } else {
          Node<T> nextNode = currentNode.nextNode;
          currentNode.nextNode = node;
          node.previousNode = currentNode;
          node.nextNode = nextNode;
          nextNode.previousNode = node;
        }
        numOfElms++;
      }
    }

    public T remove(T removeNodeData) {
      if (isEmpty()) {
        throw new RuntimeException("Empty List");
      }

      Node<T> currentNode;
      for (currentNode = firstNode; currentNode != null; currentNode = currentNode.nextNode) {
        if (currentNode.data == removeNodeData) {
          break;
        }
      }

      if (currentNode == null) {
        return null;
      } else if (currentNode == firstNode) {
        removeAtBeginning();
      } else if (currentNode == lastNode) {
        removeAtEnd();
      } else {
        Node<T> previousNode = currentNode.previousNode;
        Node<T> nextNode = currentNode.nextNode;
        previousNode.nextNode = nextNode;
        nextNode.previousNode = previousNode;
        numOfElms--;
      }
      return removeNodeData;
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
      private Node<T> previousNode;
      private Node<T> nextNode;

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
