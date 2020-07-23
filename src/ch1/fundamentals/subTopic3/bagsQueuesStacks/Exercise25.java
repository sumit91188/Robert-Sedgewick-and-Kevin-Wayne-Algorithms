package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author Sumit Deo
 */
public class Exercise25 {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        for (int num : linkedList) {
            System.out.println(num);
        }

        LinkedList.Node<Integer> firstNode = new LinkedList.Node<Integer>(1, null);
        LinkedList.Node<Integer> secondNode = new LinkedList.Node<Integer>(10, null);

        linkedList.insertAfter(firstNode, secondNode);
        for (int num : linkedList) {
            System.out.println(num);
        }

        firstNode = new LinkedList.Node<Integer>(2, null);
        secondNode = new LinkedList.Node<Integer>(10, null);

        linkedList.insertAfter(firstNode, secondNode);
        for (int num : linkedList) {
            System.out.println(num);
        }
    }

    private static class LinkedList<T> implements Iterable<T> {

        private int numElms;
        private Node<T> head;

        private static class Node<T> {
            T data;
            Node nextNode;

            public Node(T data, Node nextNode) {
                this.data = data;
                this.nextNode = nextNode;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "data=" + data +
                        ", nextNode=" + nextNode +
                        '}';
            }
        }

        public int size() {
            return numElms;
        }

        public boolean isEmpty() {
            return numElms == 0;
        }

        public void add(T data) {

            Node<T> node;
            if (isEmpty()) {
                node = new Node<>(data, null);
                head = node;
            }
            else {
                for (node = head; node.nextNode != null; node = node.nextNode) {};
                node.nextNode = new Node<>(data, null);
            }
            numElms++;
        }

        public void removeLast() {

            Node<T> node;
            if (! isEmpty()) {
                if (numElms == 1) {
                    head = null;
                }
                else {
                    for (node = head; node.nextNode.nextNode != null; node = node.nextNode) {};
                    node.nextNode = null;
                }
            }
            numElms--;
        }

        public boolean delete(int k) {

            Node node = head;
            if (k > 0 || k < numElms - 1) {
                if (k == 0) {
                    head = head.nextNode;
                }
                else {
                    for (int i = 1; i < k; i++) {
                        node = node.nextNode;
                    }
                    node.nextNode = node.nextNode.nextNode;
                }

                numElms--;
                return true;
            }

            return false;
        }

        public void insertAfter(Node<T> firstNode, Node<T> secondNode) {
            if (isEmpty() || firstNode == null || secondNode == null) {
                return;
            }

            Node<T> currentNode;
            for (currentNode = head; currentNode != null; currentNode = currentNode.nextNode) {
                if (currentNode.data == firstNode.data) {
                    secondNode.nextNode = currentNode.nextNode;
                    currentNode.nextNode = secondNode;
                    numElms++;
                    break;
                }
            }
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {

                Node<T> node = head;

                @Override
                public boolean hasNext() {
                    return node != null;
                }

                @Override
                public T next() {
                    T data = node.data;
                    node = node.nextNode;
                    return data;
                }
            };
        }
    }
}
