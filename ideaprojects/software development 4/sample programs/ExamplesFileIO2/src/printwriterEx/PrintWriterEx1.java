package printwriterEx;

import java.io.*;
import java.util.Scanner;

public class PrintWriterEx1 {
	public static void main(String[] args) throws IOException {
		int num;
		int sum = 0;
		int count = 0;
		double avg = 0.0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		File inFile = new File("files", "readings.txt");
		File outFile = new File("files", "results.txt");

		try (Scanner in = new Scanner(inFile);
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new FileWriter(outFile)))) {
			while (in.hasNextInt()) {
				num = in.nextInt();
				sum = sum + num;
				count++;
				if (num > max)
					max = num;
				if (num < min)
					min = num;
			}
			avg = sum / count;
			out.println(sum);
			out.println(min);
			out.println(max);
			out.println(avg);
		} catch (IOException e) {
			System.out.println("Error message: " + e.getMessage());
		}
	}
}
