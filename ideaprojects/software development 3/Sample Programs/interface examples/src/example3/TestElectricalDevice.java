package example3;
 public class TestElectricalDevice
 {
 	public static void main(String args[])
 	{
 		TV myTV = new TV();
 		
 		myTV.setTimeInUse(50);
 		int powerUsed = myTV.getTimeInUse() * myTV.getPower();
 		
 		System.out.println(" Power used for this session = " + powerUsed);
 		myTV.setTimeInUse(0); //reinitialise the time in use
 	}
 }
 	

