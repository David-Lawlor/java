package example2;

public abstract class Animal {
	private String name;

	public Animal(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	public abstract void speak();
}
