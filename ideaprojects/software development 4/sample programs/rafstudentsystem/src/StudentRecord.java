// this class represents one record of information
public class StudentRecord 
{	
	private int studentNum;
	private String firstName;
	private String lastName; 
	private double gpaValue; 

	// Default constructor
	// chained constructor call 
	public StudentRecord()
	{ 
		this(0,"","",0.0); 
	}

	public StudentRecord(int snum, String first, String last, double gpa)
	{
		setSnum(snum);
		setFirstName(first);
		setLastName(last);
		setGpa(gpa);
	}

	public void setSnum(int snum)
	{ 
		studentNum = snum;
	} 

	public void setFirstName(String first) 
	{ 
		firstName = first;
	} 
	
	public void setLastName(String last) 
	{ 
		lastName = last;
	} 

	public void setGpa(double gpa)
	{
		gpaValue = gpa;
	} 

	public int getSnum()
	{
		return studentNum;
	}

	public String getLastName()
	{ 
		return lastName;
	} 

	public String getFirstName()
	{ 
		return firstName;
	}

	public double getGpa()
	{ 
		return gpaValue;
	}
} 





