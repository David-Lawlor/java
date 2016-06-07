package exampleMap;


import java.util.HashMap;
import java.util.Map;

public class Example4 {
    public static void main(String[] args) {
        Map<String,String> countryNames = new HashMap<String,String>();

        countryNames.put("Cuba", "Havana");
        countryNames.put("Spain", "Madrid");
        countryNames.put("France", "Paris");
        countryNames.put("England", "London");

        String name = countryNames.get("It");

        System.out.println(name);

    }
}
