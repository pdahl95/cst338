package Homework4;
import java.util.HashMap;

/**
 * Title: Bank.java
 * Abstract: This is one class of Homework4. The bank file, which has the functions to add Customers, open new accounts,etc.
 * Using the classes in the other files Account.java and Customer.java
 * Name: Pernille Dahl
 * Date: 2018-Sept-20
 */

public class Bank {

    private String name;
    private HashMap<Integer, Customer> customers = new HashMap<>();
    private HashMap<Integer, Account> bankAccounts = new HashMap<>();

    public Bank(String name) {
        this.name = name;
    }

    public boolean addCustomer(String name, String address, int ssn) {
        if ( customers.size() == 5 ) return false;
        Customer customer = new Customer( name, ssn, address );
        customers.put( ssn, customer );
        System.out.println(customer);
        return true;
    }

    public boolean openAccount(int ssn, int accNum, int accType, double balance) {
        Account account = new Account( accNum, accType, ssn, balance );
        this.bankAccounts.put( accNum, account );
        System.out.println( accNum + ": $" + balance + " - " + customers.get(bankAccounts.get(accNum).getCustomerSsn()).getName() + ": " + ssn );
        return true;
    }

    public boolean closeAccount(int accNum) {
        if ( bankAccounts.containsKey( accNum ) ) {
            bankAccounts.remove( accNum );
            return true;
        }
        return false;
    }

    public boolean accountInfo(int accNum) {
        if ( !bankAccounts.containsKey( accNum ) ) return false;
        Account acc = bankAccounts.get( accNum );
        if ( !customers.containsKey( acc.getCustomerSsn() ) ) return false;
        Customer customer = customers.get( acc.getCustomerSsn() );
        System.out.println(acc);
        System.out.println("Customer Info: " + customer.getName() + "\n" + customer.getAddress());
        System.out.println("SSN: " + customer.getSsn());
        return false;
    }

    public boolean updateBalance(int accNum, double newAmount) {
        if ( newAmount < 0) return false;
        if(!bankAccounts.containsKey( accNum )) return  false;
        Account acc = bankAccounts.get( accNum );
        acc.setBalance( newAmount );
        return true;
    }

    public boolean updateAddress(int ssn, String address) {
        Customer customer = customers.get( ssn ) ;
        if ( customer.getSsn() == ssn ) {
            customer.setAddress( address );
            return true;
        }
        return false;
    }

    public void bankInfo() {
        double balance = 0;
        for(Account acc : bankAccounts.values()){
            balance += acc.getBalance();
        }
        System.out.println( "Bank name: " + name + "\n" + "Number of Customer: " + customers.size() + "\n"
                + "Number of Accounts: " + bankAccounts.size() + "\n" + "Bank Total Balance: " + String.format( "%.2f", balance ) );
    }

}
