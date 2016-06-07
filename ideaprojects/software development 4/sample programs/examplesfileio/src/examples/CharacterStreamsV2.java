package examples;

// http://java.about.com/od/InputOutput/ss/Character-Stream-Example-Code.htm
// The second version of the program below shows how the try with resources 
// feature of Java 7 can make the code a lot simpler. By specifying the 
// resources being used at the start of the try block you can get rid of 
// the finally block altogether as the FileReader and FileWriter streams 
// will be closed automatically.  It means you don't have to worry about 
// closing the input and output streams manually and the resources will 
// always be freed up.

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamsV2 {
    private static final String ORIGINAL_FILENAME = "Software Development 4/Sample programs/ExamplesFileIO/files/source.txt";
    private static final String COPY_FILENAME = "Software Development 4/Sample programs/ExamplesFileIO/files/destination2.txt";

    public static void main(String[] args) throws IOException {

        try (FileReader fileInput = new FileReader(ORIGINAL_FILENAME);
            FileWriter fileOutput = new FileWriter(COPY_FILENAME))
            {
            int data;
      
            while ((data = fileInput.read()) != -1) {
                fileOutput.write(data);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error message: " + e.getMessage());
        }            
    }
}

