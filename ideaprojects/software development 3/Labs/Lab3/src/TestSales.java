/**
 * Created by David on 29/09/2014.
 */
import java.util.Scanner;
public class TestSales {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Salesperson p = new Salesperson("John Dixon", 5, 4000, 5);

       for (int i = 0; i < 5; i++) {
           System.out.println("Enter amount of sales for sales transaction: " + (i +1));
           p.fillSales(i, in.nextDouble());
        }

        p.report();


    }
}