package fundamentals.dataAbstraction;

import java.util.Date;

/**
 * @author Sumit Deo
 */
public class Exercise13 {

    public static void main(String[] args) {

        Transaction transaction = new Transaction("Sumit Deo",
                new Date(),
                899.99);

        System.out.println(transaction.toString());
    }

    static class Transaction {

        private final String who;
        private final Date when;
        private final double amount;

        public Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public String getWho() {
            return who;
        }

        public Date getWhen() {
            return when;
        }

        public double getAmount() {
            return amount;
        }

        public String toString() {
            return "Transaction{" +
                    "who='" + who + '\'' +
                    ", when=" + when +
                    ", amount=" + amount +
                    '}';
        }
    }
}