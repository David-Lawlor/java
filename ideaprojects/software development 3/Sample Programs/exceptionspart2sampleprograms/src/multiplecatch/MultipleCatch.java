package multiplecatch;

import java.util.*;

public class MultipleCatch {
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter value");
		String number = scnr.next();
		try {
			if (number.length() > 5) {
				throw new IllegalArgumentException();
			}
			int num = Integer.parseInt(number);
			System.out.println("Number is:" + num);

		}

		catch (NumberFormatException e) {
			System.out.println("Wrong type of data");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("Number exceeded limit");
			e.printStackTrace();
		}
        finally
        {
            System.out.println("Inside finally");
        }

        System.out.println("Exiting program");
	}

}
