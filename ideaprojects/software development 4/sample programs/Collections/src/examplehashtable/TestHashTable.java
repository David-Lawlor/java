package examplehashtable;
import java.util.*;

public class TestHashTable {
        public static void main(String args[]) {
            Hashtable<String,Double> balance = new Hashtable<String,Double>();

            double bal;
            balance.put("John Doe", 3434.34);
            balance.put("Tom Smith", 123.22);
            balance.put("Jane Baker", 1378.00);
            balance.put("Todd Hall", 99.22);
            balance.put("Ralph Smith", -19.08);
            //balance.put(null,null);  //nul values not allowed


            Set set = balance.entrySet();
            // Get an iterator
            Iterator i = set.iterator();
            // Show all balances in hash table.
            while(i.hasNext()) {
                Map.Entry me = (Map.Entry)i.next();
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
            System.out.println();
            // Deposit 1,000 into John Doe's account
            bal = ((Double)balance.get("John Doe")).doubleValue();
            balance.put("John Doe", bal + 1000);
            System.out.println("John Doe's new balance: " +
                    balance.get("John Doe"));
        }
    }

