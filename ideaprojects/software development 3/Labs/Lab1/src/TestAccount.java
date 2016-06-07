import java.util.Scanner;
public class TestAccount
	{
		public static void main(String[] args)
	    {
		String name;
		double balance;
		int acctNum;
		Account acct;

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter account holder's first name");
		name = scan.next();
		acct = new Account(name);
		System.out.println("Account for " + name + ":");
		acct.print();

		System.out.println("\nEnter initial balance");
		balance = scan.nextDouble();
		acct = new Account(balance,name);
		System.out.println("Account for " + name + ":");
		acct.print();
		
		System.out.println("\nEnter account number");
		acctNum = scan.nextInt();
		acct = new Account(balance,name,acctNum);
		System.out.println("Account for " + name + ":");
		acct.print();

		System.out.print("\nDepositing 100 into account, balance is now ");
		acct.deposit(100);
		System.out.println(acct.getBalance());
		System.out.print("\nWithdrawing €25, balance is now ");
		acct.withdraw(25);
		System.out.println(acct.getBalance());
		System.out.print("\nWithdrawing €25 with €2 fee, balance is now ");
		acct.withdraw(25,2);
		System.out.println(acct.getBalance());

		System.out.println("\nBye!");
	    }
	}
