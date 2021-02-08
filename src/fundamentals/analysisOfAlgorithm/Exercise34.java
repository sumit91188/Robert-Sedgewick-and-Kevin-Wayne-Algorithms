package fundamentals.analysisOfAlgorithm;

import java.util.Scanner;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.analysisOfAlgorithm
 * @date 2/2/21
 * @comment: Hot or cold. Your goal is to guess a secret integer between 1 and N. You repeatedly
 * guess integers between 1 and N. After each guess you learn if your guess equals the secret
 * integer (and the game stops). Otherwise, you learn if the guess is hotter (closer to) or colder
 * (farther from) the secret number than your previous guess. Design an algorithm that finds the
 * secret number in at most ~2 lg N guesses. Then design an algorithm that finds the secret number
 * in at most ~ 1 lg N guesses.
 */
public class Exercise34 {

  public static void main(String[] args) {
    System.out.print("Guess a number -");
    Scanner myInput = new Scanner(System.in);
    int guess = myInput.nextInt();
    hotOrCold(32, guess);
  }

  private static void hotOrCold(int secretNum, int guess) {
    boolean found = hotOrCold(secretNum, guess, -1);

    while (!found) {

    }
  }

  private static boolean hotOrCold(int secretNum, int guess, int previousGuess) {
    return true;
  }
}
