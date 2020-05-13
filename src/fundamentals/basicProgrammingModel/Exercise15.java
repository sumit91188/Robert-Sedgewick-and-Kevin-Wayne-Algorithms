package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise15 {

    public static void main(String[] args) {

        int[] ints = {1,2,3,2,3,2,8,9};
        int num = 10;

        int [] resultArray = getHistogram(ints, num);

        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }

    private static int[] getHistogram(int[] ints, int num) {

        int[] resultArray = new int[num];
        for (int i = 0; i < num; i++) {
            int count = 0;
            for (int j = 0; j < ints.length; j++) {
                if (i == ints[j]) {
                    count++;
                }
            }
            resultArray[i] = count;
        }
        return resultArray;
    }

}
