package fundamentals.dataAbstraction;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Sumit Deo
 */
public class Exercise10 {

    public static void main(String[] args) {

        VisualCounter visualCounter = new VisualCounter(10, 8);
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.decrement();
        visualCounter.increment();
        visualCounter.decrement();
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.decrement();
        visualCounter.decrement();
    }
}

class VisualCounter {

    private int n;
    private int max;
    int operationsTally;
    int countTally;

    public VisualCounter(int n, int max) {
        this.n = n;
        this.max = max;

        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(.015);
        StdDraw.setXscale(0, n+1);
        StdDraw.setYscale(-max-3, max+3);
    }

    void increment() {

        if (operationsTally <= n && countTally <= max) {
            operationsTally++;
            countTally++;
        }
        plotChart();
    }

    void decrement() {

        if (operationsTally <= n) {
            operationsTally++;
            countTally--;
        }
        plotChart();
    }

    private void plotChart() {

        StdDraw.point(operationsTally, countTally);
    }
}