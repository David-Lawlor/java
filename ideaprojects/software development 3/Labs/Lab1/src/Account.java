/**
 * Created by David on 19/09/2014.
 */
import java.util.Random;

public class Account {
    private String name;
    private int accNo;
    private double balance;
    private Random r = new Random();

    // constructor for class
    public Account(double balanceIn, String nameIn, int accNoIn){
        balance = balanceIn;
        name = nameIn;
        accNo = accNoIn;
    }

    //
    public Account (double balanceIn, String nameIn){
        balance = balanceIn;
        name = nameIn;
    }

    public Account (String nameIn){
        name = nameIn;
    }

    public void withdraw(double amount){
        if(amount <= balance)
            balance -= amount;
        else
            System.out.println("You have innsuficient funds");
    }

    public void withdraw(double amount, double fee){
        if((amount + fee) <= balance)
            balance -= amount + fee;
        else
            System.out.println("You have innsufficient funds");
    }

    public void deposit(double amount){
        balance += amount;
    }

    public double getBalance(){
        return balance;
    }

    public void print(){
        System.out.println(name);
        System.out.println(accNo);
        System.out.println(balance);
    }


}
