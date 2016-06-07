package Exercise2;

/**
 * Created by David on 14/10/2014.
 */
public class Employee extends StaffMember {
    private String rsiNum;
    private double salary;

    public Employee(String nameIn, String addressIn, String phNumIn, String rsiNumIn, double salaryIn){
        super(nameIn, addressIn, phNumIn);
        rsiNum = rsiNumIn;
        salary = salaryIn;
    }

    public double pay(){
        return salary;
    }

    public String toString(){
        return super.toString() + ("\nRSI Number: " + rsiNum );
    }
}
