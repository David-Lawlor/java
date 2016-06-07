/*Sdev3
  PACKAGE_NAME
  Created by David
  13:39   03/11/2014
  Software Development 3
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int RATE = 10;
        int hours = 0;
        int pay = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println("Enter hours worked");
                hours = in.nextInt();
                valid = true;


                while (hours < 0) {
                    System.out.println("Invalid time entered");
                    System.out.println("Re-enter hours worked");
                    in.nextLine();
                    hours = in.nextInt();
                }


                pay = (hours * RATE);
                System.out.println("You earned " + pay + "today");
            } catch (InputMismatchException ipe) {
                System.out.println("Invalid data entered");
                in.nextLine();
                ipe.printStackTrace();
            }
        }
    }
}
