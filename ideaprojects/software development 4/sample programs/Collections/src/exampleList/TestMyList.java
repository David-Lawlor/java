package exampleList;

import java.util.*;

public class TestMyList {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();

        myList.add("Hello");
        myList.add("world");
        System.out.println("The list contains " +
                myList.size() + " elements, and " +
                "the first is " + myList.get(0));

        for (int len = myList.size(), i = 0; i < len; i++) {
            String s = myList.get(i);
            System.out.println("Item " + i + " is " + s);

        }

       //myList.trimToSize();
    }
}




