package example2;

public class Horse extends Animal implements Worker {
	
	public Horse(String n)
	{
		super(n);
	}
		
	public void speak()
	{
		System.out.println("I neigh");
	}
	
	public void work()
	{
		System.out.println("I am a horse who pulls a carriage");
	}
}



