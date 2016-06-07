package exampleMap;

import java.util.*;

public class Example1 {
    public static void main(String[] args) {
        Map<String,String> countryNames = new HashMap<String,String>();

        countryNames.put("GB", "Great Britain");
        countryNames.put("FR", "France");
        countryNames.put("IT", "Italy");
        countryNames.put("FW", "Far Far Away");

        String name = countryNames.get("It");

        System.out.println(name);

    }
}




