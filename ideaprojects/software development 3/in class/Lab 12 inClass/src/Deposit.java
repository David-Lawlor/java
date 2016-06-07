/*Sdev3
  PACKAGE_NAME
  Created by David
  13:29   03/11/2014
  Software Development 3
*/
import java.util.InputMismatchException;
import java.util.Scanner;
public class Deposit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double balance = 100, deposit = 0;

        try {
            System.out.println("Enter the amount you wish to deposit");
            deposit = in.nextDouble();
            balance += deposit;
            System.out.println("New balance is " + balance);
        }
        catch(InputMismatchException ip){
            System.out.println("Invalid Entry");
            ip.printStackTrace();

        }
    }
}
