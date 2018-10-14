package Homework4;
/**
 * Title: Account.java
 * Abstract: This is the second class of Homework4.
 * Name: Pernille Dahl
 * Date: 2018-Sept-20
 */

public class Account {

    private int accNum;
    private int accType;
    private int customerSsn;
    private double balance;

    public Account(int accNum, int accType, int customerSsn, double balance) {
        this.accNum = accNum;
        this.accType = accType;
        this.customerSsn = customerSsn;
        this.balance = balance;
    }

    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public int getAccType() {
        return accType;
    }

    public void setAccType(int accType) {
        this.accType = accType;
    }

    public int getCustomerSsn() {
        return customerSsn;
    }

    public void setCustomerSsn(int customerSsn) {
        this.customerSsn = customerSsn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public  String toString(){
        String accType;
        if(this.accType == 1){
            accType = "Checking Account";
        }else {
            accType = "Saving Account";
        }
        return "Account Info: Account Number: " + accNum + "\n" + accType + "\n" + "Balalce: $" + String.format( "%.2f", balance );
    }
}
