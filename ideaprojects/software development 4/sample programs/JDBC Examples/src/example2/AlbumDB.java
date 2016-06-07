package example2;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AlbumDB {

	private Connection conn;
	private Statement stmt;
	private ResultSet rset;

	public void openDB() {
        String url;
        Scanner in = new Scanner(System.in);
		try {
			// Load the Oracle JDBC driver
			OracleDataSource ods = new OracleDataSource();

            System.out.println("Type global1 or home");
            String val = in.nextLine();

            if(val.equals("global1"))
            {
                ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
                System.out.println("Enter your user name:");
                String uName = in.nextLine();
                ods.setUser(uName);
                System.out.println("Enter your password:");
                String uPass = in.nextLine();
                ods.setPassword(uPass);
            }
            else if(val.equals("home"))
            {
                ods.setURL("jdbc:oracle:thin:hr/hr@localhost:1521/XE");
                System.out.println("Enter your user name:");
                String uName = in.nextLine();
                ods.setUser(uName);
                System.out.println("Enter your password:");
                String uPass = in.nextLine();
                ods.setPassword(uPass);
            }

			conn = ods.getConnection();
			System.out.println("connected.");
		} catch (Exception e) {
			System.out.print("Unable to load driver " + e);
			System.exit(1);
		}
	}

	public void CreateAlbum() {

		try {
			stmt = conn.createStatement();

			stmt.executeUpdate("DROP TABLE Album");

			stmt.executeUpdate("CREATE TABLE Album "
					+ "(id NUMBER PRIMARY KEY, title VARCHAR2(40), artist VARCHAR2(30))");

			stmt.executeUpdate("INSERT INTO Album "
					+ "VALUES (1, 'Strangeland', 'Keane')");

			stmt.executeUpdate("INSERT INTO Album "
					+ "VALUES (2, 'Hopes and Fears', 'Keane')");

			stmt.executeUpdate("INSERT INTO Album "
					+ "VALUES (3, 'Parachutes', 'ColdPlay')");

			stmt.executeUpdate("INSERT INTO Album "
					+ "VALUES (4, 'Pure Heroine', 'Lorde')");

			stmt.executeUpdate("INSERT INTO Album "
					+ "VALUES (5, 'Second Coming', 'Stone Roses')");

			stmt.executeUpdate("INSERT INTO Album "
					+ "VALUES (6, 'Golden Greats', 'Ian Brown	')");

		} catch (SQLException e) {
			System.out.print("SQL Exception " + e);
			System.exit(1);
		}

	}
    public void queryAlbum()
    {
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM Album ");
            while (rset.next()) {
                System.out.println(rset.getInt(1) + " " + rset.getString(2)+ " " + rset.getString(3));
            }
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
    }

	public void closeDB() {
		try {
            stmt.close();
            rset.close();
			conn.close();
			System.out.print("Connection closed");
		} catch (SQLException e) {
			System.out.print("Could not close connection ");
			e.printStackTrace();
		}
	}
}
