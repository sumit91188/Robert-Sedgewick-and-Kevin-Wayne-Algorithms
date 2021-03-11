package fundamentals.unionFind;

import fundamentals.unionFind.util.UnionFind;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.unionFind
 * @date 3/11/21
 * @comment: QuickFindUF
 */
public class Exercise7b {

  public static void main(String[] args) {
    QuickFindUF uf = new QuickFindUF(10);
    uf.union(0, 9);
    uf.union(1, 8);
    uf.union(2, 7);
    uf.union(3, 6);
    uf.union(0, 3);

    System.out.println(uf.connected(9, 6));
  }

  private static class QuickFindUF implements UnionFind {

    private final int[] id;
    private int count;

    public QuickFindUF(int N) {
      count = N;
      id = new int[count];
      for (int i = 0; i < count; i++) {
        id[i] = i;
      }
    }

    @Override
    public void union(int p, int q) {
      int pId = find(p);
      int qId = find(q);

      if (pId == qId) {
        return;
      }

      for (int i = 0; i < id.length; i++) {
        if (id[i] == pId) {
          id[i] = qId;
        }
      }
      count--;
    }

    @Override
    public int find(int p) {
      return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
      return find(p) == find(q);
    }

    @Override
    public int count() {
      return count;
    }
  }
}
