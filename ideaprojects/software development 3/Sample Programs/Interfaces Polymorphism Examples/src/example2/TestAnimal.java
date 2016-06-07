package example2;

public class TestAnimal {
	public static void main(String args[]) {
		Worker workers[] = { new Dog("Rover"), new Horse("Black Beauty"),
				new EmpAgency() };

		for (int i = 0; i < workers.length; i++) {
			workers[i].work();

			if ((workers[i] instanceof Dog) || (workers[i] instanceof Horse)) {
				((Animal) workers[i]).speak();
			} else {
				((EmpAgency) workers[i]).interview();
			}
		}
	}
}



