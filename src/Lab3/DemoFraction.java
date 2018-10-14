package Lab3;

public class DemoFraction {
    public static void main(String[] args) throws IllegalAccessException {
        Fraction f = new Fraction(4,5);
        System.out.println("Test of toString for fraction 4/5 is "+ f);

        Fraction a = new Fraction(2,3);
        Fraction b = new Fraction(3, 5);
        Fraction c = a.add(b);
        System.out.print("a= "+a);
        System.out.println(" b= "+b);
        System.out.println("result of a + b = "+c);

        f.negate();
        System.out.println("Project1.test of negate. "+f);

        f.negate();
        Fraction g = new Fraction(32,40);
        Fraction h = new Fraction(31, 41);
        System.out.println("Project1.test of equals "+f+" equals "+g+" is "+ (f.equals(g))+" should be true.");
        System.out.println("Project1.test of equals "+f+" equals "+h+" is "+ (f.equals(h))+" should be false.");

        f.invert();
        System.out.println("Project1.test of invert. "+f);
//        System.out.println("Project1.test of toDouble.  "+ f.toDouble());

    }
}


