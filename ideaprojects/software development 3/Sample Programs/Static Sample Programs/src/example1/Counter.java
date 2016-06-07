package example1;

/**
 * Created by Patricia on 07/10/2014.
 */
public class Counter {
    private static int numCounters = 0;   // shared
    private int data; 	                // one per object

    public Counter(int d)
    {
        numCounters++;
        data = d;
    }

    public int getData()
    {
        return data;
    }

    public static int getNumCounters()
    {
        return numCounters;
    }
}
