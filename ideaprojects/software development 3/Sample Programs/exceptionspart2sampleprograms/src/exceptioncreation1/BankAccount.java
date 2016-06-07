package exceptioncreation1;

public class BankAccount {
	private double balance; // Account balance
	private double interestRate; // Interest rate
	private double interest; // Interest earned

	public BankAccount(double startBalance, double intRate)
			throws NegativeStartingBalance, NegativeInterestRate {
		if (startBalance < 0)
			throw new NegativeStartingBalance(startBalance);
        if(intRate <0)
            throw new NegativeInterestRate(intRate);
		balance = startBalance;
		interestRate = intRate;

	}
}


