import java.io.*;

/**
 * Created by DL on 18/03/2015.
 * A simple class that creates a file with the names below
 */
public class CreateNames {
    public static void main(String[] args) {
        File output = new File("Software Development 4/Labs/Lab9 File IO Exercise/res/names.txt");

        try(FileWriter fw = new FileWriter(output); BufferedWriter bw = new BufferedWriter(fw)){

            bw.write("Emma Woodhouse\n");
            bw.write("Fitzwilliam Darcy\n");
            bw.write("Elizabeth Bennett\n");
            bw.write("Anne Elliott\n");
            bw.write("Frederick Wentworth\n");
            bw.write("Paul Simon\n");
            bw.write("Freddie Mercury\n");
            bw.write("Clark Kent\n");
            bw.write("Bruce Banner\n");
            bw.write("Peter Parker\n");
            bw.write("David Bowie");


        }catch(FileNotFoundException nf){
            System.out.println("File cannot be found");
        }catch (IOException ioe){
            System.out.println("Error outputting to file");
        }


    }
}
