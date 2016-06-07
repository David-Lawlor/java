/*
  Created by David
  01:18  21/10/2014
  Software Development 3
*/

public abstract class Employee implements IPayable{
    private String fname;
    private String lname;
    private String rsi;
    private static int emps = 0;
    protected static double totalTax = 0;

    public Employee() {
        this.fname = "";
        this.lname = "";
        this.rsi = "";
        emps++;
    }

    public Employee(String fname, String lname, String rsi) {
        this.fname = fname;
        this.lname = lname;
        this.rsi = rsi;
        emps++;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRsi() {
        return rsi;
    }

    public void setRsi(String rsi) {
        this.rsi = rsi;
    }

    public static int getEmps() {
        return emps;
    }

    public static double getTotalTax() {
        return totalTax;
    }

    @Override
    public String toString() {
        return ("Employee:" + "\nFirst Name='" + fname + "'" + "\nLast Name='" + lname + "'" +
                "\nRSI Number='" + rsi + "'" );
    }
}
