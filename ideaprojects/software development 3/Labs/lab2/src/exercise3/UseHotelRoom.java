package exercise3;

/**
 * Created by David on 23/09/2014.
 */
public class UseHotelRoom {
    public static void main(String [] args){
        HotelRoom room1 = new HotelRoom(229);
        Suite room2 = new Suite(225);
        HotelRoom room3 = new HotelRoom(300);
        Suite room4 = new Suite(360);

        room1.print();
        room2.print();
        room3.print();
        room4.print();



    }
}
