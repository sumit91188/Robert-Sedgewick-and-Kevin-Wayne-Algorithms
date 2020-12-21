package fundamentals.bagsQueuesStacks;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import java.util.Date;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/21/20
 * @comment: Using readInts() on page 126 as a model, write a static method readDates() for Date
 * that reads dates from standard input in the format specified in the table on page 119 and returns
 * an array containing them.
 */
public class Exercise16 {

  public static void main(String[] args) {
    String dateFilePath = args[0];
    Date[] dates = readAllDates(dateFilePath);

    for (Date date : dates) {
      System.out.print(date + " ");
    }
  }

  private static Date[] readAllDates(String dateFilePath) {
    In in = new In(dateFilePath);
    Queue<Date> q = new Queue<Date>();
    while (!in.isEmpty()) {
      q.enqueue(new Date(in.readString()));
    }
    int N = q.size();
    Date[] a = new Date[N];
    for (int i = 0; i < N; i++) {
      a[i] = q.dequeue();
    }
    return a;
  }
}
