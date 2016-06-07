import java.io.*;

public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String registration;
	private String make;
	private String color;

	public Car(String registration, String make, String color) {

		this.registration = registration;
		this.make = make;
		this.color = color;
	}

	public String toString() {
		return ("Car registration: " + registration + " make: " + make
				+ " color: " + color);
	}
}
