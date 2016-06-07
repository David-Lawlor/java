/*Sdev3
  PACKAGE_NAME
  Created by David
  13:09   04/11/2014
  Software Development 3
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean input = false;
        int number1 = 0, number2 = 0, total=0;

        while(!input){
            try{
                System.out.println("Enter number 1");
                number1 = in.nextInt();
                input = true;
            }
            catch(InputMismatchException ime){
                in.nextLine();
                System.out.println("Invalid integer entered. Please try again");
            }
        }
        input = false;

        while(!input){
            try{
                System.out.println("Enter number 2");
                number2 = in.nextInt();
                input = true;
            }
            catch(InputMismatchException ime){
                in.nextLine();
                System.out.println("Invalid integer entered. Please try again");
            }
        }


        try{
            total = number1/number2;
            System.out.println(number2 +" goes into " + number1 + " this many times " + total);
        }
        catch(ArithmeticException ae){
            System.out.println(number2 +" goes into " + number1 + " this many times 0");
        }
    }
}
