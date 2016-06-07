package exceptioncreation1;

/**
 * Created by pmagee on 05/11/2014.
 */
public class NegativeInterestRate extends Exception{
    public NegativeInterestRate() {
        super("Error: Negative Interest Rate");
    }
    public NegativeInterestRate(double rate) {
        super("Error: Negative Interest Rate: " + rate);
    }
}


