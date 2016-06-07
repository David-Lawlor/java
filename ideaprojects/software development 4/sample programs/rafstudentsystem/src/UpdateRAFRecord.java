import java.io.*;

public class UpdateRAFRecord 
{
	public static void updateRecord(File file, int recordNum, String firstName, String lastName, double gpaValue)
	{
		RAFStudentRecord record = new RAFStudentRecord();
				
		try
		{
			// seek moves the file position pointer for object output
			// based on calculation below
			// Student numbers eneterd should be between 1 and 100	
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			raf.seek ((recordNum - 1) * RAFStudentRecord.SIZE );
			record.read(raf);
			
			// check that there is data in the record
			if( record.getSnum() == 0 )
			{
				System.out.println("ERROR: That record does not exist");
				return;
			}
			
			//record.setSnum(recordNum);
			record.setFirstName(firstName);
			record.setLastName(lastName);
			record.setGpa(gpaValue);
			
			raf.seek((recordNum - 1) * RAFStudentRecord.SIZE);		
			record.write(raf);	
			raf.close();				
		}
		catch(EOFException eof)
		{
			System.out.println("Error:" );
			eof.printStackTrace();
		}
		catch(IOException io)
		{
			System.out.println("Error:" );
			io.printStackTrace();
		}
	}
}


