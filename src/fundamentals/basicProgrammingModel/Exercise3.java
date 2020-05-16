package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise3 {

    public static void main(String[] args) {

        int[] inputArray = new int[3];
        boolean didCatchAnException = false;

        for (int i = 0; i < inputArray.length; i++) {
            try {
                inputArray[i] = Integer.parseInt(args[i].trim());
            }
            catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: Input needs to be integer.");
                nfe.printStackTrace();
                didCatchAnException = true;
                break;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                System.out.println("ArrayIndexOutOfBoundsException: Needs at least 3 int inputs");
                arrayIndexOutOfBoundsException.printStackTrace();
                didCatchAnException = true;
                break;
            }
        }

        if(didCatchAnException) {
            System.out.println("Above exception was thrown, please check your inputs.");
        }
        else {
            if (inputArray[0] == inputArray[1] && inputArray[1] == inputArray[2]) {
                System.out.println("equal");
            }
            else {
                System.out.println("not equal");
            }
        }
    }
}
