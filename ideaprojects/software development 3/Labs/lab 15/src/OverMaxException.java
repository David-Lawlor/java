/**
 * Created by DL on 17/11/2014.
 */
public class OverMaxException extends Exception {
    public OverMaxException(){
        super("Warning: Stock is over the maximum allowed limit");
    }
}
