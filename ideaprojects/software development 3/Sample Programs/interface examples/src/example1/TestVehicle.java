package example1;

public class TestVehicle {

	public static void main(String[] args) {
		
		Vehicle v = new Vehicle("a motorbike", 20000, 1999);
		
		System.out.println("Duty is " + v.calculateDuty());
		System.out.println("Description " + v.printDescription());
		System.out.println("Value " + v.getValue());
		System.out.println("Year " + v.getYear());
	}
}

