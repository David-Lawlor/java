package exampleMap;
import java.util.*;
class Example2 {
    public static void main(String args[]) {
        // Create a hash map
        Map<String,Double> hm = new HashMap<String,Double>();
        // Put elements to the map
        hm.put("John Doe", 3434.34);
        hm.put("Tom Smith", 123.22);
        hm.put("Jane Baker", 1378.00);
        hm.put("Todd Hall", 99.22);
        hm.put("Ralph Smith", -19.08);
        hm.put(null,null);  // null values allowed
        // Get a set of the entries
        Set set = hm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }





        //Deposit 1000 into John Doe's account
        double balance = (Double) hm.get("John Doe");
        hm.put("John Doe", balance + 1000);
        System.out.println("John Doe's new balance: " +
                hm.get("John Doe"));
    }
}



