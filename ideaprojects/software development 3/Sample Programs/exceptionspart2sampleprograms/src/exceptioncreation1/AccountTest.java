package exceptioncreation1;

public class AccountTest {
	public static void main(String[] args) {
		// Force a NegativeStartingBalance exception.
		try {
			BankAccount account = new BankAccount(1, -0.04);
		} catch (NegativeStartingBalance e) {
			System.out.println(e.getMessage());
		}
        catch (NegativeInterestRate e) {
            System.out.println(e.getMessage());
        }
    }
}


