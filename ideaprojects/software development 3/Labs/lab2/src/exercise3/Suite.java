package exercise3;

/**
 * Created by David on 23/09/2014.
 */
public class Suite extends HotelRoom {

    public Suite(int roomIn){
        super(roomIn);
    }

    public void setRate(){
        super.setRate();
        nightRate += 40;
    }

    public void print(){
        super.print();
        System.out.println("  Suite charge has been added");
    }
}
