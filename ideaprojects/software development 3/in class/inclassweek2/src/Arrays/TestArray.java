package Arrays;

/**
 * Created by David on 24/09/2014.
 */
public class TestArray {
    public static void main (String [] args){

        int[] numbers = {10,20,30,40,50};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0.0, average = 0;


        for (int i = 0; i < numbers.length; i++){
            if(numbers[i] > max)
               max = numbers[i];

            if(numbers[i] < min)
                min = numbers[i];

            sum += numbers[i];
        }

        average = sum/numbers.length;
        System.out.println("The largest number in the array is " + max);
        System.out.println("The smallest number in the array is " + min);
        System.out.println("The average of all numbers is " + average);
    }
}
