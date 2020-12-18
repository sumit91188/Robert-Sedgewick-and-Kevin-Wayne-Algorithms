package fundamentals.bagsQueuesStacks;

import fundamentals.bagsQueuesStacks.util.ResizingArrayStack;

/**
 * @author sumitdeo
 * @projectName Robert-Sedgewick-and-Kevin-Wayne-Algorithms
 * @package fundamentals.bagsQueuesStacks
 * @date 12/18/20
 * @comment: Give the output printed by java Stack for the input: it was - the best - of times - - -
 * it was - the - -
 */
public class Exercise2 {

  public static void main(String[] args) {
    String inputString = "it was - the best - of times - - - it was - the - -";

    ResizingArrayStack<String> stack = new ResizingArrayStack<>(10);

    String[] inputs = inputString.split(" ");
    for (String input : inputs) {
      if (input.equals("-")) {
        stack.pop();
      } else {
        stack.push(input);
      }
    }

    System.out.print("The output printed by java Stack for the above input is: ");
    for (String str : stack) {
      System.out.print(str + " ");
    }


  }
}
