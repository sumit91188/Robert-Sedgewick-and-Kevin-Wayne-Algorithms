package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.Queue;

import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 7/26/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Write a Queue implementation that uses a circular linked list, which is the same
 * as a linked list except that no links are null and the value of last.next is first whenever
 * the list is not empty. Keep only one Node instance variable (last).
 */
public class Exercise29 {
    public static void main(String[] args) {
        CircularLinkedListQueue<Integer> queue = new CircularLinkedListQueue<Integer>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        for (int num : queue) {
            System.out.print(num + " ");
        }

        System.out.println();
        queue.dequeue();

        for (int num : queue) {
            System.out.print(num + " ");
        }

        System.out.println();
        queue.enqueue(70);

        for (int num : queue) {
            System.out.print(num + " ");
        }

        System.out.println();
        queue.dequeue();

        for (int num : queue) {
            System.out.print(num + " ");
        }
    }

    private static class CircularLinkedListQueue<T> implements Queue<T> {

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
}
