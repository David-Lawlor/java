import java.util.DoubleSummaryStatistics;

/**
 * Created by DL on 29/04/2015.
 */
public class PairTest {
    public static void main(String[] args) {
        GenericPair<String> ps = new GenericPair<>("Happy", "Sad");
        GenericPair<Double> pd = new GenericPair<>(2.5,5.7);
        System.out.println(ps);
        System.out.println(pd);

        ps.setFirst("Very");
        pd.setSecond(-3.4);
        System.out.println(ps);
        System.out.println(pd);

        GenericPair<String> ps2 = new GenericPair<>("One", "Two");
        GenericPair<GenericPair<String>> pps = new GenericPair<>(ps,ps2);
        System.out.println(pps);

    }
}
