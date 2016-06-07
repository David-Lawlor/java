package Exercise3; /**
 * Created by David on 30/09/2014.
 */
import Exercise3.TaxPayer;

import java.util.Scanner;

public class TestTaxpayer {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int input;

        System.out.println("Enter the number of taxpayers");
        input = in.nextInt();
        double [] salaries = new double[input];
        int [] rsiNums = new int[input];
        TaxPayer[]  t1 = new TaxPayer[input];

        for(int i = 0; i < input; i++){
            System.out.println("Enter the rsi for employee " + (i + 1));
            rsiNums[i] = in.nextInt();
            System.out.println("Enter the salary for employee " + (i + 1));
            salaries[i] = in.nextDouble();
            t1[i] = new TaxPayer(rsiNums[i], salaries[i]);
        }

        for (int i = 0; i < input; i++){
            System.out.println("Taxpayer " + (i+1));
            System.out.println("RSI Number: " + t1[i].getRsiNo());
            System.out.println("Salary: €" + t1[i].getIncome());
        }
    }
}
