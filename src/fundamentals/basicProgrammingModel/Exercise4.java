package fundamentals.basicProgrammingModel;

/**
 * @author Sumit Deo
 */
public class Exercise4 {

    public static void main(String[] args) {

        int a = 0;
        int b = 1;
        int c;

        //a.if (a > b) then c = 0;  Compilation Error: Cannot resolve symbol 'then'
        //b.if a > b { c = 0; } Compilation Error: '(' expected
        //c.
        if (a > b) c = 0;   /*No Compilation Error*/
        //d.if (a > b) c = 0 else b = 0;    Compilation Error: ';' expected
    }
}
