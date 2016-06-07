import java.io.*;

// reads 1 record from file
public class ReadRAFRecord 
{
	public static void readRecord(File file, int recordNum)
	{
		RAFStudentRecord record = new RAFStudentRecord();			
		try
		{
			// seek moves the file position pointer for object output
			// based on calculation below
			// Student numbers entered should be between 1 and 100	
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			raf.seek ((recordNum - 1) * RAFStudentRecord.SIZE );
			record.read(raf);
			
			// check that there is data in the record
			if( record.getSnum() == 0 )
			{
				System.out.println("ERROR: That record does not exist");
				return;
			}
				
			String values[] = {String.valueOf(record.getSnum()), record.getFirstName(), 
									record.getLastName(), String.valueOf(record.getGpa())};
				
			for (int i = 0; i < values.length; i++)
				System.out.println(values[i]);
			
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
