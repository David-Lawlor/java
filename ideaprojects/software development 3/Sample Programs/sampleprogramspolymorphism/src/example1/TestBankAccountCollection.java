package example1;

public class TestBankAccountCollection {
	public static void main(String args[]) {
		BankAccount accList[] = new BankAccount[4];

		accList[0] = new CurrentAccount(1500);
		accList[1] = new CurrentAccount(3000);
		accList[2] = new SavingsAccount(10, 500);
		accList[3] = new SavingsAccount(9, 1000);

		for (int i = 0; i < accList.length; i++) {
			accList[i].deposit(500);
			accList[i].deposit(800);
			accList[i].deposit(800);
			accList[i].withdraw(800);
			accList[i].deposit(500);

			System.out.println("\nAccount:" + (i + 1) + " " + accList[i]);

			if (accList[i] instanceof CurrentAccount) {
				CurrentAccount c = (CurrentAccount) accList[i];
				c.deductFees();
			} else if (accList[i] instanceof SavingsAccount) {
				SavingsAccount s = (SavingsAccount) accList[i];
				s.calcInterest();
			}

		}
	}
}
