package fundamentals.analysisOfAlgorithm;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/16/21
 * @comment: Add an instance method howMany() to StaticSETofInts (page 99) that finds the number of
 * occurrences of a given key in time proportional to log N in the worst case.
 */
public class Exercise11 {

  public static void main(String[] args) {
    int[] array = {2, 4, 8, 16, 16, 16, 32, 64, 128, 128};
    StaticSETofInts staticSETofInts = new StaticSETofInts(array);

    StdOut.println("How many 2: " + staticSETofInts.howMany(2) + " Expected: 1");
    StdOut.println("How many 16: " + staticSETofInts.howMany(16) + " Expected: 3");
    StdOut.println("How many 128: " + staticSETofInts.howMany(128) + " Expected: 2");
    StdOut.println("How many -99: " + staticSETofInts.howMany(-99) + " Expected: 0");
  }

  private static class StaticSETofInts {

    private final int[] a;

    public StaticSETofInts(int[] keys) {
      a = new int[keys.length];
      for (int i = 0; i < keys.length; i++) {
        a[i] = keys[i]; // defensive copy
      }
      Arrays.sort(a);
    }

    public boolean contains(int key) {
      return rank(key) != -1;
    }

    private int rank(int key) { // Binary search.
      int lo = 0;
      int hi = a.length - 1;
      while (lo <= hi) { // Key is in a[lo..hi] or not present.
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
          hi = mid - 1;
        } else if (key > a[mid]) {
          lo = mid + 1;
        } else {
          return mid;
        }
      }
      return -1;
    }

    private int rankRecursive(int key, int lo, int hi) {
      if (lo > hi) {
        return -1;
      }

      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        return rankRecursive(key, lo, mid - 1);
      } else if (key > a[mid]) {
        return rankRecursive(key, mid + 1, hi);
      } else {
        return mid;
      }
    }

    public int howMany(int key) {
      int count;
      int currentRank = rank(key);
      int lowRank = currentRank;
      int currentLowRank = currentRank;
      int highRank = currentRank;
      int currentHighRank = currentRank;

      if (currentRank == -1) {
        return 0;
      }

      while (currentLowRank != -1) {
        lowRank = currentLowRank;
        currentLowRank = rankRecursive(key, 0, lowRank - 1);
      }

      while (currentHighRank != -1) {
        highRank = currentHighRank;
        currentHighRank = rankRecursive(key, highRank + 1, a.length - 1);
      }

      count = highRank - lowRank + 1;

      return count;
    }
  }
}
