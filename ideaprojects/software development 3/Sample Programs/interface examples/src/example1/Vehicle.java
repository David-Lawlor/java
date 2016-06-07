package example1;

public class Vehicle implements ImportDuty {
	private String description;
	private double value;
	private int year;
	private double duty;

	public Vehicle(String d, double v, int y) {
		description = d;
		value = v;
		year = y;
	}
	public String printDescription() {
		return description;
	}
	public double getValue() {
		return value;
	}
	public int getYear() {
		return year;
	}
	
	public double calculateDuty() {
		if (year < 1990) {
			duty = 0;
		} else {
			duty = value * TAXRATE;
		}
		return duty;
	}
	
}

