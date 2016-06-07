import java.util.HashMap;
import java.util.Map;

/**
 * Created by DL on 22/04/2015.
 */
public class Exercise2Hashmap {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("render", "to cause to be or become; make");
        dictionary.put("immoderate", "exceeding just or reasonable limits");
        dictionary.put("foliaceous", "pertaining to or consisting of leaves");
        dictionary.put("insubordinate", "not submitting to authority; disobedient");
        dictionary.put("creek", "a stream, brook, or a minor tributary of a river");

        find(dictionary, "render");
        find(dictionary, "insubordinate");
        find(dictionary, "googol");
    }
    public static void find(Map m, String keyword){
        System.out.println("The definition of " + keyword + ": " + m.get(keyword));
    }
}
