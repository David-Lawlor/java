public class VehiclePart
{
	private String partNumber;
	private String description;
	private double price;
	private String supplier;
	
	VehiclePart(String partNumber, String description, double price, String supplier)
	{
		this.partNumber = partNumber;
		this.description = description;
		this.price = price;// this is the price in Pound Sterling
		this.supplier = supplier;
	}
	
	public double getPriceInPoundsSterling()
	{
		return price;
	}
	
	public double getPriceInEuros()
	{
		return (price/.8);
	}
	
	public String toString()
	{
		return "Part Number:   "+partNumber +"\nDescription:   "+description
						+"\nPrice:         "+price +"\nSupplier:      "+supplier;
	}
}
