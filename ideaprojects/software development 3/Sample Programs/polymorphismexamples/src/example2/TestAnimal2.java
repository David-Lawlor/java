package example2;

public class TestAnimal2
{
    public static void main(String args[])
    {
    	Animal aCollection [] = {new Cat ("Brownie", 14), new Dog ("Minerva", 6), new Cat("Jack", 2), new Cat("Oscar", 5)};
        
        for (int i = 0; i<aCollection.length; i++)
        aCollection [i].makeSound();    
        
        Vet X = new Vet("Bobby Newmark");

		for (int i = 0; i < aCollection.length; i++)
			X.Vaccinate(aCollection[i]);
    }
}



