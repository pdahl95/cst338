package Lab7;
import java.util.Arrays;

    public class Lab7 {

        private int foo;
        private String name = null;
        private double salary;
        private Lab7[] labs = new Lab7[3];

        Lab7(){
            this(42,"FN-2187", 200.25);
        }

        Lab7(int foo, String name, double salary){
            this.foo = foo;
            this.name = name;
            this.salary = salary;
        }

        public int getFoo() {
            return foo;
        }

        public void setFoo(int foo) {
            this.foo = foo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setLabs(Lab7[] labs) {
            this.labs = labs;
        }

        public static int timesTwo(int x){
            return x*2;
        }

        @Override
        public String toString() {
            return "Lab07{" +
                    "foo=" + foo +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", labs=" + Arrays.toString(labs) +
                    '}';
        }

        public Lab7 clone(){
            Lab7 cloneLab = new Lab7(this.foo,this.name,this.salary);
            cloneLab.setLabs(labs);
            return cloneLab;
        }
    }

