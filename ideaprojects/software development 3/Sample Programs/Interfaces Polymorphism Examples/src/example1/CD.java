package example1;

public class CD implements LoanItem {
	private double price = 2.00;
	private String title;
	private String artist;
	private int idNo;

	public CD(String t, String a, int i) {
		title = t;
		artist = a;
		idNo = i;
	}

	public double calculatePrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public int getidNo() {
		return idNo;
	}
}


