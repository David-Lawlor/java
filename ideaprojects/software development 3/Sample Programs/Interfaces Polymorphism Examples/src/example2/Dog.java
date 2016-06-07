package example2;

public class Dog extends Animal implements Worker {
	
	public Dog(String n)
	{
		super(n);
	}
	
	public void speak()
	{
		System.out.println("I bark");
	}
	
	public void work()
	{
		System.out.println("I am a dog who works");
		
	}
}



