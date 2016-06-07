package Exercise2;

/**
 * Created by David on 14/10/2014.
 */
public class Commission extends Hourly{
    private double totalSales;
    private double commissionRate;

    public Commission(String nameIn, String addressIn, String phNumIn, String rsiNumIn, double salaryIn,double commissionRateIn) {
        super(nameIn, addressIn, phNumIn, rsiNumIn, salaryIn);
        totalSales = 0;
        commissionRate = commissionRateIn;
    }

    public void addSales(double salesIn){
        totalSales = salesIn;
    }

    public double pay(){
        return super.pay() + (totalSales * commissionRate);
    }

    public String toString(){
        return super.toString() + "\nTotal Sales: " + totalSales;
    }




}
