/*Sdev3
  PACKAGE_NAME
  Created by David
  12:15   07/11/2014
  Software Development 3
*/

import java.util.InputMismatchException;
import java.util.Scanner;


public class TestRefuseTruck {
    public static void main(String args[])
    {
        // Declare instance variables
        boolean input = false;
        int noBins=0;
        double refuseRatePerKilo = 0.0, binWeight =0.0;

        Scanner in = new Scanner(System.in);
        while(!input) {
            try {
                System.out.print("Enter number of bins the truck can collect:");
                noBins = in.nextInt();
                input = true;
            } catch (InputMismatchException ime) {
                in.nextLine();
                System.out.println("Error with Input");
            }
        }
        input = false;

        while(!input){
            try {
                System.out.print("Enter cost per kilo:");
                refuseRatePerKilo = in.nextDouble();
                input = true;
            } catch (InputMismatchException ime){
                  in.nextLine();
                  System.out.println("Error with Input");
            }
        }
        input = false;

        RefuseTruck truck1 = new RefuseTruck(noBins, refuseRatePerKilo);


        while ( truck1.getMaxBins()>truck1.getNoOfBinsCollected()) {
            input = false;
            System.out.println("inside while 1");
            while (!input) {
                System.out.println("inside while 2");
                try {
                    System.out.print("Enter the weight for  bin " + (truck1.getNoOfBinsCollected() + 1) + " :");
                    binWeight = in.nextDouble();
                    truck1.collectBin(binWeight);
                    input = true;
                } catch (InputMismatchException ime) {
                    in.nextLine();
                    System.out.println("Error with Input");
                    input = false;
                }
            }

        }

        truck1.printStats();

    }

}

