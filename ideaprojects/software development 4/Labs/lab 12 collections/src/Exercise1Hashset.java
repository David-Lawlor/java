import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by DL on 22/04/2015.
 */
public class Exercise1Hashset {
    public static void main(String[] args) {
        String[] sampleStrings = {"red", "red", "blue", "orange", "cyan", "indigo", "blue", "orange", "black", "pink", "green", "navy", "emerald"};
        Set<String> colours = new HashSet<>();
        for(String s: sampleStrings) colours.add(s);
        System.out.println("The number of unique strings is: " + colours.size());
        Iterator iter = colours.iterator();
        while (iter.hasNext())System.out.println(iter.next());
    }
}
