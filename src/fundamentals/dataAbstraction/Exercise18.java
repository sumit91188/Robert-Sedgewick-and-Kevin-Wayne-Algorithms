package fundamentals.dataAbstraction;

/**
 * @author Sumit Deo
 */
public class Exercise18 {

    public static void main(String[] args) {

        Accumulator accumulator = new Accumulator();
        accumulator.addDataValue(3);
        accumulator.addDataValue(7);
        accumulator.addDataValue(9);

        System.out.printf("Mean: %.3f\n", accumulator.mean());
        System.out.printf("Variance: %.3f\n", accumulator.var());
        System.out.printf("Std Deviation: %.3f\n", accumulator.stddev());
    }

    static class Accumulator {
        private double m;
        private double s;
        private int N;

        public void addDataValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            return s / (N - 1);
        }

        public double stddev() {
            return Math.sqrt(this.var());
        }
    }
}