package test;

import GUI.BankGUI;
import model.Bank;
import model.BankAccount;


public class TestBankGUI {

	public static void main(String args[]) {
		Bank aib = new Bank();

		BankAccount[] b = { new BankAccount("Peter Brady", "Savings", 20500),
				new BankAccount("Tom Jones", "Current", 2500),
				new BankAccount("Tom Jones1", "Current", 2500),
				new BankAccount("Tom Jones2", "Current", 2500),
				new BankAccount("Tom Jones3", "Current", 2500),
				new BankAccount("kate Wynn", "Savings", 100500.60),
				new BankAccount("kate Wynn1", "Savings", 100500.60),
				new BankAccount("kate Wynn2", "Savings", 100500.60)
		};

		for (int i = 0; i < b.length; i++) {
			aib.addAccount(b[i]);
		}

		 BankGUI bg = new BankGUI(aib);
		 bg.setVisible(true);
	}

}
