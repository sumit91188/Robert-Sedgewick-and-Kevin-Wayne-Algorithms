package fundamentals.bagsQueuesStacks;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Transaction;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/21/20
 * @comment: Do Exercise 1.3.16 for Transaction.
 */
public class Exercise17 {

  public static void main(String[] args) {
    String transactionFilePath = args[0];
    Transaction[] transactions = readAllTransactions(transactionFilePath);

    for (Transaction transaction : transactions) {
      System.out.print(transaction + " ");
    }
  }

  private static Transaction[] readAllTransactions(String transactionFilePath) {
    In in = new In(transactionFilePath);
    Queue<Transaction> q = new Queue<Transaction>();
    while (!in.isEmpty()) {
      q.enqueue(new Transaction(in.readString()));
    }
    int N = q.size();
    Transaction[] a = new Transaction[N];
    for (int i = 0; i < N; i++) {
      a[i] = q.dequeue();
    }
    return a;
  }
}
