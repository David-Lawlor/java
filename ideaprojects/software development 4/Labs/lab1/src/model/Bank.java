package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> blist = new ArrayList<BankAccount>();
	DecimalFormat df = new DecimalFormat("€###,###.##");

	public void addAccount(BankAccount b) {
		blist.add(b);
	}

	// This method applies a 2% interest to all Current accounts and a 10%
	// interest to all savings accounts. The interest is added to each account
	
	public void applyInterest() {
		double interest = 0.0;
		double newbal = 0.0;
		for (int i = 0; i < blist.size(); i++) {
			if (blist.get(i).getAccType().equals("Current")) {
				interest = blist.get(i).getBalance() * .02;
				newbal = blist.get(i).getBalance() + interest;
				blist.get(i).setBalance(newbal);
			} else if (blist.get(i).getAccType().equals("Savings")) {
				interest = blist.get(i).getBalance() * .10;
				newbal = blist.get(i).getBalance() + interest;
				blist.get(i).setBalance(newbal);
			}
		}
	}

	// This method returns a string containing all the bank details from the
	// array list
	
	public String getDetails() {
		String output = "";
		for (int i = 0; i < blist.size(); i++) {
			output += (i + 1) + "." + blist.get(i).getName() + ","
					+ blist.get(i).getAccType() + ","
					+ df.format(blist.get(i).getBalance()) + "\n";
		}
		return output;
	}

	// This method takes a string as a parameter (the account type) and returns
	// a string
	// containing only the Account details that match the account type from the
	// array list

	public String getDetails(String s) {
		String output = "";

		for (int i = 0; i < blist.size(); i++) {
			if (blist.get(i).getAccType().equals(s)) {
				output += (i + 1) + "." + blist.get(i).getName() + ","
						+ blist.get(i).getAccType() + ","
						+ df.format(blist.get(i).getBalance()) + "\n";
			}
		}
		return output;
	}

	// returns the total amount of money in all bank accounts
	public double gettotalValue() {
		double total = 0;
		for (int i = 0; i < blist.size(); i++) {
			total += (blist.get(i).getBalance());
		}
		return total;
	}

}
