package ch1.fundamentals.subTopic3.bagsQueuesStacks;

import ch1.fundamentals.subTopic3.bagsQueuesStacks.util.PushDownQueue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Transaction;

/**
 * @author Sumit Deo
 */
public class Exercise17 {

    public static void main(String[] args) {

        String transactionsFile = "";

        try {
            transactionsFile = args[0];
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException: Needs Files Name");
            System.exit(0);
        }

        Transaction[] transactions = readTransactions(transactionsFile);

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private static Transaction[] readTransactions(String transactionFile) {

        In in = new In(transactionFile);
        PushDownQueue<Transaction> queue = new PushDownQueue<>();

        while (! in.isEmpty()) {
            queue.enqueue(new Transaction(in.readString()));
        }

        Transaction[] transactions = new Transaction[queue.size()];

        for (int i = 0; i < queue.size(); i++) {
            transactions[i] = queue.dequeue();
        }

        return transactions;
    }
}
