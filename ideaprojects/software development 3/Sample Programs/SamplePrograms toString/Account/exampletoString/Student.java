package exampletoString;

public class Student {
	private String idNumber;
	private String name;
	
	public Student()
	{
		idNumber = "X3423456";
		name = "John";
	}
	
	public String toString()
	{
		return "Number:" + idNumber +"\nName: " +name; 
	}

}
