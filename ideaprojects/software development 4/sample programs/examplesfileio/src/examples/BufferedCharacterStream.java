package examples;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class BufferedCharacterStream {
	// The two constants below specify the input and output files.
    // Change the path and filenames to match files on your computer.
    private static final String ORIGINAL_FILENAME = "Software Development 4/Sample programs/ExamplesFileIO/files/original.txt";
    private static final String COPY_FILENAME = "Software Development 4/Sample programs/ExamplesFileIO/files/copybuf.txt";

    public static void main(String[] args) throws IOException {

        try (BufferedReader bufInput = new BufferedReader(new FileReader(ORIGINAL_FILENAME));
             BufferedWriter bufOutput = new BufferedWriter(new FileWriter(COPY_FILENAME)))
            {
            int data;

            //For each byte read it in from the input file
            //and write it to the output file
            //The end of the file is determined by the value
           //of -1 for the character being read.
           while ((data = bufInput.read()) != -1) {
                bufOutput.write(data);
            }
        }
        catch (IOException e)
        {
            //Catch the IO error and print out the message
            System.out.println("Error message: " + e.getMessage());
        }
    }

}
