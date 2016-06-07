package exercise;

public abstract class Employee implements Measurable {
	private String name;

	public Employee(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	abstract public double pay();

	public String toString() {
		return name;
	}

}
