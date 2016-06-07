public class TestProductCollection {
	public static void main (String args[])
	{

	  Product pList[] = new Product[2];
	  
	  pList[0] = new PizzaProduct("Hawaiian", 5.50, 3, .90);
	  pList[1] = new PetrolProduct("Unleaded",.85, 30);
	  
	  for (int i = 0; i < pList.length; i++) {
		  pList[i].calcCost();
		  System.out.println( "Product"+(i+1) +" "+ pList[i].getProductName() + " cost "+ pList[i].totalCost);
	  }
	}

}

