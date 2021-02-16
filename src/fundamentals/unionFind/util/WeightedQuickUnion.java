package fundamentals.unionFind.util;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.unionFind.util
 * @date 2/10/21
 * @comment:
 */
public class WeightedQuickUnion implements UnionFind {

  private final int[] id;
  private final int[] sz;
  private int count;

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
    int pId = find(p);
    int qId = find(q);

    if (pId == qId) {
      return;
    }

    if (sz[pId] >= sz[qId]) {
      id[qId] = pId;
      sz[pId] += sz[qId];
    } else {
      id[pId] = qId;
      sz[qId] += sz[pId];
    }
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
