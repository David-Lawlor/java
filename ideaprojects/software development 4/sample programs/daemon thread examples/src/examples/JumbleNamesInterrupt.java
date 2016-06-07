package examples;

import java.io.IOException;

public class JumbleNamesInterrupt implements Runnable {
	private String firstName; // Store for first name
	private String secondName; // Store for second name
	private long aWhile; // Delay in milliseconds

	// Constructor
	public JumbleNamesInterrupt(String firstName, String secondName, long delay) {
		this.firstName = firstName; // Store the first name
		this.secondName = secondName; // Store the second name
		aWhile = delay; // Store the delay
	}

	// Method where thread execution will start
	public void run() {
		try {
			while (true) // Loop indefinitely...
			{
				System.out.print(firstName); // Output first name
				Thread.sleep(aWhile); // Wait aWhile msec.
				System.out.print(secondName + "\n"); // Output second name
			}
		} catch (InterruptedException e) // Handle thread interruption
		{
			System.out.println(firstName + secondName + e); // Output the
															// exception
		}
	}

	public static void main(String[] args) {
		// Create three threads
		Thread first = new Thread(new JumbleNamesInterrupt("Hopalong ",
				"Cassidy ", 200L));
		Thread second = new Thread(new JumbleNamesInterrupt("Marilyn ",
				"Monroe ", 300L));
		Thread third = new Thread(new JumbleNamesInterrupt("Slim ", "Pickens ",
				500L));

		// Set threads as daemon
		first.setDaemon(true);
		second.setDaemon(true);
		third.setDaemon(true);

		System.out.println("Press Enter when you have had enough...\n");
		first.start(); // Start the first thread
		second.start(); // Start the second thread
		third.start(); // Start the third thread
		try {
			System.in.read(); // Reads the next byte of data from the input
								// stream
			System.out.println("Enter pressed...\n");

			first.interrupt();
			second.interrupt();
			third.interrupt();
		} catch (IOException e) // Handle IO exception
		{
			System.out.println(e); // Output the exception
		}
		System.out.println("Ending main()");
		return;
	}
}
