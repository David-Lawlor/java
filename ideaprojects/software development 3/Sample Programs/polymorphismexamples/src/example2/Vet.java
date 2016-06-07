package example2;

public class Vet {
	private String name;

    public Vet() {
        name="";
    }

    public Vet(String name) {
		this.name = name;
	}

	void Vaccinate(Animal m) {
		System.out.println(this.name + " is vaccinating " + m.getName());

		if (m instanceof Cat) {
			Cat c = (Cat) m;
			System.out.println(c.getName() + " is the cat");
			c.purr();
		}

		else if (m instanceof Dog) {
			Dog d = (Dog) m;
			System.out.println(d.getName() + " the dog");
			d.wagTail();
		}

	}
}


