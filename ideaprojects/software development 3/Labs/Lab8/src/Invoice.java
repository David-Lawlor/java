/*
  Created by David
  01:09   21/10/2014
  Software Development 3
*/
public class Invoice implements IPayable {
    private String description;
    private String number;
    private double price;
    private int quantity;
    private static int invoices = 0;
    private static double totalVAT = 0;

    public Invoice(){
        this.description = "";
        this.number = "";
        this.price = 0;
        this.quantity = 0;
        invoices++;
    }

    public Invoice(String description, String number, double price, int quantity){
        this.description = description;
        this.number = number;
        this.price = price;
        this.quantity = quantity;
        invoices++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPaymentAmount(){
        totalVAT  += (price * quantity)* (VATR);
        return (price * quantity)* (VATR + 1);
    }

    public static int getInvoices() {
        return invoices;
    }

    public static double getTotalVAT() {
        return totalVAT;
    }

    public String toString(){
        return ("Invoice\nQuantity= "+ quantity + "\nPricePerItem=" + price + "\nPartNumber='"+ number +
                "'\nPartDescription='"+ description + "'\nAmount Due: €" + getPaymentAmount() + "\n");
    }
}
