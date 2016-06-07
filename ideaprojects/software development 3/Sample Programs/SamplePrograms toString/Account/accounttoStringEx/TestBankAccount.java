package accounttoStringEx;

public class TestBankAccount {
	public static void main(String args[])
    {
		SavingsAccount s = new SavingsAccount(10,100);
		s.deposit(5000);
		System.out.println(s);
		s.calcInterest();
		System.out.println(s);
		s.withdraw(4500);
		System.out.println(s);
		
		CurrentAccount c = new CurrentAccount(1500);
		c.deposit(400);
		System.out.println(c);
		c.deposit(600);
		System.out.println(c);
		c.deposit(600);
		System.out.println(c);
		c.deposit(600);
		System.out.println(c);
		c.deductFees();
		System.out.println(c);
    }

}
