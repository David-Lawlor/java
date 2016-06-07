/*Sdev3
  PACKAGE_NAME
  Created by David
  13:46   04/11/2014
  Software Development 3
*/

import java.util.Scanner;

public class Exercise2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int array[]= { 10, 11, 12, 13, 14 } ;
        boolean input = false;

        while(!input) {
            try {
                System.out.print("Which index would you like?");
                int index = in.nextInt();
                System.out.println("Answer: " + array[index]);
            }
            catch (ArrayIndexOutOfBoundsException oob){
                System.out.println("You have entered an invalid index");
                System.out.println("Enter an index between 0 and " + (array.length-1));
            }
        }
    }
}

