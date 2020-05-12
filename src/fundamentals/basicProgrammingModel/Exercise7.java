package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise7 {

    public static void main(String[] args) {

        double t = 9.0;
        int sum = 0;

        //a)
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        System.out.println(t);

        //b)
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);

        //c)
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 10; j++)
                sum++;
        System.out.println(sum);
    }
}
