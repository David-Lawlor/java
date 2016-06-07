/*
  Created by David
  01:40  21/10/2014
  Software Development 3
*/

public class HourlyEmployee extends Employee implements IPayable {
    private double hours;
    private double payRate;
    private static int emps = 0;

    public HourlyEmployee(){
        super();
        hours = 0;
        payRate = 0;
    }

    public HourlyEmployee(String fname, String lname, String rsi, double hours, double payRate){
        super(fname, lname, rsi);
        this.hours = hours;
        this.payRate = payRate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getPaymentAmount(){
        double payment = hours * payRate;
        double total = payment;
        if(payment <= 200){}
        else if (payment <= 300)
            payment -= (payment*LTR);
        else{
            payment -=((payment-300)* HTR) +  (300*LTR);
        }
        totalTax += total - payment;
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + getFname()+ " " + getLname() + " is a salaried employee\nWeekly Salary: €"
                + getPaymentAmount() + "\n";
    }
}
