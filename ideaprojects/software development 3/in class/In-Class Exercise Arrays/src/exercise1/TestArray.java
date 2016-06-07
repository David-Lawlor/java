package exercise1;

/**
 * Created by pmagee on 24/09/2014.
 */
public class TestArray {
    public static void main(String args[])
    {
        int[] numbers = {10, 20, 30, 43};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        double average = 0.0;



        for(int i=0;i<numbers.length;i++)
        {
            if(numbers[i] > max)
                max = numbers[i];

            if (numbers[i] < min)
                min = numbers[i];

            sum += numbers[i];
        }

        average = sum/numbers.length;

        System.out.println("The largest number in the array is:"+max);
        System.out.println("The smallest number in the array is:"+min);
        System.out.println("The average of all numbers in the array is:"+average);

        System.out.println("Array Contents");
        for(int i : numbers){
            System.out.println(i);
        }
    }
}
