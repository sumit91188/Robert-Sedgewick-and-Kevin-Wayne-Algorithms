package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.DoublyLinkedList;

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
public class Exercise31 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
        linkedList.insertAtBeginning(10);
        linkedList.insertAtBeginning(20);
        linkedList.insertAtBeginning(30);
        System.out.println(linkedList);

        linkedList.insertAtEnd(40);
        linkedList.insertAtEnd(50);
        System.out.println(linkedList);

        linkedList.insertAfterGivenNode(10, 100);
        System.out.println(linkedList);

        linkedList.insertBeforeGivenNode(10, 200);
        System.out.println(linkedList);

        linkedList.removeFromBeginning();
        System.out.println(linkedList);

        linkedList.removeFromEnd();
        System.out.println(linkedList);

        linkedList.removeNode(10);
        System.out.println(linkedList);
    }
}
