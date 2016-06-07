package countdown;

class Countdown {
	public void run() {
		for (int i = 10; i >= 0; i--) {
			System.out.println("Countdown: " + i);
		}
	}

}

public class MainThreadDemo {
	public static void main(String[] args) {
		Countdown cd = new Countdown();
		cd.run();
	}

}



