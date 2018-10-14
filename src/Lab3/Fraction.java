/*
 * Title: Fraction.java
 * Abstract: This is Lab3. This is a class called function. This class has a few different functions like, add, negate,
 * invert, equals and to String
 * Name: Pernille Dahl
 * Date: 2018-Sept-20
 */
package Lab3;

public class Fraction {

    private int numerator;
    private int denominator;
    private Fraction answer;

    // No arg consturctor
    public Fraction(Fraction f) {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int num, int den)  {
        numerator = num;
        denominator = den;
    }

    public Fraction add(Fraction f) {
    // Sum formula: a/b + c/d = (ad + cb)/bd
        int a = this.numerator;
        int b = this.denominator;
        int c = f.numerator;
        int d = f.denominator;
        if(b == d) {
            return new Fraction(a + c, b);
        }
        return new Fraction(a * d + c * b, b * d);
    }

    public void negate() {
        numerator *= -1;
    }

    public void invert() {
        int temp = numerator;
        numerator = denominator;
        denominator = temp;
        if (denominator < 0){
            denominator *= 1;
        }

    }
    public boolean equals(Fraction f) {
        boolean answer = false;

        if(numerator == f.numerator && denominator == f.denominator){
            answer = true;
        }
        return answer;
    }

//    public String toDouble() {
//
//    }

    public String toString(){
        return (Integer.toString( numerator ) + "/" + Integer.toString( denominator ));
    }


}
