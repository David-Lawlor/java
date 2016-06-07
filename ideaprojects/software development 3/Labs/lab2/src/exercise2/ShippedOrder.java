package exercise2;

/**
 * Created by David on 23/09/2014.
 */
public class ShippedOrder extends Order {
// constructor
    public ShippedOrder(String nameIn, int numIn, int ordered, double unitPriceIn){
        super(nameIn, numIn, ordered, unitPriceIn);
    }

// overridden total price method
    public void calcTotalPrice(){
        super.calcTotalPrice();
        totalPrice += 5;
    }

// overridden print method
    public void print(){
        super.print();
        System.out.println("Shipping has been added");
    }
}
