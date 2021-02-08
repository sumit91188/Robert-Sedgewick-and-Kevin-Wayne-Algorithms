package fundamentals.unionFind.util;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.unionFind.util
 * @date 2/8/21
 * @comment:
 */
public class QuickUnion implements UnionFind {

  private final int[] id;
  private int count;

  public QuickUnion(int N) {
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
