package ex1;

class NamePrinter implements Runnable {
	private String name;

	public NamePrinter(String name) {
		this.name = name;
	}

	public void run() {
		for (int b = 0; b < 5; b++) {
			System.out.println(this.name + ": " + b);
		}

		System.out.println(this.name + " has finished");

	}
}

public class MixedPriorityTest {
	public static void main(String args[]) {
		Thread frank, mary, chris;

		chris = new Thread(new NamePrinter("Chris"));
		frank = new Thread(new NamePrinter("Frank"));
		mary = new Thread(new NamePrinter("Mary"));

		chris.setPriority(Thread.MAX_PRIORITY);
		frank.setPriority(Thread.MIN_PRIORITY);
		mary.setPriority(Thread.NORM_PRIORITY);


		frank.start();
		mary.start();
        chris.start();

	}
}
