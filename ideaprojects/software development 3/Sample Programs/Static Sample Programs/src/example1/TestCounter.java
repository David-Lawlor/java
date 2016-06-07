package example1;

/**
 * Created by Patricia on 07/10/2014.
 */
public class TestCounter {
    public static void main (String args[])
    {
        Counter c1 = new Counter(5);
        Counter c2 = new Counter(6);
        Counter c3 = new Counter(7);

        System.out.println("The number of counters is: "+ Counter.getNumCounters()+"\n");
        System.out.println("Counter is: "+ c1.getData()+"\n");
        System.out.println("Counter is: "+ c2.getData()+"\n");
        System.out.println("Counter is: "+ c3.getData()+"\n");
    }
}
