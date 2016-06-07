package Exercise1;

/**
 * Created by David on 15/10/2014.
 */
public class Goods {
    private String description;
    private double price;

    public Goods(String desc, double p){
        description = desc;
        price = p;
    }

    public double getPrice(){
        return price;
    }

    public void display(){
        System.out.println("Description; " + description);
        System.out.println("Price: " + price);
    }
}
