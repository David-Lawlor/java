package example2;

class Cat extends Animal
{
    public Cat(String name, int age)
    {
        super(name, age);
    }

    public void makeSound()
    {
        System.out.println("Meow");
    }
    public void purr()
    {
    	System.out.println(getName() + " is purring");
    }
    
}



