import java.io.*;

/**
 * Created by DL on 10/03/2015.
 */
public class Exercise1 {
    public static void main(String[] args) throws IOException{

        String s;
        double d = 0;

        File myDir = new File("Software Development 4/Labs/Lab7 File IO/files");
        File input = new File(myDir, "numbers.txt");
        BufferedReader in = new BufferedReader(new FileReader(input));

        while ((s = in.readLine()) != null){
            d += Double.parseDouble(s);
        }

        System.out.println("Total of all numbers is: " + d);

        in.close();
    }
}
