
public class PetrolProduct extends Product{
	private double noOfLitres;
	  
	  public PetrolProduct(String petrolType, double pricePerLitre,double noOfLitres)		
	  {
	  	super(petrolType,pricePerLitre);
	  	this.noOfLitres = noOfLitres;	  	
	  }

	  public void calcCost()   			
	  {
	  	totalCost = noOfLitres * getPrice();	  	
	  }

}



