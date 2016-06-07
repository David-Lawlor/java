package examples;
import java.io.*;

public class IO {
	public static void main (String args[]) throws IOException {
		int i; float f; String s;
		
		BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Console I/O Demo: ");
		System.out.print(" Enter a string: ");
		
		s = keyboardInput.readLine();
		System.out.println(" " + s);
		System.out.print(" Enter an int: ");
		
		i = Integer.parseInt(keyboardInput.readLine());
		System.out.println(" " + i);
		System.out.print(" Enter a float: ");
		
		f = Float.parseFloat(keyboardInput.readLine());
		System.out.println(" " + f); 
		}
}    

