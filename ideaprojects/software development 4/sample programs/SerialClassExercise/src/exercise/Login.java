package exercise;

import java.io.Serializable;

public class Login implements Serializable {
	private String username;
	private transient String pass;

	public Login(String u, String p) {
		username = u;
		pass = p;
	}

	public String toString() {

		if (pass == null)
			pass = "n/a";

		return ("Username: " + username + " and Password: " + pass);
	}
}
