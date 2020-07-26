package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author Sumit Deo
 */
public class Exercise26 {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("0");
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("1");
        linkedList.add("1");
        linkedList.add("1");
        linkedList.add("1");

        for (String num : linkedList) {
            System.out.println(num);
        }

        remove(linkedList, "1");
        for (String num : linkedList) {
            System.out.println(num);
        }
    }

    private static void remove(LinkedList<String> linkedList, String toRemoveStr) {
        if (linkedList.isEmpty() || toRemoveStr == null) {
            return;
        }

        while (!linkedList.isEmpty() && linkedList.head.data.equals(toRemoveStr)) {
            linkedList.head = linkedList.head.nextNode;
            linkedList.numElms--;
        }

        LinkedList.Node<String> previousNode = linkedList.head;

        for (LinkedList.Node<String> node = linkedList.head; node != null; node = node.nextNode) {

            if (node.data.equals(toRemoveStr)) {
                previousNode.nextNode = node.nextNode;
            }
            else {
                previousNode = node;
            }
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
