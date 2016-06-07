/*Sdev3
  PACKAGE_NAME
  Created by David
  13:59   04/11/2014
  Software Development 3
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = new int[9];
        int hn = 0;

        for(int x = 0; x < numbers.length; x++) {
            try{
                System.out.println("Enter number " + (x + 1));
                numbers[x] = in.nextInt();
                if(hn < numbers[x])
                    hn = numbers[x];
            }
            catch(InputMismatchException ime){
                in.nextLine();
                System.out.println("Error in input, Please enter digits only");
                x--;
            }
        }
        System.out.println("The highest number is " + hn);
    }
}
