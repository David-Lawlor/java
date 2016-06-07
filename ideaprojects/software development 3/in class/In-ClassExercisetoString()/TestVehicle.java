public class TestVehicle
{
	public static void main(String args[])
	{	
		Plug y = new Plug("xyz", "a plug", 5, "new Supplier", 35.0);		
		System.out.println(y);
		System.out.println("Price in Euros: €"+y.getPriceInEuros());
		System.out.println("Price in Sterling: £"+y.getPriceInPoundsSterling());		
	}
}


