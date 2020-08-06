package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * @author Sumit Deo
 * @Date 8/5/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Steque. A stack-ended queue or steque is a data type that supports push, pop, and
 * enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
 */
public class Exercise32 {
    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        steque.pop();
        steque.enqueue(5);
        steque.enqueue(6);
        steque.dequeue();

        StringJoiner stequeItems = new StringJoiner(" ");
        for (int number : steque) {
            stequeItems.add(String.valueOf(number));
        }

        System.out.println("Steque items: " + stequeItems.toString());
    }

    private static class Steque<T> implements Iterable<T> {

        Node<T> firstNode;
        Node<T> lastNode;
        int numElms;

        public int size() {
            return numElms;
        }

        public boolean isEmpty() {
            return numElms == 0;
        }

        public void push(T elm) {
            Node<T> node = firstNode;

            firstNode = new Node<>(elm, null, node);
            if (node != null) {
                node.previousNode = firstNode;
            } else {
                lastNode = firstNode;
            }
            numElms++;
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("Empty Steque");
            }

            T elm = firstNode.data;
            firstNode = firstNode.nextNode;

            if (firstNode != null) {
                firstNode.previousNode = null;
            } else {
                lastNode = firstNode;
            }

            numElms--;
            return elm;
        }

        public void enqueue(T elm) {
            Node<T> node = lastNode;

            lastNode = new Node<>(elm, node, null);
            if (node != null) {
                node.nextNode = lastNode;
            } else {
                lastNode = firstNode;
            }
            numElms++;
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Empty Steque");
            }

            T elm = lastNode.data;
            lastNode = lastNode.previousNode;

            if (lastNode != null) {
                lastNode.nextNode = null;
            } else {
                firstNode = lastNode;
            }

            numElms--;
            return elm;
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
                    if (hasNext()) {
                        T data = node.data;
                        node = node.nextNode;
                        return data;
                    } else {
                        throw new RuntimeException("No more elements");
                    }
                }
            };
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
}
