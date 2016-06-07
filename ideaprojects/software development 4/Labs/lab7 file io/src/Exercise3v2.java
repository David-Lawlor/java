import java.io.*;

/**
 * Created by DL on 11/03/2015.
 */
public class Exercise3v2 {
    public static void main(String[] args) throws IOException {
        String s = "";

        File myDir = new File("Software Development 4/Labs/Lab7 File IO/files");

        File output = new File(myDir, "Lyricsv2.txt");
        BufferedWriter bufOut = new BufferedWriter(new FileWriter(output));

        File input = new File(myDir, "Lyricsv2.txt");
        BufferedReader bufIn = new BufferedReader(new FileReader(input));

        bufOut.write("Ground control to major tom");
        bufOut.newLine();
        bufOut.write("Ground control to major tom");
        bufOut.newLine();
        bufOut.write("Take your protein pills and put your helmet on");
        bufOut.newLine();
        bufOut.write("Ground control to major tom");
        bufOut.newLine();
        bufOut.write("Commencing countdown engines on");
        bufOut.newLine();
        bufOut.write("check ignition and may god be with you");
        bufOut.newLine();
        bufOut.write("this is ground control to major tom");
        bufOut.newLine();
        bufOut.write("you've really made the grade");
        bufOut.newLine();
        bufOut.write("And the papers wants to know who's shirt you wear");
        bufOut.newLine();
        bufOut.write("now its time to leave the capsule if you dear");
        bufOut.newLine();
        bufOut.write("This is major tom to ground control");
        bufOut.newLine();
        bufOut.write("im stepping through the door");
        bufOut.newLine();
        bufOut.write("and im floating in the most peculiar way");
        bufOut.newLine();
        bufOut.write("and the stars look very different today");
        bufOut.newLine();
        bufOut.write("for here");
        bufOut.newLine();
        bufOut.write("and i'm sitting in a tin can");
        bufOut.newLine();
        bufOut.write("far above the world");
        bufOut.newLine();
        bufOut.write("Planet earth is blue and there's nothing i can do");
        bufOut.newLine();
        bufOut.write("though im passed one hundred thousand miles");
        bufOut.newLine();
        bufOut.write("im feeling very skilled");
        bufOut.newLine();
        bufOut.write("and i think my spaceship know which way to go");
        bufOut.newLine();
        bufOut.write("tell my wife i love her very much she know");
        bufOut.newLine();
        bufOut.write("Ground control to major tom");
        bufOut.newLine();
        bufOut.write("your circuits dead theres something wrong");
        bufOut.newLine();
        bufOut.write("can you hear me major tom");
        bufOut.newLine();
        bufOut.write("can you hear");
        bufOut.newLine();
        bufOut.write("and my floating round tin can");
        bufOut.newLine();
        bufOut.write("far above the moon");
        bufOut.newLine();
        bufOut.write("Planet earth is blue and there's nothing i can do");
        bufOut.close();

        while((s = bufIn.readLine()) != null){
            System.out.println(s);
        }


    }
}
