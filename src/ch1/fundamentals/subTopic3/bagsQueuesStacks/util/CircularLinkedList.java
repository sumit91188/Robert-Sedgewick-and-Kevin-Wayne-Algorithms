package ch1.fundamentals.subTopic3.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 8/16/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Circular linked list, which is the same
 * as a linked list except that no links are null and the value of last.next is first whenever
 * the list is not empty.
 */
public class CircularLinkedList<T> implements Queue<T> {
    private int numElms;
    private Node<T> lastNode;

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Node node = lastNode;
            lastNode.next = node.next.next;
            numElms--;
            return (T) node.next.data;
        }
    }

    @Override
    public int size() {
        return numElms;
    }

    @Override
    public boolean isEmpty() {
        return numElms == 0;
    }

    @Override
    public void enqueue(T elem) {
        if (elem == null) {
            return;
        }

        Node<T> node = new Node<T>();
        node.data = elem;

        if (isEmpty()) {
            lastNode = node;
            lastNode.next = lastNode;
        } else {
            node.next = lastNode.next;
            lastNode.next = node;
            lastNode = node;
        }
        numElms++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {

            Node<T> node = lastNode;
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < numElms;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    index++;
                    if (numElms == 1) {
                        return lastNode.data;
                    } else {
                        T data = node.next.data;
                        node = node.next;
                        return data;
                    }
                }
                return null;
            }
        };
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "t=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
