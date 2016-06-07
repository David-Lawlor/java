package model;

public class BankAccount {
	private String name;
	private String accType;
	private double balance;

	public BankAccount(String n, String t, double b) {
		name = n;
		accType = t;
		balance = b;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public String getAccType() {
		return accType;
	}

	public void setBalance(double b) {
		balance = b;
	}
}
