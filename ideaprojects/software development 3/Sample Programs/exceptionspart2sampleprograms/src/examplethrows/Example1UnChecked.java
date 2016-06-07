package examplethrows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1UnChecked {
    // demonstrates throwing an exception when a divide-by-zero occurs
    public static int quotient(int numerator, int denominator)
            throws ArithmeticException {
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner for input
        boolean continueLoop = true; // determines if more input is needed

        do {

                System.out.print("Please enter an integer numerator: ");
                int numerator = scanner.nextInt();
                System.out.print("Please enter an integer denominator: ");
                int denominator = scanner.nextInt();

                int result = quotient(numerator, denominator);
                System.out.printf("\nResult: %d / %d = %d\n", numerator,
                        denominator, result);
                continueLoop = false; // input successful; end looping
        } while (continueLoop); // end do...while
    }
}
