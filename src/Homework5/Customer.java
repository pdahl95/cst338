package Homework5;

public class Customer {

    private String customerName;
    private int customerNumber; // should randomly assign a unique number between 100-300

    public Customer(String name, int customerNumber) {
        this.customerName = name;
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return customerName;
    }

    public void setName(String name) {
        this.customerName = name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
}
