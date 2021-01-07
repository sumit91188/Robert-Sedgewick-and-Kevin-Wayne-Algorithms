package fundamentals.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 1/7/21
 * @comment: Move-to-front. Read in a sequence of characters from standard input and maintain the
 * characters in a linked list with no duplicates. When you read in a previously unseen character,
 * insert it at the front of the list. When you read in a duplicate character, delete it from the
 * list and reinsert it at the beginning. Name your program MoveToFront: it implements the
 * well-known move-to-front strategy, which is useful for caching, data compression, and many other
 * applications where items that have been recently accessed are more likely to be reaccessed.
 */
public class Exercise40 {

  public static void main(String[] args) {
    MoveToFront<Integer> moveToFront = new MoveToFront<>();

    moveToFront.insert(50);
    moveToFront.insert(40);
    moveToFront.insert(30);
    moveToFront.insert(20);

    System.out.print("Sequence: ");
    for (int i : moveToFront) {
      System.out.print(i + " ");
    }
    System.out.println();

    moveToFront.insert(10);
    System.out.print("Sequence: ");
    for (int i : moveToFront) {
      System.out.print(i + " ");
    }
    System.out.println();

    moveToFront.insert(10);
    System.out.print("Sequence: ");
    for (int i : moveToFront) {
      System.out.print(i + " ");
    }
    System.out.println();

    moveToFront.insert(50);
    System.out.print("Sequence: ");
    for (int i : moveToFront) {
      System.out.print(i + " ");
    }
    System.out.println();

    moveToFront.insert(40);
    System.out.print("Sequence: ");
    for (int i : moveToFront) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static class MoveToFront<T> implements Iterable<T> {

    int numOfElms;
    private Node<T> firstNode;

    public boolean isEmpty() {
      return numOfElms == 0;
    }

    public int size() {
      return numOfElms;
    }

    public void insert(T elem) {

      for (Node<T> currentNode = firstNode; currentNode != null;
          currentNode = currentNode.nextNode) {
        if (currentNode.elem == elem) {
          delete(elem);
          break;
        }
      }

      Node<T> node = new Node<>(elem);

      if (!isEmpty()) {
        node.nextNode = firstNode;
      }
      firstNode = node;
      numOfElms++;
    }

    public void delete(T elem) {
      if (isEmpty()) {
        throw new RuntimeException();
      }

      Node<T> currentNode;

      if (firstNode.elem == elem) {
        firstNode = firstNode.nextNode;
        numOfElms--;
        return;
      }

      for (currentNode = firstNode; currentNode != null; currentNode = currentNode.nextNode) {
        if (currentNode.nextNode.elem == elem) {
          break;
        }
      }

      currentNode.nextNode = currentNode.nextNode.nextNode;
      numOfElms--;
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
          T elem = null;
          if (hasNext()) {
            elem = iteratorNode.elem;
            iteratorNode = iteratorNode.nextNode;
          }
          return elem;
        }
      };
    }

    private class Node<T> {

      private final T elem;
      private Node<T> nextNode;

      public Node(T elem) {
        this.elem = elem;
      }

      @Override
      public String toString() {
        return elem.toString();
      }
    }
  }
}
