import java.io.*;

public class DisplayMenu 
{
	public static void main(String args[])throws IOException
	{
		BufferedReader keyboardInput;
		keyboardInput = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("Please enter the name and location of the file you wish to create");
		System.out.println("For Example: files\\students.txt");
		String fileName =  keyboardInput.readLine();
		CreateRAF create = new CreateRAF(fileName);

		File file = create.getFile();
		
		// infinite loop
		while(true)
		{
			System.out.println("Please press 1 to enter student details");
			System.out.println("Please press 2 if you want to view student details");
			System.out.println("Please press 3 to delete a student record");
			System.out.println("Please press 4 to update a record");
			System.out.println("Press 5 to quit");
		
			int choice = Integer.parseInt(keyboardInput.readLine());
		
			if(choice  ==  1)
			{	
				System.out.println("please enter the Student Number");
				int num = Integer.parseInt(keyboardInput.readLine());
				System.out.println("please enter the first name");
				String first = keyboardInput.readLine();
				System.out.println("please enter the last name");
				String last = keyboardInput.readLine();
				System.out.println("please enter the gpa");
				double gpa = Double.parseDouble(keyboardInput.readLine());
			
				// call static method to write RAF record to file
				WriteRAFRecord.writeRecord(file,num,first,last,gpa);
			}
			else if (choice == 2)
			{
				System.out.println("Please enter the number of the record you wish to view");
				int recordNum = Integer.parseInt(keyboardInput.readLine());
			
				// call static method to read record from RAF file
				ReadRAFRecord.readRecord(file,recordNum);
			}
			else if (choice == 3)
			{
				System.out.println("Please enter the number of the record you wish to delete");
				int recordNum = Integer.parseInt(keyboardInput.readLine());
			
				// call static method to delete record from RAF file
				DeleteRAFRecord.deleteRecord(file,recordNum);
			}
			else if (choice == 4)
			{
				System.out.println("Please enter the number of the record you wish to update");
				int recordNum = Integer.parseInt(keyboardInput.readLine());
				
				System.out.println("please enter the first name");
				String first = keyboardInput.readLine();
				System.out.println("please enter the last name");
				String last = keyboardInput.readLine();
				System.out.println("please enter the gpa");
				double gpa = Double.parseDouble(keyboardInput.readLine());
			
				// call static method to delete record from RAF file
				UpdateRAFRecord.updateRecord(file,recordNum,first,last,gpa);
			}
			else
			{
				System.exit(0);
			}			
		}
	}
}	
		
		
	  
			
		