package Lab6;
public class Customer implements Cloneable {
    private String name;
    private int pin;
    private double balance;
    private String bank;

    public Customer(String n, int pin, double open, String bank) {
        this.name = n;
        this.pin = pin;
        this.balance = open;
        this.bank = bank;
    }

    public Customer clone() {
        try {
            // do a shallow copy.
            return (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            return null; // should never occur.
        }
    }

    public String toString() {
        return "Customer: "+name+ " "+ " balance: $"+balance + " bank:"+bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

}
