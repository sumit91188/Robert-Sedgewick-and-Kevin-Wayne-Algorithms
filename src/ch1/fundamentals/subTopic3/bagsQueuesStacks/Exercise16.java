package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownQueue;
import edu.princeton.cs.algs4.In;

import java.util.Date;

/**
 * @author Sumit Deo
 */
public class Exercise16 {

    public static void main(String[] args) {

        String dateFile = "";

        try {
            dateFile = args[0];
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Needs Files Name");
            System.exit(0);
        }

        Date[] dates = readDates(dateFile);

        for (Date date : dates) {
            System.out.println(date);
        }
    }

    private static Date[] readDates(String dateFile) {

        In in = new In(dateFile);
        PushDownQueue<Date> queue = new PushDownQueue<>();

        while (! in.isEmpty()) {
            queue.enqueue(new Date(in.readString()));
        }

        Date[] dates = new Date[queue.size()];

        for (int i = 0; i < queue.size(); i++) {
            dates[i] = queue.dequeue();
        }

        return dates;
    }
}
