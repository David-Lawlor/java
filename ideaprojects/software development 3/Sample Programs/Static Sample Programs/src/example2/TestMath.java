package example2;
import java.util.*;

/**
 * Created by Patricia on 07/10/2014.
 */
public class TestMath {
    public static void main(String args[])
    {
        int num1;
        int num2;

        Scanner in = new Scanner (System.in);

        System.out.println("Please enter an integer: ");
        num1 = in.nextInt();
        in.nextLine();

        System.out.println("Please enter another integer: ");
        num2 = in.nextInt();
        in.nextLine();

        System.out.println("The greater of the two integers is "+ Math.max(num1, num2));
        System.out.println("The lesser of the two integers is "+ Math.min(num1, num2));
    }
}
