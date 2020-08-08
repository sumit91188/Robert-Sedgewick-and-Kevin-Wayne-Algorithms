package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownQueue;

/**
 * @author Sumit Deo
 * @Date 8/8/20
 * @Project Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @Comments Josephus problem. In the Josephus problem from antiquity, N people are in dire
 * straits and agree to the following strategy to reduce the population. They arrange themselves
 * in a circle (at positions numbered from 0 to N–1) and proceed around the circle,
 * eliminating every Mth person until only one person is left. Legend has it that Josephus
 * figured out where to sit to avoid being eliminated. Write a Queue client Josephus that
 * takes N and M from the command line and prints out the order in which people are
 * eliminated (and thus would show Josephus where to sit in the circle).
 */
public class Exercise37 {
    public static void main(String[] args) {

        int numberOfPeople = 7;
        int personToBeEliminated = 2;

        try {
            numberOfPeople = Integer.parseInt(args[0].trim());
            personToBeEliminated = Integer.parseInt(args[1].trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: Input needs to be integer.");
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Need 2 int inputs");
            System.exit(1);
        }

        System.out.println("People will be eliminated in following order..");

        PushDownQueue<Integer> positions = new PushDownQueue<>();
        for (int i = 0; i < numberOfPeople; i++) {
            positions.enqueue(i);
        }

        while (numberOfPeople > 0) {
            for (int i = 1; i < personToBeEliminated; i++) {
                positions.enqueue(positions.dequeue());
            }
            numberOfPeople--;
            System.out.print(positions.dequeue() + " ");
        }
    }
}
