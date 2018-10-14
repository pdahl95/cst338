package Homework4;
/**
 * Title: Customer.java
 * Abstract: This is the third class of Homework4.
 * Name: Pernille Dahl
 * Date: 2018-Sept-20
 */

public class Customer {

    private String name;
    private int ssn;
    private String address;

    public Customer(String name, int ssn, String address) {
        this.name = name;
        this.ssn = ssn;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + ": " + ssn + ", " + address;
    }
}
