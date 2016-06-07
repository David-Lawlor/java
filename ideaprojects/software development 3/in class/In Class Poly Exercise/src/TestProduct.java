public class TestProduct {
	public static void main (String args[])
	{
	  Product p1; 
	  Product p2; 
	  
	  p1 = new PizzaProduct("Hawaiian", 5.50, 3, .90);
	  p2 = new PetrolProduct("Unleaded",.85, 30);
	  
	  p1.calcCost();
	  p2.calcCost();
	  
      System.out.println( "Product 1 " + p1.getProductName() + " cost "+ p1.totalCost);
      System.out.println( "Product 2 " + p2.getProductName() + " cost "+ p2.totalCost);

	}

}


