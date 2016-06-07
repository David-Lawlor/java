package implementsRunnable;

class countDown implements Runnable {
	public void run() {
		for (int i = 10; i >= 0; i--) {
			System.out.println("Countdown: " + i);
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		Thread cd = new Thread(new countDown(), "cd");
		cd.start();
		for (int i = 10; i >= 0; i--) {
			System.out.println("ThreadDemo: " + i);
		}

	}
}
