package fundamentals.unionFind;

import fundamentals.unionFind.util.UnionFind;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.unionFind
 * @date 2/5/21
 * @comment: Show the contents of the id[] array and the number of times the array is accessed for
 * each input pair when you use quick-find for the sequence 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2.
 */
public class Exercise1 {

  public static void main(String[] args) {
    QuickFind quickFind = new QuickFind(10);

    quickFind.union(9, 0);
    System.out.println(quickFind.getArrayAccessCount());
    quickFind.printArray();
    System.out.println();

    quickFind.union(3, 4);
    System.out.println(quickFind.getArrayAccessCount());
    quickFind.printArray();
    System.out.println();

    quickFind.union(5, 8);
    System.out.println(quickFind.getArrayAccessCount());
    quickFind.printArray();
    System.out.println();

    quickFind.union(7, 2);
    System.out.println(quickFind.getArrayAccessCount());
    quickFind.printArray();
    System.out.println();

    quickFind.union(2, 1);
    System.out.println(quickFind.getArrayAccessCount());
    quickFind.printArray();
    System.out.println();

    quickFind.union(5, 7);
    System.out.println(quickFind.getArrayAccessCount());
    quickFind.printArray();
    System.out.println();

    quickFind.union(0, 3);
    System.out.println(quickFind.getArrayAccessCount());
    quickFind.printArray();
    System.out.println();

    quickFind.union(4, 2);
    System.out.println(quickFind.getArrayAccessCount());
    quickFind.printArray();
    System.out.println();
  }

  public static class QuickFind implements UnionFind {

    private final int[] id;
    private int count;
    private int arrayAccessCount;

    public QuickFind(int N) {
      count = N;
      id = new int[count];
      for (int i = 0; i < count; i++) {
        id[i] = i;
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

      for (int i = 0; i < id.length; i++) {
        arrayAccessCount++;
        if (id[i] == pId) {
          arrayAccessCount++;
          id[i] = qId;
        }
      }
      count--;
    }

    @Override
    public int find(int p) {
      arrayAccessCount++;
      return id[p];
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

/*
Solution:
    13
    0 1 2 3 4 5 6 7 8 9
    0 1 2 3 4 5 6 7 8 0

    13
    0 1 2 3 4 5 6 7 8 9
    0 1 2 4 4 5 6 7 8 0

    13
    0 1 2 3 4 5 6 7 8 9
    0 1 2 4 4 8 6 7 8 0

    13
    0 1 2 3 4 5 6 7 8 9
    0 1 2 4 4 8 6 2 8 0

    14
    0 1 2 3 4 5 6 7 8 9
    0 1 1 4 4 8 6 1 8 0

    14
    0 1 2 3 4 5 6 7 8 9
    0 1 1 4 4 1 6 1 1 0

    14
    0 1 2 3 4 5 6 7 8 9
    4 1 1 4 4 1 6 1 1 4

    16
    0 1 2 3 4 5 6 7 8 9
    1 1 1 1 1 1 6 1 1 1
*/
