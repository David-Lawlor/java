package exercise2;
import java.util.Scanner;

/**
 * Created by David on 23/09/2014.
 */
public class UseOrder {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);

        String tempName;
        int tempNumber, tempQuantity;
        double tempUnitPrice;

        System.out.println("Please enter name");
        tempName = in.next();
        System.out.println("Please enter number");
        tempNumber = in.nextInt();
        System.out.println("Please enter quantity");
        tempQuantity = in.nextInt();
        System.out.println("Please enter unit price");
        tempUnitPrice = in.nextDouble();

        Order order1 = new Order (tempName, tempNumber, tempQuantity,tempUnitPrice);
        order1.calcTotalPrice();
        order1.print();

        System.out.println("Please enter name");
        tempName = in.next();
        System.out.println("Please enter number");
        tempNumber = in.nextInt();
        System.out.println("Please enter quantity");
        tempQuantity = in.nextInt();
        System.out.println("Please enter unit price");
        tempUnitPrice = in.nextDouble();

        ShippedOrder order2 = new ShippedOrder (tempName, tempNumber, tempQuantity,tempUnitPrice);
        order2.calcTotalPrice();
        order2.print();

    }
}