package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 7/26/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Develop a recursive solution to the previous question for :
 * Write a method max() that takes a reference to the first node in a linked list as
 * argument and returns the value of the maximum key in the list. Assume that all keys are
 * positive integers, and return 0 if the list is empty.
 */
public class Exercise28 {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(10);
        linkedList.add(90);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(60);
        linkedList.add(80);
        linkedList.add(40);

        System.out.println("The value of maximum key in the list is " + linkedList.max());
    }
    
    private static class LinkedList<T> implements Iterable<T> {

        private int numElms;
        private Node<T> head;

        public int max() {
            if (isEmpty()) {
                return 0;
            }

            int maxValue = max((int) head.data, head.nextNode);

            return maxValue;
        }

        private int max(int data, Node nextNode) {
            if (nextNode == null) {
                return data;
            }

            if ((int)nextNode.data > data) {
                return max((int)nextNode.data, nextNode.nextNode);
            }
            return data;
        }

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
