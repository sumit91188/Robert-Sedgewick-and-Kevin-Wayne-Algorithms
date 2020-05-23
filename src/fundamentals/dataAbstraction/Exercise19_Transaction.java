package fundamentals.dataAbstraction;

import java.util.Date;

/**
 * @author Sumit Deo
 */
public class Exercise19_Transaction {

    public static void main(String[] args) {

        Transaction transaction = new Transaction("SumitDeo" + " " + "9/11/1988" + " " + "899.99");

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

        public Transaction(String transString) {

            String[] data = transString.split(" ");

            String who = data[0].trim();
            Date when = new Date(data[1].trim());
            double amount = Double.parseDouble(data[2].trim());

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