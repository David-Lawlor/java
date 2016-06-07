package Exercise2;

/**
 * Created by David on 14/10/2014.
 */
public class Hourly extends Employee {
    private int hoursWorked;

    public Hourly(String nameIn, String addressIn, String phNumIn, String rsiNumIn, double salaryIn){
        super(nameIn, addressIn, phNumIn, rsiNumIn, salaryIn);
        hoursWorked = 0;
    }

    public void addHours(int hoursIn){
        hoursWorked += hoursIn;
    }

    public double pay(){
        return hoursWorked * super.pay();
    }

    public String toString() {
        return  (super.toString() + "\nCurrent Hours: " + hoursWorked);
    }
}
