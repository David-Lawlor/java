package exampleSetHashSet;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

/**
 * Created by Patricia on 09/04/2015.
 */
public class TestMySet {
    public static void main(String[] args) {
        Set<String> urlsProcessed = new HashSet<String>(500);

        String url = "http://www.javamex.com/";
        urlsProcessed.add(url);

        if (urlsProcessed.contains(url)) {
            System.out.println("Found");

        }

        //processURLs(urlsProcessed);
    }



}
