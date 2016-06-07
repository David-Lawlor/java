import java.io.*;

// subclass of StudentRecord for random access file programs
public class RAFStudentRecord extends StudentRecord
{ 
	// size in bytes of a record
	// RandomAccessStudentRecord contains:
	// studentNum int = 4
	// firstName String = 15 (restricted to 15)
	// lastname String = 15 (restricted to 15)
	// gpaValue double = 8
	// total size of each record = 72
	public static final int SIZE = 72;
	
	// default constructor makes chained constructor call
	public RAFStudentRecord()
	{ 
		this(0,"","",0.0); 
	}

	// call to super class constructor
	public RAFStudentRecord (int snum, String first, String last, double gpa)
	{
		 super(snum,first,last,gpa); 
	}

	// Read one record from the specified RandomAccessFile
	// and call methods defined on superclass, setSnum etc 
	public void read(RandomAccessFile file) throws IOException
	{
		setSnum(file.readInt());
		setFirstName(padName(file));
		setLastName(padName(file));
		setGpa(file.readDouble());
	}

	// used to ensure that name is the proper length
	// reads in 15 characters from the RAF file 
	// and returns a String object
	// if name is shorter then 15 characters then the program
	// fills the extra characters with null bytes ('\0').
	// Swing components and the console cannot display null-byte characters
	// instead they will display rectangles
	// -- solved by replacing null bytes with spaces
	
	private String padName(RandomAccessFile f)throws IOException 
	{ 
		char name[] = new char[15]; 
		char temp;
		String nameString =null;
		
		for (int i = 0; i < name.length; i++) 
		{
			temp = f.readChar();
			name[i] = temp;	
		}
		
		nameString = new String(name); 	// create new String using char[]
		nameString = nameString.replace('\0',' ');	//replace null bytes with spaces
		return nameString;  
	}

	//Write one specified record to the RandomAccessFile 
	public void write (RandomAccessFile file ) throws IOException 
	{ 
		file.writeInt(getSnum());
		writeName(file, getFirstName());//exactly 15 characters 
		writeName(file, getLastName()); //exactly 15 characters
		file.writeDouble(getGpa());
	} 

	// ensure all records are the same length by writing exactly 15 
	// characters for first name and last name 
	// A string buffer implements a mutable sequence of characters. A 
	// string buffer is like a String, but can be modified. At any point 
	// in time it contains some particular sequence of characters, but the 
	// length and content of the sequence can be changed through certain method calls.
	
	private void writeName(RandomAccessFile f , String name) throws IOException
	{ 
		StringBuffer buf = null;
		
		if (name != null) 
			buf = new StringBuffer(name);
		else
			buf = new StringBuffer(15);

		buf.setLength(15); 
		f.writeChars(buf.toString()); 
	} 

	
} 

