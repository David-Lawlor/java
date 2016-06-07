import java.io.*;

/**
 * Created by DL on 10/03/2015.
 * Reading in from a file and doing some calculations and writing back out to another file
 * File is pretty useless in my opinion for now.
 * Buffered reader and writer are used along with file reader and file writer
 */
public class Exercise2 {
    public static void main(String[] args) throws IOException {

        //BufferedReader bufInput = new BufferedReader(new FileReader("Software Development 4/Labs/Lab7 File IO/files/APR.txt"));
        //BufferedWriter bufOutput = new BufferedWriter(new FileWriter("Software Development 4/Labs/Lab7 File IO/files/results.txt"));

        File myDir = new File("Software Development 4/Labs/Lab7 File IO/files");

        File in = new File(myDir, "APR.txt");
        BufferedReader bufIn = new BufferedReader(new FileReader(in));

        File out = new File(myDir, "results.txt");
        BufferedWriter bufOut = new BufferedWriter(new FileWriter(out));

        String s ;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;
        int count = 0;

        while ((s = bufIn.readLine()) != null){
            int num = Integer.parseInt(s);
            if (num > max)
                max = num;
            if(num < min)
                min = num;
            total += num;
            count++;
        }

        bufOut.write("The minimum pressure reading is " + min);
        bufOut.newLine();
        bufOut.write("The maximum pressure reading is " + max);
        bufOut.newLine();
        bufOut.write("The average pressure reading is " + (total/count));

        bufOut.close();


    }
}
