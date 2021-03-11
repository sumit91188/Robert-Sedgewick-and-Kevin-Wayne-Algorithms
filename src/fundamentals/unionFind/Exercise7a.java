package fundamentals.unionFind;

import fundamentals.unionFind.util.UnionFind;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.unionFind
 * @date 3/11/21
 * @comment: QuickUnionUF
 */
public class Exercise7a {

  public static void main(String[] args) {
    QuickUnionUF uf = new QuickUnionUF(10);
    uf.union(0, 9);
    uf.union(1, 8);
    uf.union(2, 7);
    uf.union(3, 6);
    uf.union(0, 3);

    System.out.println(uf.connected(9, 6));
  }

  private static class QuickUnionUF implements UnionFind {

    private final int[] id;
    private int count;

    public QuickUnionUF(int N) {
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

      id[pId] = qId;
      count--;
    }

    @Override
    public int find(int p) {
      while (p != id[p]) {
        p = id[p];
      }

      return p;
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
