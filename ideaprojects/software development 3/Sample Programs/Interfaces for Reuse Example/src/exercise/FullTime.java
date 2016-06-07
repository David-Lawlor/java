package exercise;

public class FullTime extends Employee {
	private double salary;

	public FullTime(String name, double salary) {
		super(name);
		setSalary(salary);
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public double pay() {
		return salary;
	}

	public String toString() {
		return super.toString() + "\t Salaried \t ";
	}
    public double getMeasure()
    {
    	return salary;
    }

}
