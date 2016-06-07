/**
 * Created by David on 26/09/2014.
 */
public class Salesperson extends Employee {
    private double[] sales;

    public Salesperson(String nameIn, int yearsIn, double salaryIn, int days){
        super(nameIn, yearsIn, salaryIn);
        sales = new double[days];
    }

    public void fillSales (int day, double saleIn){
        sales[day] = saleIn;
    }

    public void report (){
        super.report();
        double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, totalSales = 0;
        int noSales = 0;
        for (int i = 0; i < sales.length; i++) {
            if (min > sales[i])
                min = sales[i];
            if (max < sales[i])
                max = sales[i];
            if (sales[i] == 0)
                noSales++;
            totalSales += sales[i];
        }
        System.out.println("Total Sales is: " + totalSales);
        System.out.println("Max Sales is: " + max);
        System.out.println("Min Sales is: "  + min);
        System.out.println("Number of days with no sales is: " + noSales);
        }
}


