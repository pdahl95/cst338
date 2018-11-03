package Homework5;
/**
 * Title: Customer.java
 * Abstract: Customer file to access and get the name of the customer, and the id attach to each customer.
 * Name: Pernille Dahl
 * Date: 2018-Nov-2
 */

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
