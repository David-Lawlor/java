package examplethrows;

//Fig. 11.2: DivideByZeroWithExceptionHandling.java
//Handling ArithmeticExceptions and InputMismatchExceptions.
import java.util.*;

public class Example1 {
	// demonstrates throwing an exception when a divide-by-zero occurs
	public static int quotient(int numerator, int denominator)
			throws ArithmeticException {
		return numerator / denominator;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // scanner for input
		boolean continueLoop = true; // determines if more input is needed

		do {
			try // read two numbers and calculate quotient
			{
				System.out.print("Please enter an integer numerator: ");
				int numerator = scanner.nextInt();
				System.out.print("Please enter an integer denominator: ");
				int denominator = scanner.nextInt();

				int result = quotient(numerator, denominator);
				System.out.printf("\nResult: %d / %d = %d\n", numerator,
						denominator, result);
				continueLoop = false; // input successful; end looping
			} // end try
			catch (InputMismatchException i) {
				System.out.printf("\nException: %s\n", i);
				scanner.nextLine(); // discard input so user can try again
				System.out
						.println("You must enter integers. Please try again.\n");
			} // end catch
			catch (ArithmeticException a) {
				System.out.printf("\nException: %s\n", a);
				System.out
						.println("Zero is an invalid denominator. Please try again.\n");
			} // end catch
		} while (continueLoop); // end do...while
	} 
} 

/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/

