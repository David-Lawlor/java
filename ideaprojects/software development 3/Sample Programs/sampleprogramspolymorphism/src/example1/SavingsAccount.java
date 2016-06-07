package example1;
public class SavingsAccount extends BankAccount
{
	private double interestRate;

  	public SavingsAccount(double rate, double initbal)
  	{
    	 super(initbal); 
		 interestRate = rate;		
  	}

  	public void calcInterest()
  	{
    		double interest = getBalance() * interestRate / 100;
    		deposit(interest);
    }
  	public String toString() 
    { 
        return "Savings account " + super.toString() + "\n Interest Rate : " + interestRate;
    }	
}




