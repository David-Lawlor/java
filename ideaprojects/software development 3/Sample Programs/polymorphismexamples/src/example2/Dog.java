package example2;

class Dog extends Animal
{
    public Dog(String name, int age)
    {
        super(name, age);
    }
    

    public void makeSound()
    {
        System.out.println("Bow Wow");
    }
    
    public void wagTail()
    {
    	System.out.println(getName() + " is wagging his tail");
    }
}




