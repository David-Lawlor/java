package examples;

class daemonThread implements Runnable {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("daemonThread " + i);

		}
	}

}
public class TestDaemon {
	public static void main(String args[]) {
		Thread one = new Thread(new daemonThread(), "one");
		one.setDaemon(true);
		one.start();
		System.out.println("main() Thread " + Thread.currentThread());

	}
}



