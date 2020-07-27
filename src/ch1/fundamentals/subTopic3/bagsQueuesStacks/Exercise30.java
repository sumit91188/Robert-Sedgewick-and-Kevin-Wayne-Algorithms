package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 7/26/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Write a function that takes the first Node in a linked list as argument and (destructively)
 * reverses the list, returning the first Node in the result.
 * Iterative solution : To accomplish this task, we maintain references to three consecutive
 * nodes in the linked list, reverse, first, and second. At each iteration, we extract the
 * node first from the original linked list and insert it at the beginning of the reversed
 * list. We maintain the invariant that first is the first node of what’s left of the original
 * list, second is the second node of what’s left of the original list, and reverse is the first
 * node of the resulting reversed list.
 * public Node reverse(Node x)
 * {
 * Node first = x;
 * Node reverse = null;
 * while (first != null)
 * {
 * Node second = first.next;
 * first.next = reverse;
 * reverse = first;
 * first = second;
 * }
 * return reverse;
 * }
 * When writing code involving linked lists, we must always be careful to properly handle
 * the exceptional cases (when the linked list is empty, when the list has only one or two
 * nodes) and the boundary cases (dealing with the first or last items). This is usually
 * much trickier than handling the normal cases.
 * Recursive solution : Assuming the linked list has N nodes, we recursively reverse the last
 * N – 1 nodes, and then carefully append the first node to the end.
 * public Node reverse(Node first)
 * {
 * if (first == null) return null;
 * if (first.next == null) return first;
 * Node second = first.next;
 * Node rest = reverse(second);
 * second.next = first;
 * first.next = null;
 * return rest;
 * }
 */
public class Exercise30 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.reverse();

        for (int num : linkedList) {
            System.out.print(num + " ");
        }
    }

    private static class LinkedList<T> implements Iterable<T> {

        private int numElms;
        private LinkedList.Node<T> head;

        public int size() {
            return numElms;
        }

        public boolean isEmpty() {
            return numElms == 0;
        }

        public void add(T data) {

            LinkedList.Node<T> node;
            if (isEmpty()) {
                node = new LinkedList.Node<>(data, null);
                head = node;
            } else {
                for (node = head; node.nextNode != null; node = node.nextNode) {
                }
                ;
                node.nextNode = new LinkedList.Node<>(data, null);
            }
            numElms++;
        }

        public Node reverse() {
            if (isEmpty()) {
                return null;
            }

            if (numElms == 1) {
                return head;
            }

            Node oldNode = head;
            Node currentNode = head.nextNode;
            Node newNode = head.nextNode.nextNode;

            head.nextNode = null;
            head = currentNode;
            currentNode.nextNode = oldNode;

            while (newNode != null) {
                oldNode = currentNode;
                currentNode = newNode;
                newNode = newNode.nextNode;
                currentNode.nextNode = oldNode;
                head = currentNode;
            }
            return head;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {

                LinkedList.Node<T> node = head;

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

        private static class Node<T> {
            T data;
            LinkedList.Node nextNode;

            public Node(T data, LinkedList.Node nextNode) {
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
    }
}
