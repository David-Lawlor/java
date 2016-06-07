package example3;

public class TV implements ElectricalDevice {
	int time;
	public void setTimeInUse(int time)
	{
		this.time  = time;
	}
	public int getTimeInUse()
	{
		return time;
	}
	public int getPower()
	{
		return 100;
	}

}
