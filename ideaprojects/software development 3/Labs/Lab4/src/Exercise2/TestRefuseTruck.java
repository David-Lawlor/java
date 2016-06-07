package Exercise2; /**
 * Created by David on 03/10/2014.
 */
import Exercise2.RefuseTruck;

import java.util.Scanner;

public class TestRefuseTruck {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int binInput;
        double rateInput;

        System.out.println("Enter maximum number of bins");
        binInput = in.nextInt();
        System.out.println("Enter rate per kilo of bins");
        rateInput = in.nextDouble();
        RefuseTruck t1 = new RefuseTruck(binInput,rateInput);

        while (t1.getNoOfBinsCollected() < t1.getMaxBins()){
            System.out.println("Enter the weight of bin");
            t1.collectBin(in.nextDouble());
        }

        t1.printStats();

    }
}
