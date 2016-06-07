import java.io.*;
import java.util.Scanner;

/**
 * Created by DL on 17/03/2015.
 */
public class Exercise2 {
    public static void main(String[] args) throws IOException{
        int total = 0;
        int loopCounter = 0;
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        File input = new File("Software Development 4/Labs/Lab8 File IO/res/data.txt");
        File output = new File("Software Development 4/Labs/Lab8 File IO/res/results.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));

        try(Scanner scanIn = new Scanner(input)){

            while(scanIn.hasNextInt()){
                int x  = scanIn.nextInt();
                if(maximum < x)
                    maximum = x;
                if(minimum > x)
                    minimum = x;
                total += x;
                loopCounter++;
            }

            writer.write("The maximum value is " + maximum + "\n");
            writer.write("The minimum value is " + minimum + "\n");
            writer.write("The average temperature is " + total/loopCounter);

            writer.close();

        }catch (FileNotFoundException nf){
            System.out.println("File cannot be found");
        }

    }
}
