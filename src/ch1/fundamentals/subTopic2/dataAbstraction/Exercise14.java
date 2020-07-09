package ch1.fundamentals.subTopic2.dataAbstraction;

import java.util.Date;

/**
 * @author Sumit Deo
 */
public class Exercise14 {

    public static void main(String[] args) {

        Transaction transaction1 = new Transaction("Sumit Deo",
                new Date(),
                899.99);

        Transaction transaction2 = new Transaction("Sneha Pimpley",
                new Date(),
                799.99);

        Transaction transaction3 = new Transaction("Sumit Deo",
                new Date(),
                899.99);

        Transaction transaction4 = transaction1;

        System.out.println(transaction1.equals(transaction2)); //false
        System.out.println(transaction1.equals(transaction3)); //true
        System.out.println(transaction1.equals(transaction4)); //true
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

        public String toString() {
            return "Transaction{" +
                    "who='" + who + '\'' +
                    ", when=" + when +
                    ", amount=" + amount +
                    '}';
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Transaction that = (Transaction) o;

            if (Double.compare(that.amount, amount) != 0) return false;
            if (!who.equals(that.who)) return false;
            return when.equals(that.when);
        }
    }
}