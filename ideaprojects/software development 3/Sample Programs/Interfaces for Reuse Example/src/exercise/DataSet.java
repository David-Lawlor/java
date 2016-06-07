package exercise;


public class DataSet {
	private double sum;
	private int count;
	private Measurable maximum;

	public DataSet() {
		sum = 0;
		count = 0;
	}
	public void add(Measurable x) {
		sum = sum + x.getMeasure();
		if (count == 0 || maximum.getMeasure() < x.getMeasure()) {
			maximum = x;
		}
		count++;
	}

	public Measurable getMaximum() {
		return maximum;
	}

	public double getAverage() {
		return (sum / count);
	}

}
