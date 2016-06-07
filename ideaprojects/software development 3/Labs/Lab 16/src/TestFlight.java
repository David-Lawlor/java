/*Sdev3
  PACKAGE_NAME
  Created by David
  12:43   14/11/2014
  Software Development 3
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TestFlight {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean input;

        ArrayList<Flight> flights = new ArrayList<Flight>();

        for (int i = 0; i < 2; i++) {
            int capacity = 0, numberOfPassengers;
            double duration = 0;
            input = false;  // to enter while loop

            // taking in the capacity of the flight and exception handling
            while (!input) {
                try {
                    System.out.println("Enter the capacity for the flight " + (i + 1));
                    capacity = in.nextInt();
                    input = true;// to exit while loop
                } catch (InputMismatchException ipe) {
                    in.next();
                    System.out.println("Data Entry error - please re-try");
                }
            }
            //taking in the duration of the flight
            input = false;// to enter while loop

            // taking in the duration of the flight and exception handling
            while (!input) {
                try {
                    System.out.println("Enter the duration for flight " + (i + 1));
                    duration = in.nextDouble();
                    input = true;// to exit while loop
                } catch (InputMismatchException ipe) {
                    in.next();
                    System.out.println("Data Entry error - please re-try");
                }
            }
            flights.add(new Flight(capacity, duration)); // creating the flight object and putting it in the array list

            ///start entering passenger for the flight
            numberOfPassengers = rand.nextInt(3) + 1; // creating random number of passengers
            System.out.println("Number of passengers: " + numberOfPassengers);

            // loop for creating the passenger objects
            for(int x = 0; x < numberOfPassengers; x++){
                String name;
                int age = 0;
                System.out.println("Enter the name of passenger " + (x + 1));
                name = in.next();
                input = false; // to enter while loop
                while(!input){
                    try {
                        System.out.println("Enter the age for passenger " + (x + 1));
                        age = in.nextInt();
                        input = true;// to exit while loop
                    }catch (InputMismatchException ipe3){
                        in.next();
                        System.out.println("Data Entry error - please re-try");
                    }
                }
                //Flight.Passenger y = flights.get(i).new Passenger (name, age);
                //flights.get(i).addPassenger(y);
                flights.get(i).addPassenger(flights.get(i).new Passenger(name, age));//adding a passenger for the flight object
            }
        }

        // printout for seats available and printing the oldest person on each flight
        for(int i = 0; i < flights.size(); i++){
            System.out.println("Number of seats available " + flights.get(i).getNumberOfSeats());
            flights.get(i).print();
            System.out.println("Oldest person is " + flights.get(i).getOldest() + " on flight number " + (i+1));
        }
    }

}
