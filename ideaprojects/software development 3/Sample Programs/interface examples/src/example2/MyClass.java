package example2;

public class MyClass implements Conversions {
	// Implementation of the methods in the interface 
			public double inchToMM(double inches)
				{
					return inches*INCH_TO_MM;
				}
			public double ounceToGram(double ounces)
				{
					return ounces* OUNCE_TO_GRAM;
				}
			public double poundToGram(double pounds)
				{
					return pounds*POUND_TO_GRAM;
				}
			public double HPToWatt(double hp)
				{
					return hp*HP_TO_WATT;
				}
			public double wattToHP(double watts)
				{
					return watts*WATT_TO_HP;
				}

}


