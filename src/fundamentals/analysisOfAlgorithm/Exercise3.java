package fundamentals.analysisOfAlgorithm;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 1/14/21
 * @comment: Modify DoublingTest to use StdDraw to produce plots like the standard and log-log plots
 * in the text, rescaling as necessary so that the plot always fills a substantial portion of the
 * window.
 */
public class Exercise3 {

  private static List<Point2D> standardPlotPoints;
  private static List<Point2D> logLogPlotPoints;
  private static int currentXMaxScale;
  private static int currentYMaxScale;

  public static void main(String[] args) {

    currentXMaxScale = 50;
    currentYMaxScale = 5;
    initializeCanvas(currentXMaxScale, currentYMaxScale);

    standardPlotPoints = new ArrayList<>(5);
    logLogPlotPoints = new ArrayList<>(5);

    for (int N = 250; true; N += N) { // Print time for problem size N.
      double time = timeTrial(N);

      rescaleIfNecessary(N, time);
      drawPointAndLine(N, time, standardPlotPoints, true, false);
      drawPointAndLine(Math.log(N), Math.log(time), logLogPlotPoints, false, false);

      StdOut.printf("%7d %5.1f\n", N, time);
    }
  }

  public static double timeTrial(int N) { // Time ThreeSum.count() for N random 6-digit ints.
    int MAX = 1000000;
    int[] a = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = StdRandom.uniform(-MAX, MAX);
    }
    Stopwatch timer = new Stopwatch();
    int cnt = ThreeSum.count(a);
    return timer.elapsedTime();
  }

  private static void initializeCanvas(int currentXMaxScale, int currentYMaxScale) {
    StdDraw.setCanvasSize(300, 300);
    StdDraw.setXscale(0, currentXMaxScale);
    StdDraw.setYscale(0, currentYMaxScale);
    StdDraw.setPenRadius(.005);
  }

  private static void rescaleIfNecessary(int n, double time) {
    if (n > currentXMaxScale || time > currentYMaxScale) {
      if (n > currentXMaxScale) {
        if (currentXMaxScale * 2 > n) {
          currentXMaxScale = currentXMaxScale * 2;
        } else {
          currentXMaxScale = (int) (1.5 * n);
        }
      }
      if (time > currentYMaxScale) {
        currentYMaxScale = currentYMaxScale * 2;
      }

      rescaleCanvas();
    }
  }

  private static void rescaleCanvas() {
    StdDraw.clear();

    StdDraw.setXscale(0, currentXMaxScale);
    StdDraw.setYscale(0, currentYMaxScale);

    //Redraw plot points and lines

    for (int i = 0; i < standardPlotPoints.size(); i++) {
      drawPointAndLine(standardPlotPoints.get(i).x(), standardPlotPoints.get(i).y(),
          standardPlotPoints, true, true);
    }

    for (int i = 0; i < logLogPlotPoints.size(); i++) {
      drawPointAndLine(logLogPlotPoints.get(i).x(), logLogPlotPoints.get(i).y(), logLogPlotPoints,
          false, true);
    }
  }

  private static void drawPointAndLine(double x, double y, List<Point2D> pointList,
      boolean isStandard, boolean isRescale) {

    if (y == Double.NEGATIVE_INFINITY) {
      y = 0;
    }

    Point2D point = new Point2D(x, y);
    if (!isRescale) {
      pointList.add(point);
    }

    if (isStandard) {
      StdDraw.setPenColor(Color.BLUE);
    } else {
      StdDraw.setPenColor(Color.GREEN);
    }

    if (pointList.size() > 1) {
      Point2D previousPoint = pointList.get(pointList.size() - 2);
      StdDraw.line(previousPoint.x(), previousPoint.y(), point.x(), point.y());
    }

    StdDraw.point(x, y);
  }
}
