package ch1.fundamentals.subTopic3.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author Sumit Deo
 */
public class PushDownQueue<T> implements Queue<T> {

    private int numElms;
    private Node<T> firstNode;
    private Node<T> lastNode;

    private class Node<T> {
        private T data;
        private Node<T> next;

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

        Node node = lastNode;
        lastNode = new Node<>(elem, null);
        if (isEmpty()) {
            firstNode = lastNode;
        }
        else {
            node.next = lastNode;
        }
        numElms++;
    }

    @Override
    public T dequeue() {

        T data = firstNode.data;
        firstNode = firstNode.next;
        if (isEmpty()) {
            lastNode = null;
        }
        numElms--;
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> node = firstNode;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T data = null;
                if (hasNext()) {
                    data = node.data;
                    node = node.next;
                }
                return data;
            }
        };
    }
}
