package database;

import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class CreateContacts {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset;

	public CreateContacts() {
		conn = openDB();
	}

	public Connection openDB() {
		try {
			OracleDataSource ods = new OracleDataSource();

			// Tallaght
			// ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
			// ods.setUser("jdbcdemo");
			// ods.setPassword("jdbcdemo");

			// Home Oracle XE
			ods.setURL("jdbc:oracle:thin:Dave@localhost:1521/XE");
			ods.setUser("Dave");
			ods.setPassword("1234");

			conn = ods.getConnection();
			System.out.println("connected.");
		} catch (Exception e) {
			System.out.print("Unable to load driver " + e);
			System.exit(1);
		}
		return conn;
	}

	public void dropContactsTable() {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			stmt = conn.createStatement();

			try {
				// Dropping a sequence
				String dropseq = "drop sequence id_seq";
				stmt = conn.prepareStatement(dropseq);
				stmt.executeUpdate(dropseq);

				// Drop the Coffee table.
				stmt.execute("DROP TABLE Contacts");
				System.out.println("Contacts table dropped.");
			} catch (SQLException ex) {
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void CreateContactsTable() {
		try {

			// Create a Table
			String create = "CREATE TABLE Contacts "
					+ "(id NUMBER PRIMARY KEY, name VARCHAR(40), address VARCHAR(30), pnumber VARCHAR(30), email VARCHAR(20))";
			stmt = conn.createStatement();
			stmt.executeUpdate(create);

			// Creating a sequence
			String createseq = "create sequence id_seq increment by 1 start with 1";
			stmt = conn.createStatement();
			stmt.executeUpdate(createseq);

			// Insert data into table

			String insertString1 = "INSERT INTO Contacts(id,name,address,pnumber,email) "
					+ "values(id_seq.nextVal,?,?,?,?)";
			pstmt = conn.prepareStatement(insertString1);
			
			pstmt.setString(1, "Peter");
			pstmt.setString(2, "23 Lime Lane");
			pstmt.setString(3, "018776543");
			pstmt.setString(4, "p.cassisy@b.com");
			pstmt.execute();
			
			pstmt.setString(1, "Donal");
			pstmt.setString(2, "2 Shelbourne rd");
			pstmt.setString(3, "012445678");
			pstmt.setString(4, "d.oreilly@b.com");
			pstmt.execute();
			
			pstmt.setString(1, "Mary");
			pstmt.setString(2, "4 Richmond rd");
			pstmt.setString(3, "018765456");
			pstmt.setString(4, "m.reilly@rich.com");
			pstmt.execute();
			
			pstmt.setString(1, "Glen");
			pstmt.setString(2, "35 Sommerville Lane");
			pstmt.setString(3, "017854563");
			pstmt.setString(4, "p.whelan@siske.com");
			pstmt.execute();
			 
		} catch (SQLException e) {
			System.out.print("SQL Exception " + e);
			System.exit(1);
		}
	}

	public void queryContacts() {
		try {
			String queryString = "SELECT * FROM contacts";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(queryString);
			System.out.println("Contacts Table");
			while (rset.next()) {
				System.out.println(rset.getInt(1) + " " + rset.getString(2)
						+ " " + rset.getString(3) + " " + rset.getString(4)
						+ " " + rset.getString(5));
			}
		} catch (Exception e) {
			System.out.println(e);
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

	public static void main(String args[]) {
		CreateContacts ct = new CreateContacts();
		ct.dropContactsTable();
		ct.CreateContactsTable();
		ct.queryContacts();
		ct.closeDB();
	}

}
