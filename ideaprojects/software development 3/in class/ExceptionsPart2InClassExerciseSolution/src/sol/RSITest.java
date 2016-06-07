package sol;

import java.util.Scanner;

public class RSITest
{
	public static void main (String [] args)
	{	
		Scanner keyboard = new Scanner (System.in);
		String name;
		String socSecNumber;
		String response;
		char answer = 'Y';
		
		while (Character.toUpperCase(answer) == 'Y')
		{
			try
			{
				System.out.print("Name?  ");
				name = keyboard.nextLine();
				System.out.print("RSI Number:   ");
				socSecNumber = keyboard.nextLine();
				if (isValid(socSecNumber))
				{ 	
					System.out.println(name + " " + socSecNumber + " is valid");
				}
			}
			catch (RSIException e)
			{
				System.out.println(e.getMessage());
			}
			System.out.print("Continue?  ");
			response = keyboard.nextLine();
			answer = response.charAt(0);
		}
	}
	
	private static boolean isValid(String number)throws RSIException
	{
		boolean valid = true;
		int index = 0;
		
		if (number.length() != 11)
		{
			throw new RSIException("wrong number of characters ");
		}
		
		while (index < 11)
		{
			if (index == 3 || index == 6)
			{
				if (number.charAt(3) != '-' || number.charAt(6) != '-' )
				{
					throw new RSIException("dashes at wrong positions");
				}
			}
			else if (!Character.isDigit(number.charAt(index)))
			{
				throw new RSIException(
					"contains a character that is not a digit ");
			}
			index++;
		}
		return valid;
	}
}