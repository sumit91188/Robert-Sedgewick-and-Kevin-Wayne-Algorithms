package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Sumit Deo
 * @Date 8/6/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or
 * a queue but supports adding and removing items at both ends. A deque stores a collection
 * of items and supports the following API:
 * public class Deque<Item> implements Iterable<Item>
 * Deque() create an empty deque
 * boolean isEmpty() is the deque empty?
 * int size() number of items in the deque
 * void pushLeft(Item item) add an item to the left end
 * void pushRight(Item item) add an item to the right end
 * Item popLeft() remove an item from the left end
 * Item popRight() remove an item from the right end
 * API for a generic double-ended queue
 * Write a class Deque that uses a doubly-linked list to implement this API
 */
public class Exercise33_linkedList {

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        deque.pushLeft(10);
        deque.pushLeft(20);
        assertEquals("[20, 10]", deque.toString());

        deque.popLeft();
        assertEquals("[10]", deque.toString());

        deque.pushRight(30);
        deque.pushRight(40);
        assertEquals("[10, 30, 40]", deque.toString());

        deque.popRight();
        assertEquals("[10, 30]", deque.toString());
    }

    private static class Deque<T> implements Iterable<T> {

        int numElms;
        private Node<T> leftMostNode;
        private Node<T> rightMostNode;

        public int size() {
            return numElms;
        }

        public boolean isEmpty() {
            return numElms == 0;
        }

        public void pushLeft(T elm) {
            Node prevLeftMostNode = leftMostNode;

            leftMostNode = new Node<>(elm, null, prevLeftMostNode);

            if (prevLeftMostNode != null) {
                prevLeftMostNode.leftNode = leftMostNode;
            } else {
                rightMostNode = leftMostNode;
            }
            numElms++;
        }

        public void pushRight(T elm) {
            Node prevRightMostNode = rightMostNode;

            rightMostNode = new Node<>(elm, prevRightMostNode, null);

            if (prevRightMostNode != null) {
                prevRightMostNode.rightNode = rightMostNode;
            } else {
                leftMostNode = rightMostNode;
            }
            numElms++;
        }

        public T popLeft() {
            if (isEmpty()) {
                throw new RuntimeException("Empty Dqueue");
            }

            T elm = leftMostNode.data;
            leftMostNode = leftMostNode.rightNode;

            if (leftMostNode != null) {
                leftMostNode.leftNode = null;
            } else {
                rightMostNode = null;
            }

            numElms--;
            return elm;
        }

        public T popRight() {
            if (isEmpty()) {
                throw new RuntimeException("Empty Dqueue");
            }

            T elm = rightMostNode.data;
            rightMostNode = rightMostNode.leftNode;

            if (rightMostNode != null) {
                rightMostNode.rightNode = null;
            } else {
                leftMostNode = null;
            }

            numElms--;
            return elm;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                Node<T> node = leftMostNode;

                @Override
                public boolean hasNext() {
                    return node != null;
                }

                @Override
                public T next() {
                    if (hasNext()) {
                        T elm = node.data;
                        node = node.rightNode;
                        return elm;
                    } else {
                        throw new RuntimeException("No more elements");
                    }
                }
            };
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder("[");
            if (isEmpty()) {
                builder.append("]");
            } else if (leftMostNode == rightMostNode) {
                builder.append(leftMostNode.data + "]");
            } else {
                Node<T> node = leftMostNode;
                while (true) {
                    builder.append(node.data);
                    node = node.rightNode;
                    if (node != rightMostNode) {
                        builder.append(", ");
                    } else {
                        builder.append(", " + node.data + "]");
                        break;
                    }
                }
            }

            return builder.toString();
        }

        private class Node<T> {
            private T data;
            private Node<T> leftNode;
            private Node<T> rightNode;

            public Node(T data, Node<T> leftNode, Node<T> rightNode) {
                this.data = data;
                this.leftNode = leftNode;
                this.rightNode = rightNode;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "data=" + data +
                        '}';
            }
        }
    }
}
