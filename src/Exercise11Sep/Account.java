package Exercise11Sep;

public class Account
{
    private String name;
    private int number;
    private int type;
    private double balance;

    // add a constructor that takes a name
    public Account(){
        name = "UNKNOW";
        number = 1234;
        type = 1;
        balance = 0;
    }

    //if we add a constructor with a parameter what else should we add?
    
    public void setAccount(String aName, int aNumber, int aType, double aBalance)
    {
        name = aName;
        number = aNumber;
        type = aType;
        balance = aBalance;
    }
    
    
    public void setAccount(String aName, int aNumber, double aBalance)
    {
        name = aName;
        number = aNumber;
        type = 1;
        balance = aBalance;
    }

    
    public String getName()
    {
        return (name);
    }
    
    
    public double getBalance()
    {
        return (balance);
    }
    
    
    public void deposit(double fund)
    {
        if (fund < 0.0) 
        {
            System.out.println("Error: no negative amount to deposit.");
            System.exit(0);
        }
        balance += fund;
    }

    
    public boolean withdrawal(double fund)
    {
        if (fund > balance) 
        {
            System.out.println("Error: insufficient balance to withdraw.");
            return false;
        }
        else 
        {
            balance -= fund;
            return true;
        }
    }

    // Add a toString method
//    public String toString(){
//        String accountInfo;
//
//        accountInfo = name + "has an account " + number + " (Type: " + type + ")\n";
//        accountInfo = "The current balance is " + balance;
//
//    }
}