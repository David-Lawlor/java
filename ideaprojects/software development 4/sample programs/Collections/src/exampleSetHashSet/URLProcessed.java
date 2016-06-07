package exampleSetHashSet;

import java.util.*;

public class URLProcessed {
    Set<String> urlsProcessed = new HashSet<String>(500);

    public void process(String url)
    {
        urlsProcessed.add(url);
        System.out.println("Inside Process");
    }
    public void processURLs(List<String> urls) {
        for (String url : urls) {
            if (!urlsProcessed.contains(url)) {
                process(url);
            }
        }
    }
    public void printList()
    {
        for (String url : urlsProcessed) {
            System.out.println("Item is " + url);
        }
    }

    public static void main(String[] args) {
       StringURLs s = new StringURLs();
        s.fillList();
        URLProcessed u = new URLProcessed();
        u.processURLs(s.geturls());
        u.printList();
    }




}
