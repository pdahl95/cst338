/*
 * Title: ATM.java
 * Abstract: This is one class of Homework3.
 * This is a class called function. This class has a few different functions like,
 * add, negate, invert, equals and to String
 * Name: Pernille Dahl
 * Date: 2018-Sept-20
 */
package Homework3;

import java.util.ArrayList;

public class ATM {

    // TODO: make location as UNKOWN IN THE BEGINNING
    // TODO: Show and print out Alice: Balance $4990.00

    private int serialNum;
    private String bankName;
    private String location;
    private double balance = 100.00;

    public int numTransaction = 0;
    public int numTransfer = 0;
    public int numDeposits = 0;
    public int numWithdrawal = 0;

    public int withDrawGood = 0;
    public int withDrawBad = 0;
    public int depositGood = 0;
    public int depositBad = 0;
    public int transferGood = 0;
    public int transferBad = 0;


    private static ArrayList<Customer> list;

    private void loadData() {
        list = new ArrayList<>();
        list.add( new Customer( "Alice", 1234, 5000.00, "OtterUnion" ) );
        list.add( new Customer( "Tom", 2000, 200.00, "OtterUnion" ) );
        list.add( new Customer( "Monica", 3000, 50.00, "OtterUnion" ) );
        list.add( new Customer( "Michael", 7777, 0.00, "OtterUnion" ) );
        list.add( new Customer( "John", 8000, 500.00, "OtterUnion" ) );
        list.add( new Customer( "Jane", 2222, 500.00, "OtterUnion" ) );
        list.add( new Customer( "Robert", 2323, 200.00, "BOA" ) );
        list.add( new Customer( "Owen", 4455, 50.00, "BOA" ) );
        list.add( new Customer( "Chris", 8787, 10.00, "BOA" ) );
        list.add( new Customer( "Rebecca", 1234, 5000.00, "BOA" ) );
    }

    public ATM(int serialNum, String bankName, String location) {
        loadData();
        this.serialNum = serialNum;
        this.bankName = bankName;
        this.location = location;
    }

    public ATM(String bankName) {
        loadData();
        this.bankName = bankName;
    }

    public void setATM(int serialNum, String location) {
        this.serialNum = serialNum;
        this.location = location;
    }

    public void addFund(double amount) {
        this.balance += amount;
    }

    public void displayMenu() {
        System.out.println( "===== ATM Transaction Menu =====" );
        System.out.println( "\t1. Withdrawal" );
        System.out.println( "\t2. Deposit" );
        System.out.println( "\t2. Transfer" );
        System.out.println();
    }

    public void badWithdrawalMessage(){
        System.out.println("Fail - withdrawal" );
    }

    public boolean withdrawal(String cusName, int pin, double amount) {
        numTransaction += 1;
        numWithdrawal += 1;
        Customer c = getCustomerVerify( cusName, pin );
        if (c == null){
            withDrawBad += 1;
            badWithdrawalMessage();
            return false;
        }
        if(c.getBank() != bankName  ){
            badWithdrawalMessage();
            withDrawBad += 1;
            return false;
        }
        if (balance <= amount ){
            withDrawBad += 1;
            badWithdrawalMessage();
            return false;

        }
        if(c != null && c.getAmount() > amount){
            c.setAmount( c.getAmount() - amount );
            this.balance -= amount;
            System.out.println( "Succeed - withdrawal" );
            withDrawGood += 1;
            return true;
        }
        return false;
    }

    public static Customer getCustomerVerify(String name, int pin) {
        for (Customer c : list) {
            if ( c.getName().equals( name ) && c.getPin() == pin ) {
                return c;
            }
        }
        return null;
    }

    public boolean deposit(String name, int pin, double amountDep) {
        numTransaction += 1;
        numDeposits += 1;
        Customer c = getCustomerVerify( name, pin );
        if ( c == null ) {
            System.out.println( "Fail - Deposit" );
            depositBad += 1;
            return false;
        }
            c.setAmount( c.getAmount() + amountDep );
            this.balance += amountDep;
            System.out.println( "Succeed - Deposit" );
            depositGood += 1;
            return true;

    }
    public void badTransferMessage(){
        System.out.println("Fail - Transfer");
    }

    public boolean transfer(String name1, int pin, double amount, String name2, int pin2) {
        numTransaction += 1;
        numTransfer += 1;
        Customer c = getCustomerVerify( name1, pin );
        Customer c2 = getCustomerVerify( name2, pin2 );
        if ( c == null && c2 == null ) {
            badTransferMessage();
            transferBad += 1;
            return false;
        } else if( !c.getBank().equals( c2.getBank() ) ){
            badTransferMessage();
            transferBad += 1;
            return false;
        }else {
            if(c != null){
                c.setAmount( c.getAmount() - amount);
                c2.setAmount( c2.getAmount() + amount );
                System.out.println( "Succeed - Transfer" );
                transferGood += 1;
                return true;
            }
        }

        return false;
    }


    public void status() {
        System.out.println( "Serial Number: " + serialNum + "\n" + "Bank Name: " + bankName + "\n" + "Location: "
                + location + "\n" + "Balance: " + String.format( "%.2f", balance ) );
        System.out.println( numTransaction + " Transactions so far: " );
        System.out.println( "\tWithdrawal: " + numWithdrawal + " (" + withDrawGood + " success, " + withDrawBad + " fail)\n"
                + "\tDeposit: " + numDeposits + " (" + depositGood + " success, " + depositBad + " fail) \n"
                + "\tTransfer: " + numTransfer + " (" + transferGood + " success, " + transferBad + " fail) \n" );

    }

    public boolean isCustomer(String name) {
            if(getCustomer(name ).equals( name )){
                return  true;
            }
        return false;
    }

    public static Customer getCustomerHelper(String name) {
        for (Customer c : list) {
            if ( c.getName().equals( name )) {
                return c;
            }
        }
        return null;
    }
    // TODO: check why does not work
    public String getCustomer(String name) {
        // get the correct customer and return the current balance
        Customer c = getCustomerHelper(name);
        if( c == null){
            return null;
        }
        return c.getName() + ": " + "Balance $" + c.getAmount();
    }

    public String toString() {
        return "Serial Number: " + serialNum + "\n" + "Bank Name: " + bankName + "\n" + "Location: "
                + location + "\n" + "Balance: " + String.format( "%.2f", balance );
    }

}

