public class Product {
	 private String productName;
	  private double productPrice;
	  protected double totalCost;		
	  
	  public Product(String name, double price)		// constructor	
	  {
	    productName = name;	
	    productPrice = price;						// set the name and price
	    totalCost = 0;
	  }

	  public void calcCost()   			
	  { 
	  }


	  public double getPrice()
	  { 
	    return productPrice;
	  }
	  
	  public String getProductName()
	  { 
	    return productName;
	  }

}
