package example1;

public class TestLoan {
	public static void main(String args[]) {
		double totalLoan = 0;

		LoanItem loans[] = {
				new Book("Sense and Sensibility", "Jane Austen", 23456),
				new Book("The Hound of the Baskervilles",
						"Sir Arthur Conan Doyle", 88888),
				new CD("Greatest Hits", "Anybody", 34567) };

		for (int i = 0; i < loans.length; i++) {
			totalLoan = totalLoan + loans[i].calculatePrice();
		}

		System.out.println("The total cost of the loan = " + totalLoan);
	}

}


