/**
 * Created by David on 26/09/2014.
 */
public class Employee {
    private String name;
    private int years_service;
    private double salary;

    public Employee(){
        name = "";
        years_service = 0;
        salary = 0;
    }

    public Employee(String nameIn, int yearsIn, double salaryIn){
        name = nameIn;
        years_service = yearsIn;
        salary = salaryIn;
    }

    public void report(){
        System.out.println("Employee ");
        System.out.println("Name: " + name);
        System.out.println("Years service: "+ years_service);
        System.out.println("Salary: " + salary);
    }


}
