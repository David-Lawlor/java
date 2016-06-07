import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by DL on 17/03/2015.
 */
public class Exercise3 {
    public static void main(String[] args) throws IOException{
        File text = new File("Software Development 4/Labs/Lab8 File IO/res/lyrics.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(text));

        try(Scanner scanIn = new Scanner(text)){
            writer.write("Who wants to live forever");
            writer.close();

            while(scanIn.hasNext()){
                System.out.println(scanIn.nextLine());
            }


        }catch (IOException ex){
            System.out.println("File cannot be found");
        }
    }
}
