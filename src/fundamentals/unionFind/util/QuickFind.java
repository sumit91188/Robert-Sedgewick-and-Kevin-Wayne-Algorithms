package fundamentals.unionFind.util;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.unionFind.util
 * @date 2/5/21
 * @comment:
 */
public class QuickFind implements UnionFind {

  private final int[] id;
  private int count;

  public QuickFind(int N) {
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
