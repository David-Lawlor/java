package ex1;

public class Salaried extends Employee  
{ 
   private double salary; 
   
   public Salaried(String name, double salary)  
   { 
      super(name); 
      this.salary = salary; 
   } 
  
 
   public double pay()  
   { 
      return salary; 
   } 
   
   public void sickpay()  { 
      System.out.println("1 day per month"); 

   } 
 
   public String toString()  
   { 
      return super.toString() + " (salary is " + salary + ")"; 
   } 

  
} 
