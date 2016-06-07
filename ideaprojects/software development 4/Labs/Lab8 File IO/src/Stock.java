import java.io.Serializable;

/**
 * Created by DL on 17/03/2015.
 */
public class Stock implements Serializable{
    private int idNumber;
    private String descriptions;
    private int quantity;

    public Stock(int idNumber, String descriptions, int quantity){
        this.idNumber = idNumber;
        this.descriptions = descriptions;
        this.quantity = quantity;
    }

    public String toString(){
        return ("ID Number " + idNumber + " Description " + descriptions + " Quantity " + quantity);
    }

}
