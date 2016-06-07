package example2;

public class Animal
{
    private String animalName;
    private int animalAge;

    public Animal()
        {
            animalName="";
            animalAge=0;
        }
    public Animal(String name, int age)
        {
            animalName = name;
            animalAge = age;
        }

        
        public void makeSound()
        {
        }
        
        public String getName()
        {
        	return animalName;
        }
        
        public int getAge()
        {
        	return animalAge;
        }
}


