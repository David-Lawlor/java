package scannerreadEx;

import java.util.Scanner;
import java.io.*;

public class HasNextLineDemo {
	public static void main(String[] args) {
		try (Scanner inputStream = new Scanner(new FileInputStream(
				"files/original.txt"));
				PrintWriter outputStream = new PrintWriter(
						new FileOutputStream("files/numbered.txt"))) {
			String line = null;
			int count = 0;

			while (inputStream.hasNextLine()) {
				line = inputStream.nextLine();
				count++;
				outputStream.println(count + " " + line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			System.exit(0);
		}
	}
}
