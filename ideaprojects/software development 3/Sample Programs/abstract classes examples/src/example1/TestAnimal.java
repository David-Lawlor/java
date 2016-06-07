package example1;

public class TestAnimal {
    public static void main(String[] args) {
        Animal animal1, animal2;
        animal1 = new Cat("Brownie");
        animal2 = new Dog("Minerva");
        animal1.makeSound();                  // polymorphic method call
        animal2.makeSound();
    }
}



