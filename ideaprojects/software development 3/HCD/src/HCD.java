/**
 * Created by David Lawlor on 24/09/2014.
 */
import java.util.Scanner;

public class HCD {
    public static void main(String [] args){

        Scanner in = new Scanner(System.in);
        int l, s, r;

        do {
            r = Integer.MIN_VALUE;
            System.out.println("Enter the bigger integer");
            l = in.nextInt();
            System.out.println("Enter the smaller integer");
            s = in.nextInt();

            while (r != 0) {
                r = l % s;
                if (r != 0) {
                    l = s;
                    s = r;
                }
            }
            System.out.println("The greatest common divisor is " + s);
            System.out.println("Would you like to find another? y or n");
        }while (in.next().charAt(0) != 'n');
    }
}
