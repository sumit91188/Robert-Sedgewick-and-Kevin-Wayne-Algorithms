package ch1.fundamentals.subTopic3.bagsQueuesStacks.util;

import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 7/27/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Implement a nested class DoubleNode for building doubly-linked lists, where
 * each node contains a reference to the item preceding it and the item following it in the
 * list (null if there is no such item). Then implement static methods for the following
 * tasks: insert at the beginning, insert at the end, remove from the beginning, remove
 * from the end, insert before a given node, insert after a given node, and remove a given
 * node.
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    int numElms;
    private Node<T> head;
    private Node<T> tail;

    public int size() {
        return numElms;
    }

    public boolean isEmpty() {
        return numElms == 0;
    }

    public void insertAtBeginning(T elm) {
        Node<T> node;

        if (isEmpty()) {
            node = new Node<>(elm, null, null);
            head = node;
            tail = node;
        } else {
            node = head;
            head = new Node<>(elm, null, node);
            node.previousNode = head;
        }
        numElms++;
    }

    public void insertAtEnd(T elm) {
        Node<T> node;

        if (isEmpty()) {
            node = new Node<>(elm, null, null);
            head = node;
            tail = node;
        } else {
            node = new Node<>(elm, tail, null);
            tail.nextNode = node;
            tail = node;
        }
        numElms++;
    }

    public T removeFromBeginning() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }

        T data = head.data;
        if (numElms == 1) {
            tail = head = null;
        } else {
            head = head.nextNode;
            head.previousNode = null;
        }
        numElms--;
        return data;
    }

    public T removeFromEnd() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }

        T data = tail.data;
        if (numElms == 1) {
            tail = head = null;
        } else {
            tail = tail.previousNode;
            tail.nextNode = null;
        }
        numElms--;
        return data;
    }

    public void insertBeforeGivenNode(T beforeElm, T elm) {

        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }

        Node<T> node;
        for (node = head; node != null; node = node.nextNode) {
            if (node.data.equals(beforeElm)) {
                break;
            }
        }

        if (node != null) {
            Node<T> newNode = new Node<>(elm, node.previousNode, node);

            if (newNode.previousNode == null) {
                head = newNode;
            } else {
                node.previousNode.nextNode = newNode;
                node.previousNode = newNode;
            }

            numElms++;
        }
    }

    public void insertAfterGivenNode(T afterElm, T elm) {

        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }

        Node<T> node;
        for (node = head; node != null; node = node.nextNode) {
            if (node.data.equals(afterElm)) {
                break;
            }
        }

        if (node != null) {
            Node<T> newNode = new Node<>(elm, node, node.nextNode);
            if (newNode.nextNode == null) {
                tail = newNode;
            } else {
                node.nextNode.previousNode = newNode;
                node.nextNode = newNode;
            }

            numElms++;
        }
    }

    public void removeNode(T elm) {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }

        Node<T> node;
        for (node = head; node != null; node = node.nextNode) {
            if (node.data.equals(elm)) {
                break;
            }
        }

        if (node != null) {
            if (node.previousNode == null) {
                node.nextNode.previousNode = null;
                head = node.nextNode;
            } else if (node.nextNode == null) {
                node.previousNode.nextNode = null;
                tail = node.previousNode;
            } else {
                node.nextNode.previousNode = node.previousNode;
                node.previousNode.nextNode = node.nextNode;
            }
            node = null;
            numElms--;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (isEmpty()) {
            builder.append("]");
        } else if (head == tail) {
            builder.append(head.data + "]");
        } else {
            Node<T> node = head;
            while (true) {
                builder.append(node.data);
                node = node.nextNode;
                if (node != tail) {
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
        private Node<T> previousNode;
        private Node<T> nextNode;

        public Node(T data, Node<T> previousNode, Node<T> nextNode) {
            this.data = data;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
