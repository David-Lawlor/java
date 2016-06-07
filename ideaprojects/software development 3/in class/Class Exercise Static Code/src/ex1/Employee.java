package ex1;
abstract public class Employee  

{
   private String name; 
   
   public Employee(String name)  
   { 
       this.name = name;
   } 
   
   public double pay()
   {
       return 0.0;
   }

   public abstract void sickpay();
  
   public String toString()  
   { 
      return "Name is " + name; 
   } 
  
   
} 
