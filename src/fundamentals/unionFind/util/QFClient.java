package fundamentals.unionFind.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.unionFind.util
 * @date 2/5/21
 * @comment:
 */
public class QFClient {

  public static void main(String[] args) {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader("resources/largeUF.txt"));
      String line = reader.readLine();
      int N = Integer.parseInt(line);
      QuickFind unionFind = new QuickFind(N);
      line = reader.readLine();
      while (line != null) {
        int p = Integer.parseInt(line.split(" ")[0]);
        int q = Integer.parseInt(line.split(" ")[1]);
        if (unionFind.connected(p, q)) {
          line = reader.readLine();
          continue;
        }
        unionFind.union(p, q);
        System.out.println(p + " " + q);
        line = reader.readLine();
      }
      reader.close();
      System.out.println(unionFind.count() + " components");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
