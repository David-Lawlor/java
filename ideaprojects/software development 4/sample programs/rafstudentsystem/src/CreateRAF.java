import java.io.*;

// demonstrates process of opening a randon access file
// and writing the data to disk
// this program writes 100 blank RandomAccessStudentRecord (size 72)
// the file is initialised in this way to create the proper amount of 
// space for each record

public class CreateRAF
{
	private static final int NUMBER_RECORDS = 100;

	//set up record and file objects 
	private RAFStudentRecord blankRecord;
	private RandomAccessFile raf = null;
	private File fileName;
	
	public CreateRAF(String fileName)
	{
		blankRecord = new RAFStudentRecord();
		this.fileName = new File(fileName);
		openFile(); 
	} 

	private void openFile()
	{			
		if (fileName == null || fileName.getName().equals(""))
		{
			System.out.println("Invalid File name");
		} 
		else //open the file
		{
			try 
			{
				raf = new RandomAccessFile( fileName, "rw"); 
				
				// write 100 blank records
				// each record with a size of 72
				for (int count = 0; count < NUMBER_RECORDS; count++)
				{ 
					blankRecord.write(raf);
				}
				raf.close();					
			} 
			catch (IOException e) 
			{
				e.printStackTrace(); 
				System.exit(0);
			}
		} 
	} 
	
	public File getFile()
	{
		return fileName;
	}
} 


