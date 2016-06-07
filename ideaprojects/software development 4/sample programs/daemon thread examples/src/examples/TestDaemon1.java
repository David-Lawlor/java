package examples;

class DaemonThread1 implements Runnable {
	public void run() {
		System.out.println("Entering run method");
		try {
			System.out.println("In run Method: currentThread() is"
					+ Thread.currentThread());

			while (true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException x) {
					System.out.println("Exception caught");
				}

				System.out.println("In run method: woke up again");
			}
		} finally {
			System.out.println("Finally - Leaving run Method");
		}
	}
}

public class TestDaemon1 {
	public static void main(String[] args) {
		System.out.println("Entering main Method");
		Thread t = new Thread(new DaemonThread1(), "one");
		t.setDaemon(true);
		t.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException x) {
			System.out.println("Exception caught");
		}

		System.out.println("Leaving main method");
	}
}
