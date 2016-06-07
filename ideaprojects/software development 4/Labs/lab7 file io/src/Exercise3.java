import java.io.*;

/**
 * Created by DL on 11/03/2015.
 */
public class Exercise3 {
    public static void main(String[] args) throws IOException {
        String s = "";

        File myDir = new File("Software Development 4/Labs/Lab7 File IO/files");

        File output = new File(myDir, "Lyrics.txt");
        BufferedWriter bufOut = new BufferedWriter(new FileWriter(output));

        File input = new File(myDir, "Lyrics.txt");
        BufferedReader bufIn = new BufferedReader(new FileReader(input));

        bufOut.write("Ground control to major tom");
        bufOut.close();

        while((s = bufIn.readLine()) != null){
            System.out.println(s);
        }


    }
}
