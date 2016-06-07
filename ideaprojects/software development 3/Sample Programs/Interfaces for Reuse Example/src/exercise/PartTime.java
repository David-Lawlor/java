package exercise;

public class PartTime extends Employee {
	private double rate;
	private double hours;

	public PartTime(String name, double rate, double hours) {
		super(name);
		setRate(rate);
		setHours(hours);
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getRate() {
		return rate;
	}

	public double getHours() {
		return hours;
	}

	public double pay() {
		return rate * hours;
	}

	public String toString() {
		return super.toString() + "\t Hourly \t ";
	}
    public double getMeasure()
    {
    	return rate*hours;
    }

}
