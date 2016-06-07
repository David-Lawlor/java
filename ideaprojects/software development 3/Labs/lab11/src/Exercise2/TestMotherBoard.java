package Exercise2;/*Sdev3
  PACKAGE_NAME
  Created by David
  13:47   02/11/2014
  Software Development 3
*/

import Exercise2.MotherBoard;

import java.util.Scanner;

public class TestMotherBoard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int temp1, temp2;
        String temp;

        System.out.print("Enter manufacturer: ");
        temp = in.next();
        System.out.print("Enter memory size: ");
        temp1 = in.nextInt();
        System.out.print("Enter number of memory modules: ");
        temp2 = in.nextInt();
        MotherBoard mb = new MotherBoard(temp, temp1, temp2);

        System.out.println(mb);
    }
}
