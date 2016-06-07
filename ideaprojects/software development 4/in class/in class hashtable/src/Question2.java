/*IdeaProjects
  PACKAGE_NAME
  Created by David
  13:17   27/04/2015
  Software Development 3
*/

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Question2 {

    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<Integer>();
        numbers.add(6);
        numbers.add(2);
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(4);
        numbers.add(3);
        removeAdjacentEvens(numbers);

    }

    public static void removeAdjacentEvens(List<Integer> nums) {
        ListIterator<Integer> iter = nums.listIterator();
        boolean lastEven = false;

        while (iter.hasNext()) {
            int current = iter.next();
            boolean currEven = (current % 2 == 0);
            if (lastEven && currEven)
                iter.remove();
            lastEven = currEven;
        }
        System.out.println(nums);
    }
}
