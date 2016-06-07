package example1;
public class CurrentAccount extends BankAccount 
{
    private int transactionCount;
    
    public CurrentAccount(double initbal) 
    {
     super(initbal);
     transactionCount = 0;
    }
    
    public void deposit(double amount) 
    { 
    	super.deposit(amount);
    	transactionCount++;
    }
    
    public void withdraw(double amount) 
    { 
    	super.withdraw(amount);
    	transactionCount++;
    }
 
    public String toString()
    {
    	return "Current account " +super.toString()+"\n No of Transactions on this acc:  " + transactionCount;
    } 
    
    public void deductFees()
    {
    	if(transactionCount >3)
    	{
    		double fees = .5*(transactionCount-3);
    		System.out.println("Current fee is " + fees);
    		super.withdraw(fees);   		
    	}
    }
}


