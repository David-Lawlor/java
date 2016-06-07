package scannerreadEx;

import java.util.Scanner;
import java.io.*;

public class HasNextIntDemo {
	public static void main(String[] args)
    {
        try(Scanner inputStream = new Scanner(new FileInputStream("files/data.txt")))
        {   	
        	 int next, sum = 0;
             while (inputStream.hasNextInt( ))
             {
                 next = inputStream.nextInt( );
                 sum = sum + next;
             }
             System.out.println("The sum of the numbers is " + sum);
        }
        catch(FileNotFoundException e)
        {
           System.out.println("File data.txt was not found");
           System.out.println("or could not be opened.");
           System.exit(0);
        }
    }
}

