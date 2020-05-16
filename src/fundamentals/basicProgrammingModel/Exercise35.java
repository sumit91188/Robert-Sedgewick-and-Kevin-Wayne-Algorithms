package fundamentals.basicProgrammingModel;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Sumit Deo
 */
public class Exercise35 {

    public static void main(String[] args) {

        double[] result = diceSimulation();

        System.out.println("As per given simulation..");
        for (int i = 2; i < result.length; i++) {
            System.out.format("%.3f\t", result[i]);
        }

        System.out.println();

        //result = diceExperiment(300000);
        //result = diceExperiment(500000);
        //result = diceExperiment(700000);
        //result = diceExperiment(1000000);
        //result = diceExperiment(3000000);
        //result = diceExperiment(6000000);
        result = diceExperiment(9000000);

        System.out.println("As per an experiment..");
        for (int i = 2; i < result.length; i++) {
            System.out.format("%.3f\t", result[i]);
        }
    }

    private static double[] diceSimulation() {

        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i+j] += 1.0;
            }
        }

        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= 36.0;
        }

        return dist;
    }

    private static double[] diceExperiment(int iterations) {

        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];

        for (int i = 1; i <= iterations; i++) {

            int sum = StdRandom.uniform(1, 7) + StdRandom.uniform(1, 7);
            dist[sum]++;
        }

        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= iterations;
        }

        return dist;
    }
}
