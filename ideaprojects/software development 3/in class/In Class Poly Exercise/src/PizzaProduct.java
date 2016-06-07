
public class PizzaProduct extends Product{

		private int noOftoppings;
		private double costPerTopping; 		
			
		// constructor
		public PizzaProduct(String productName, double standardPrice, int noOftoppings, double costPerTopping)		
		{
			super(productName,standardPrice);
			this.noOftoppings = noOftoppings;
			this.costPerTopping	=costPerTopping;

		}

		public void calcCost()   		
		{	
			totalCost = getPrice() + (noOftoppings * costPerTopping);
		}

}



