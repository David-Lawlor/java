package example2;

import java.util.Scanner;

public class TestConversion {
	public static void main(String[] args) {
		double pounds;
		Scanner in = new Scanner(System.in);
		MyClass c1 = new MyClass();
		System.out
				.println("Enter the amount in pounds that you wish to convert:");
		pounds = in.nextDouble();
		System.out.println("The amount in grams is:" + c1.poundToGram(pounds));
	}
}




