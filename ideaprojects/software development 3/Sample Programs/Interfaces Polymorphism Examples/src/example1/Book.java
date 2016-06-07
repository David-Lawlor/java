package example1;

public class Book implements LoanItem {
	private double price = 1.00;
	private String title;
	private String author;
	private int ISBN;

	public Book(String t, String a, int I) {
		title = t;
		author = a;
		ISBN = I;
	}

	public double calculatePrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getISBN() {
		return ISBN;
	}

}

