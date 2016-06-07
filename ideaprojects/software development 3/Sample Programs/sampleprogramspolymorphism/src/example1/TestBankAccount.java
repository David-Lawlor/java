package example1;

public class TestBankAccount {
	public static void main(String args[])
    {
		BankAccount b1;
		b1 = new CurrentAccount(1500);
		b1.deposit(400);
		System.out.println(b1);
		b1.deposit(600);
		System.out.println(b1);
		b1.deposit(600);
		System.out.println(b1);
		b1.deposit(600);
		System.out.println(b1);
		// The following method call gives an error because b1 is of type BankAccount 
		// and there is no deductFees() method in BankAcccount
//		b1.deductFees();
		System.out.println(b1);
		
		System.out.println();
		
		CurrentAccount b2;
		b2 = new CurrentAccount(3000);
		b2.deposit(400);
		System.out.println(b2);
		b2.deposit(600);
		System.out.println(b2);
		b2.deposit(600);
		System.out.println(b2);
		b2.deposit(600);
		System.out.println(b2);
		b2.deductFees();
		System.out.println(b2);
    }
}

