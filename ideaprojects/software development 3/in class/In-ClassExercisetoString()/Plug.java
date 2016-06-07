public class Plug extends VehiclePart
{
	private double temp;
	
	public Plug(String p, String d, double pr, String s, double t)
	{
		super(p, d, pr, s);
		this.temp = t;
	}
	
	public String toString()
	{
		return super.toString()+ "\nTemperature:	"+temp;
	}
}

