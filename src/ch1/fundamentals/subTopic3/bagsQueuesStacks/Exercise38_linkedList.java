package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 8/8/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Delete kth element. Implement a class that supports the following API:
 * public class GeneralizedQueue<Item>
 * GeneralizedQueue() create an empty queue
 * boolean isEmpty() is the queue empty?
 * void insert(Item x) add an item
 * Item delete(int k) delete and return the kth least recently inserted item
 * API for a generic generalized queue
 * First, develop an implementation that uses an array implementation, and then develop
 * one that uses a linked-list implementation. Note : the algorithms and data structures
 * that we introduce in Chapter 3 make it possible to develop an implementation that
 * can guarantee that both insert() and delete() take time prortional to the logarithm
 * of the number of items in the queue—see Exercise 3.5.27.
 */
public class Exercise38_linkedList {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue();
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.insert(60);
        System.out.println(queue.toString());

        queue.delete(2);
        System.out.println(queue.toString());

        queue.delete(3);
        System.out.println(queue.toString());

        queue.insert(40);
        queue.insert(50);
        queue.insert(60);
        System.out.println(queue.toString());

        queue.delete(1);
        System.out.println(queue.toString());

        queue.delete(6);
        System.out.println(queue.toString());
    }

    private static class LinkedListQueue<T> implements Iterable<T> {

        int numElms;
        private Node<T> leftMostNode;
        private Node<T> rightMostNode;

        public int size() {
            return numElms;
        }

        public boolean isEmpty() {
            return numElms == 0;
        }

        public void insert(T elm) {
            Node prevRightMostNode = rightMostNode;

            rightMostNode = new Node<>(elm, prevRightMostNode, null);

            if (prevRightMostNode != null) {
                prevRightMostNode.rightNode = rightMostNode;
            } else {
                leftMostNode = rightMostNode;
            }
            numElms++;
        }

        public T delete(int k) {
            if (isEmpty()) {
                throw new RuntimeException("Empty Dqueue");
            }

            if (k <= 0 || k > numElms) {
                throw new RuntimeException("Invalid value of k, should be grater than 0 and less than number of elements");
            }

            Node<T> node = leftMostNode;
            for (int i = 2; i <= k; i++) {
                node = node.rightNode;
            }

            T elm = node.data;
            if (node.leftNode == null) {
                node.rightNode.leftNode = null;
                leftMostNode = node.rightNode;
            } else if (node.rightNode == null) {
                node.leftNode.rightNode = null;
                rightMostNode = node.leftNode;
            } else {
                node.leftNode.rightNode = node.rightNode;
                node.rightNode.leftNode = node.leftNode;
            }

            node = null;
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
