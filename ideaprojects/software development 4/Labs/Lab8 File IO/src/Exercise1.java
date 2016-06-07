import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by DL on 17/03/2015.
 * Using the Scanner to simply read in from a file and do a calculation
 */
public class Exercise1 {
    public static void main(String[] args) {

        File fileIn = new File("Software Development 4/Labs/Lab8 File IO/res/ex1Nums.txt");
        double sum = 0;

        try (Scanner input = new Scanner(new FileInputStream(fileIn))){

            while (input.hasNextDouble()){
                sum += input.nextDouble();
            }

            System.out.println("Total of all the numbers is "+ sum);

        }catch (FileNotFoundException nf){
            System.out.println("The selected file was not found");
        }


    }
}
