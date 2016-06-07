package examples;
import java.io.*;

public class CharInput {
	public static void main(String[] args) throws IOException {
		
		String s; 
		InputStreamReader ir;
		BufferedReader in;
		
		ir= new InputStreamReader(System.in);
		in = new BufferedReader(ir);
	    
		System.out.println("Type in any stream of characters please !!!");
		while ((s=in.readLine()) != null)
			{
				System.out.println("Just read the following character stream: " + s);
			}
		}	
} 



