package fundamentals.unionFind;

import fundamentals.unionFind.util.UnionFind;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.unionFind
 * @date 2/18/21
 * @comment: Do Exercise 1.5.1, but use weighted quick-union
 */
public class Exercise3 {

  public static void main(String[] args) {
    WeightedQuickUnion uf = new WeightedQuickUnion(10);

    uf.union(9, 0);
    System.out.println(uf.getArrayAccessCount());
    uf.printArray();
    System.out.println();

    uf.union(3, 4);
    System.out.println(uf.getArrayAccessCount());
    uf.printArray();
    System.out.println();

    uf.union(5, 8);
    System.out.println(uf.getArrayAccessCount());
    uf.printArray();
    System.out.println();

    uf.union(7, 2);
    System.out.println(uf.getArrayAccessCount());
    uf.printArray();
    System.out.println();

    uf.union(2, 1);
    System.out.println(uf.getArrayAccessCount());
    uf.printArray();
    System.out.println();

    uf.union(5, 7);
    System.out.println(uf.getArrayAccessCount());
    uf.printArray();
    System.out.println();

    uf.union(0, 3);
    System.out.println(uf.getArrayAccessCount());
    uf.printArray();
    System.out.println();

    uf.union(4, 2);
    System.out.println(uf.getArrayAccessCount());
    uf.printArray();
    System.out.println();
  }

  public static class WeightedQuickUnion implements UnionFind {

    private final int[] id;
    private final int[] sz;
    private int count;
    private int arrayAccessCount;

    public WeightedQuickUnion(int N) {
      count = N;
      id = new int[count];
      for (int i = 0; i < count; i++) {
        id[i] = i;
      }

      sz = new int[count];
      for (int i = 0; i < count; i++) {
        sz[i] = 1;
      }
    }

    @Override
    public void union(int p, int q) {
      arrayAccessCount = 0;
      int pId = find(p);
      int qId = find(q);

      if (pId == qId) {
        return;
      }

      if (sz[pId] >= sz[qId]) {
        id[qId] = pId;
        arrayAccessCount++;
        sz[pId] += sz[qId];
      } else {
        id[pId] = qId;
        arrayAccessCount++;
        sz[qId] += sz[pId];
      }
      count--;
    }

    @Override
    public int find(int p) {
      while (p != id[p]) {
        arrayAccessCount++;
        arrayAccessCount++;
        p = id[p];
      }
      arrayAccessCount++;

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

    public int getArrayAccessCount() {
      return arrayAccessCount;
    }

    public void printArray() {
      for (int i = 0; i < id.length; i++) {
        System.out.print(i + " ");
      }
      System.out.println();
      for (int i : id) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
