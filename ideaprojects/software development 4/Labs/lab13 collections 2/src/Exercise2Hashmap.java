import java.util.*;

/**
 * Created by DL on 29/04/2015.
 */
public class Exercise2Hashmap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input;
        Map<Integer, Integer> nums = new HashMap<>();
        do {
            System.out.println("Enter number");
            input = in.nextInt();
            if(input != -1) {
                if (nums.containsKey(input))
                    nums.put(input, (nums.get(input) + 1));
                else
                    nums.put(input, 1);
            }
        }while (input != -1);
        print(nums);
    }
    static void print(Map<Integer, Integer> nums){
        int number;
        Set<Integer> numbers = nums.keySet();
        Iterator<Integer> iter = numbers.iterator();
        while (iter.hasNext()) {
            number = iter.next();
            System.out.println("The number "+ number + " occurred " + nums.get(number) + " times");
        }
//        for (Integer number1 : numbers) {
//            number = number1;
//            System.out.println("The number " + number + " occurred " + nums.get(number) + " times");
//        }
    }
}

