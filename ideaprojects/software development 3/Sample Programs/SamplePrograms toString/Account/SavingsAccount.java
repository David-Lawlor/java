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
    		double interest = balance * interestRate / 100;
    		deposit(interest);
    }
  	public void print() 
    { 
        super.print();
        System.out.println("Interest Rate : " + interestRate);
    }	
}




