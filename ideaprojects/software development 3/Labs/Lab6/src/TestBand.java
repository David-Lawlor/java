/**
 * Created by David on 10/10/2014.
 */
import java.util.Scanner;

public class TestBand {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] names = {"John", "Paul", "George", "Ringo"};
        String[] instruments = {"Keyboards", "Guitar", "Guitar", "Drums"};

        Rockband r1 = new Rockband("The Beatles", "Apple", names, instruments);

        System.out.println("Please enter label");
        if (r1.changeRecordLabel(in.next()))
            System.out.println("Label changed");
        else
            System.out.println("Label not changed");


        r1.print();
    }
}
