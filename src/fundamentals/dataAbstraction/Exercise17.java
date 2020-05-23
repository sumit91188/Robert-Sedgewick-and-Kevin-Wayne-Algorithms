package fundamentals.dataAbstraction;

/**
 * @author Sumit Deo
 */
public class Exercise17 {

    public static void main(String[] args) {

        Rational zero = new Rational(0, 10);
        Rational rational1 = new Rational(5, 10);
        Rational rational2 = new Rational(3, 18);
        Rational rationalMax = new Rational(Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
        Rational result;

        System.out.println("testing constructor(infinite Rational)..");
        try {
            new Rational(10, 0);
        }
        catch (ArithmeticException ae) {
            System.out.println(ae.getMessage() + "\n");
        }

        System.out.println("testing 'plus' functionality for " + rational1.toString() + " & " + rational2.toString());
        result = rational1.plus(rational2);
        System.out.println(result.toString() + "\n");

        System.out.println("testing 'plus' functionality for " + zero.toString() + " & " + rational2.toString());
        result = zero.plus(rational2);
        System.out.println(result.toString() + "\n");

        System.out.println("testing 'minus' functionality for " + rational1.toString() + " & " + rational2.toString());
        result = rational1.minus(rational2);
        System.out.println(result.toString() + "\n");

        System.out.println("testing 'minus' functionality for " + zero.toString() + " & " + rational2.toString());
        result = zero.minus(rational2);
        System.out.println(result.toString() + "\n");

        System.out.println("testing 'times' functionality for " + rational1.toString() + " & " + rational2.toString());
        result = rational1.times(rational2);
        System.out.println(result.toString() + "\n");

        System.out.println("testing 'times' functionality for " + zero.toString() + " & " + rational2.toString());
        result = zero.times(rational2);
        System.out.println(result.toString() + "\n");

        System.out.println("testing 'divides' functionality for " + rational1.toString() + " & " + rational2.toString());
        result = rational1.divides(rational2);
        System.out.println(result.toString() + "\n");

        System.out.println("testing 'divides' functionality for " + zero.toString() + " & " + rational2.toString());
        result = zero.divides(rational2);
        System.out.println(result.toString() + "\n");

        System.out.println("testing 'divides' functionality for " + rational1.toString() + " & " + zero.toString());
        try {
            rational1.divides(zero);
        }
        catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        }

        //run to enable assertions: java –ea Exercise17
        System.out.println("testing immunity to overflow for 'plus' functionality for " + rational1.toString() + " & " + rationalMax.toString());
        try {
            rational1.plus(rationalMax);
        }
        catch (AssertionError ae) {
            System.out.println(ae.getMessage() + "\n");
        }

        System.out.println("testing immunity to overflow for 'minus' functionality for " + rational1.toString() + " & " + rationalMax.toString());
        try {
            rational1.minus(rationalMax);
        }
        catch (AssertionError ae) {
            System.out.println(ae.getMessage() + "\n");
        }

        System.out.println("testing immunity to overflow for 'times' functionality for " + rational1.toString() + " & " + rationalMax.toString());
        try {
            rational1.times(rationalMax);
        }
        catch (AssertionError ae) {
            System.out.println(ae.getMessage() + "\n");
        }

        System.out.println("testing immunity to overflow for 'divides' functionality for " + rational1.toString() + " & " + rationalMax.toString());
        try {
            rational1.divides(rationalMax);
        }
        catch (AssertionError ae) {
            System.out.println(ae.getMessage() + "\n");
        }
    }

    static class Rational implements Comparable<Rational> {

        private static Rational zero = new Rational(0, 1);

        private long numerator;
        private long denominator;

        public Rational(int numerator, int denominator) {

            if (denominator == 0) {
                throw new ArithmeticException("denominator is zero");
            }

            int gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;

            if (denominator < 0 && numerator < 0) {
                this.numerator = -this.numerator;
                this.denominator = -this.denominator;
            }
        }

        private static int gcd(int numerator, int denominator) {

            if (numerator < 0) {
                numerator = - numerator;
            }

            if (denominator < 0) {
                denominator = - denominator;
            }

            if (denominator == 0) {
                return numerator;
            }
            else {
                return gcd(denominator, numerator % denominator);
            }
        }

        private Rational negate(Rational that) {
            return new Rational(- (int)that.numerator, (int)that.denominator);
        }

        private Rational plus(Rational that) {

            if (this.compareTo(zero) == 0) {
                return that;
            }

            if (that.compareTo(zero) == 0) {
                return this;
            }

            assert this.numerator * that.denominator <= Integer.MAX_VALUE : "Overflow will be caused";
            assert this.denominator * that.numerator <= Integer.MAX_VALUE : "Overflow will be caused";
            assert this.denominator * that.denominator <= Integer.MAX_VALUE : "Overflow will be caused";

            long numerator = this.numerator * that.denominator + this.denominator * that.numerator;
            long denominator = this.denominator * that.denominator;

            return new Rational((int)numerator, (int)denominator);
        }

        private Rational minus(Rational that) {

            return this.plus(negate(that));
        }

        private Rational times(Rational that) {

            if (this.compareTo(zero) == 0 || that.compareTo(zero) == 0) {
                return zero;
            }
            else {

                assert this.numerator * that.numerator <= Integer.MAX_VALUE : "Overflow will be caused";
                assert this.denominator * that.denominator <= Integer.MAX_VALUE : "Overflow will be caused";

                return new Rational((int)(this.numerator * that.numerator),
                        (int)(this.denominator * that.denominator));
            }
        }

        private Rational divides(Rational that) {

            if (this.compareTo(zero) == 0) {
                return zero;
            }
            else if (that.compareTo(zero) == 0) {
                throw new ArithmeticException("division by zero");
            }
            else {

                assert this.numerator * that.denominator <= Integer.MAX_VALUE : "Overflow will be caused";
                assert this.denominator * that.numerator <= Integer.MAX_VALUE : "Overflow will be caused";

                return new Rational((int)(this.numerator * that.denominator),
                        (int)(this.denominator * that.numerator));
            }
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) return true;
            if (that == null || getClass() != that.getClass()) return false;

            Rational rational = (Rational) that;

            if (numerator != rational.numerator) return false;
            return denominator == rational.denominator;
        }

        @Override
        public String toString() {
            String result;
            if (denominator == 1) {
                result = numerator + "";
            }
            else {
                result = numerator + "/" + denominator;
            }
            return "Rational{" +
                    "numerator=" + numerator +
                    ", denominator=" + denominator +
                    ", rational=" + result +
                    '}';
        }

        @Override
        public int compareTo(Rational that) {

            assert this.numerator * that.denominator <= Integer.MAX_VALUE : "Overflow will be caused";
            assert this.denominator * that.numerator <= Integer.MAX_VALUE : "Overflow will be caused";

            long lhs = this.numerator * that.denominator;
            long rhs = this.denominator * that.numerator;

            if (lhs < rhs) {
                return -1;
            }
            else if (lhs > rhs) {
                return 1;
            }
            return 0;
        }
    }
}