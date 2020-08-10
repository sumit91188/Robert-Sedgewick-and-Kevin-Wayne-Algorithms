package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Sumit Deo
 * @Date 8/9/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Move-to-front. Read in a sequence of characters from standard input and
 * maintain the characters in a linked list with no duplicates. When you read in a previously
 * unseen character, insert it at the front of the list. When you read in a duplicate
 * character, delete it from the list and reinsert it at the beginning. Name your program
 * MoveToFront: it implements the well-known move-to-front strategy, which is useful for
 * caching, data compression, and many other applications where items that have been
 * recently accessed are more likely to be reaccessed.
 */
public class Exercise40 {
    public static void main(String[] args) {
        MoveToFront<Character> moveToFront = new MoveToFront<>();
        moveToFront.insert('a');
        moveToFront.insert('b');
        moveToFront.insert('c');
        moveToFront.insert('d');
        moveToFront.insert('c');
        moveToFront.insert('d');
        moveToFront.insert('z');

        System.out.println(moveToFront.toString());
    }

    private static class MoveToFront<T> implements Iterable<T> {

        int numElms;
        private Node<T> leftMostNode;
        private Node<T> rightMostNode;
        private HashSet<T> set;

        public MoveToFront() {
            set = new HashSet<>();
            numElms = 0;
        }

        public int size() {
            return numElms;
        }

        public boolean isEmpty() {
            return numElms == 0;
        }

        public void insert(T elm) {
            if (set.contains(elm)) {
                delete(elm);
            }

            Node prevLeftMostNode = leftMostNode;

            leftMostNode = new Node<>(elm, null, prevLeftMostNode);

            if (prevLeftMostNode != null) {
                prevLeftMostNode.leftNode = leftMostNode;
            } else {
                rightMostNode = leftMostNode;
            }
            numElms++;
        }

        public void delete(T elm) {
            if (isEmpty()) {
                throw new RuntimeException("Empty Dqueue");
            }

            Node<T> node;
            for (node = leftMostNode; node == null; node = node.rightNode) {
                if (node.data == elm) {
                    break;
                }
            }

            if (node.leftNode == null) {
                node.rightNode.leftNode = null;
                leftMostNode = node.rightNode;
            } else if (node.rightNode == null) {
                node.leftNode.rightNode = null;
                rightMostNode = node.leftNode;
            } else {
                node.leftNode.rightNode = node.rightNode;
                node.rightNode.leftNode = node.leftNode;
            }

            node = null;
            numElms--;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                Node<T> node = leftMostNode;

                @Override
                public boolean hasNext() {
                    return node != null;
                }

                @Override
                public T next() {
                    if (hasNext()) {
                        T elm = node.data;
                        node = node.rightNode;
                        return elm;
                    } else {
                        throw new RuntimeException("No more elements");
                    }
                }
            };
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder("[");
            if (isEmpty()) {
                builder.append("]");
            } else if (leftMostNode == rightMostNode) {
                builder.append(leftMostNode.data + "]");
            } else {
                Node<T> node = leftMostNode;
                while (true) {
                    builder.append(node.data);
                    node = node.rightNode;
                    if (node != rightMostNode) {
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
            private Node<T> leftNode;
            private Node<T> rightNode;

            public Node(T data, Node<T> leftNode, Node<T> rightNode) {
                this.data = data;
                this.leftNode = leftNode;
                this.rightNode = rightNode;
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
