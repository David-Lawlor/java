/*Sdev3
  PACKAGE_NAME
  Created by David
  12:10   14/11/2014
  Software Development 3
*/

import java.util.ArrayList;

public class Flight {
    private int capacity;
    private double duration;
    ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public Flight(int capacity, double duration){
        this.capacity = capacity;
        this.duration = duration;
    }

    public void addPassenger(Passenger p){
        passengers.add(p);
    }

    public void print(){
        for(Passenger p: passengers){
            System.out.println(p.name + " , " + p.age );
        }
    }

    public int getNumberOfSeats(){
        return (capacity - passengers.size());
    }

    public String getOldest(){
        int oldest = 0, index = -1;
        for(int i = 0; i < passengers.size(); i++){
            if(passengers.get(i).age > oldest ){
                oldest = passengers.get(i).age;
                index = i;
            }
        }
        return passengers.get(index).name + " age: " +  + passengers.get(index).age;
    }

    class Passenger{
        private String name;
        private int age;

        public Passenger(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}
