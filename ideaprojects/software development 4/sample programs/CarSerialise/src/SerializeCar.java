import java.io.*;

public class SerializeCar {
	private final String FILENAME = "files/cars.dat";// write a car

	private void write() {
		Car c1 = new Car("11D 16999", "Ford Galaxy", "Blue");
		Car c2 = new Car("11D 16123", "Opel Corsa", "Silver");
		try (FileOutputStream fo = new FileOutputStream(FILENAME);
				ObjectOutputStream oo = new ObjectOutputStream(
						new BufferedOutputStream(fo))) {
			oo.writeObject(c1);
			System.out.println("Car written:\t" + c1);
			oo.writeObject(c2);
			System.out.println("Car written:\t" + c2);
		} catch (NotSerializableException e) // doesn't implement serializable
		{
			System.out.println(e);
		} catch (IOException e) // file output error
		{
			System.out.println(e);
		}
	}

	private void read() {
		Car c;
		try (ObjectInputStream oi = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(FILENAME)))) {
			do {
				try {
					c = (Car) oi.readObject();
					System.out.println("Car read:\t" + c);
				} catch (EOFException e) {
					System.out.println("EOF reached");
					break;
				}
			} while (true);
		} catch (IOException e) // file input error
		{
			System.out.println(e);
		} catch (ClassNotFoundException e) // class not found in this
											// application
		{
			System.out.println(e);
		}
	}

	public static void main(String args[]) {
		SerializeCar c = new SerializeCar();
		c.write();
		c.read();
	}
}
