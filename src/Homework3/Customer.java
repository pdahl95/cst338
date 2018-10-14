/*
 * Title: Customer.java
 * Abstract: This is the second class of Homework3.
 * This file store the instance varaibles of the class Customer.
 * Name: Pernille Dahl
 * Date: 2018-Sept-20
 */

package Homework3;

public class Customer {

    private String name;
    private int pin;
    private double amount;
    private String bank;

    public Customer(String name, int pin, double amount, String bank) {
        this.name = name;
        this.pin = pin;
        this.amount = amount;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPin() {
        return pin;
    }

    public String getBank() {
        return bank;
    }

    public String toString() {
        return "Alice: Balance $" + amount;
    }

}

