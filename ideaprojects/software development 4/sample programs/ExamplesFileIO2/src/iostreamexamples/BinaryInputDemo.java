package iostreamexamples;

import java.io.*;

public class BinaryInputDemo {
	public static void main(String[] args) {
		try (ObjectInputStream inputStream = new ObjectInputStream(
				new FileInputStream("files/numbers.dat"))) {

			System.out.println("Reading the file numbers.dat.");
			for (int i = 0; i < 5; i++) {
				System.out.println(inputStream.readInt());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file numbers.dat.");
		} catch (IOException e) {
			System.out.println("Problems with input from numbers.dat.");
		}
		System.out.println("End of program.");
	}
}
