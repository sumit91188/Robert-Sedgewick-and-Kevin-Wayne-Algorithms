package fundamentals.unionFind.util;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.unionFind.util
 * @date 2/5/21
 * @comment:
 */
public interface UnionFind {

  void union(int p, int q);

  int find(int p);

  boolean connected(int p, int q);

  int count();
}
