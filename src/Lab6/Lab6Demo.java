package Lab6;
import java.util.*;

public class Lab6Demo {
    public static void main(String[] args) {
        ArrayList<Customer> list = new ArrayList<>();
        CustomerData.load(list);
        Iterator<Customer> it = list.iterator();

        double balance  = 0;

        while(it.hasNext()){
            Customer c = it.next();
            balance += c.getBalance();
        }
        System.out.println("Total Balance is $" + balance);

        ListIterator<Customer> forwards = list.listIterator();
        System.out.println("Customer printed in forward:");
        while (forwards.hasNext()){
            Customer c = forwards.next();
            System.out.println(c.getName());
        }
        int sizeOfList = list.size();
        ListIterator<Customer> backwards = list.listIterator(sizeOfList);
        System.out.println("Customer printed in reverse:");
        while(backwards.hasPrevious()){
            Customer c = backwards.previous();
            System.out.println(c.getName());
        }

    }
}
