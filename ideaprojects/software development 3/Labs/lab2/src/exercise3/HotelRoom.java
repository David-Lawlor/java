package exercise3;

/**
 * Created by David on 23/09/2014.
 */
public class HotelRoom {
    private int roomNumber;
    protected double nightRate;

    public HotelRoom(int roomIn){
        roomNumber = roomIn;
        setRate();
    }

    public void setRoomNumber(int roomIn){
        roomNumber = roomIn;
    }
    public void setRate(){
        if(roomNumber < 300)
            nightRate = 70;
        else
            nightRate = 90;
    }

    public int getRoomNumber(){
        return roomNumber;
    }
    public double getNightRate(){
        return nightRate;
    }

    public void print(){
        System.out.println("Room number " + roomNumber + " costs €" + nightRate + " per night");

    }
}
