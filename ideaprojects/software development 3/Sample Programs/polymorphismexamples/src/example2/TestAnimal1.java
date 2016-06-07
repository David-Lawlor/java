package example2;

public class TestAnimal1
{
    public static void main(String args[])
    {     
    	Animal animal1, animal2;
    	animal1 = new Cat("Brownie",14);
    	animal2 = new Dog("Minerva",6);
   	    animal1.makeSound();                  // polymorphic method call
        animal2.makeSound();      
    }
}



