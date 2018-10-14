package Lab6;

import java.util.ArrayList;
public class CustomerData {

    private static Customer[] customers = {
            new Customer("Alice", 1234, 5000, "OtterUnion"),
            new Customer("Chris", 8787, 10, "OtterUnion"),
            new Customer("Jane", 2222, 500, "OtterUnion"),
            new Customer("John", 8000, 500, "OtterUnion"),
            new Customer("Michael", 7777, 0, "OtterUnion"),
            new Customer("Monica", 3000, 50, "OtterUnion"),
            new Customer("Owen", 4455, 50, "OtterUnion"),
            new Customer("Rebecca", 8080, 555.55, "OtterUnion"),
            new Customer("Robert", 2323, 200, "OtterUnion"),
            new Customer("Tom", 2000, 200, "OtterUnion")
    };

    public static void load(ArrayList<Customer> list) {
        for (Customer c: customers) {
            list.add(c);
        }
    }
}
