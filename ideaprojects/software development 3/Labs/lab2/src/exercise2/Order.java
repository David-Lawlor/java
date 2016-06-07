package exercise2;

/**
 * Created by David on 23/09/2014.
 */
public class Order {
// declarations
    private String customerName;
    private int customerNumber;
    private int quantityOrdered;
    private double unitPrice;
    protected double totalPrice;

// constructor
    public Order(String nameIn, int numIn, int ordered, double unitPriceIn){
        customerName = nameIn;
        customerNumber = numIn;
        quantityOrdered = ordered;
        unitPrice = unitPriceIn;
    }

// setters for variables
    public void setCustomerName(String nameIn){
        customerName = nameIn;
    }
    public void setCustomerNumber(int numIn){
        customerNumber = numIn;
    }
    public void setQuantityOrdered(int ordered){
        quantityOrdered = ordered;
    }
    public void setUnitPrice(double priceIn){
        unitPrice = priceIn;
    }

// getters for variables
    public String getCustomerName(){
        return customerName;
    }
    public int getCustomerNumber(){
        return customerNumber;
    }
    public int getQuantityOrdered(){
        return quantityOrdered;
    }
    public double getUnitPrice(){
        return unitPrice;
    }

// method to calculate total price
    public void calcTotalPrice(){
        totalPrice = quantityOrdered * unitPrice;
    }

// print method
    public void print(){
        System.out.println("Customer name: " + customerName);
        System.out.println("Customer Number: " + customerNumber);
        System.out.println("Quantity Ordered: " + quantityOrdered);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Total Price: " + totalPrice);
    }


}
