package ch1.fundamentals.subTopic3.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author Sumit Deo
 */
public class PushDownStack<T> implements Stack<T> {

    private int numElms;
    private Node<T> firstNode;

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
    public void push(T elem) {
        Node oldNode = firstNode;
        firstNode = new Node<>(elem, oldNode);
        numElms++;
    }

    @Override
    public T peek() {
        return firstNode.data;
    }

    @Override
    public T pop() {
        T data = firstNode.data;
        firstNode = firstNode.next;
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
                T data = node.data;
                node = node.next;
                return data;
            }
        };
    }
}
