/**
 * Created by DL on 17/11/2014.
 */
public class BelowMinException extends Exception {
    public BelowMinException(){
        super("Warning: Stock below acceptable minimum level");
    }
}
