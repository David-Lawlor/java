package example;

public class SharedAccount {
	private double balance;

	public SharedAccount(double initialAmount) {
		balance = initialAmount;
	}

	public void completeTransaction(double amount) {
		double temp = this.balance + amount;

		if (amount < 0)
			System.out.println("Withdrawing: " + Math.abs(amount));
		else
			System.out.println("Depositing: " + amount);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Transaction interrupted.");
		}

		balance = temp;
		System.out.println("Current Balance: " + balance);
	}
}