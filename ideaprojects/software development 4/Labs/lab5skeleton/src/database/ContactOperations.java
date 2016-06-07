package database;

import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

import model.Contact;

public class ContactOperations {
	private Connection conn;
	private ResultSet rset;
	private PreparedStatement pstmt;
	private Statement stmt;

	public ContactOperations() {
		conn = openDB();
	}

	// This method opens a connection to the Oracle database
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

	// This method closes the connection to the Oracle database
	public void closeDB() {
		try {
			conn.close();
			System.out.print("Connection closed");
		} catch (SQLException e) {
			System.out.print("Could not close connection ");
			e.printStackTrace();
		}
	}





	// This method returns a ResultSet which holds all the data from the Contacts table
	// ordered by ID
	public ResultSet getContacts() {
		try {
			String queryString = "SELECT * FROM contacts ORDER BY id";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(queryString);
		} catch (Exception e) {
			System.out.println(e);
		}
		return rset;
	}
	public ResultSet getLastRow() {
		String sqlStatement = "SELECT * FROM contacts ORDER BY id";
		try {
			pstmt = conn.prepareStatement(sqlStatement,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rset = pstmt.executeQuery();
			rset.last();
			System.out.println(rset.getInt(1)+","+rset.getString(2));
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		return rset;
	}

	// This method is for test purposes and prints out the contents of the Contacts table
	public void queryContacts() {
		try {
			String queryString = "SELECT * FROM contacts ORDER BY id";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(queryString);

			while (rset.next()) {
				System.out.println("DB" + rset.getInt(1) + ","
						+ rset.getString(2) + "," + rset.getString(3) + ","
						+ rset.getString(4) + "," + rset.getString(5));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addContact(Contact c) {
		try {
			String sql = "INSERT INTO Contacts(id, name,address, number, email) VALUES (id_seq.nextVal,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddress());
			pstmt.setString(3, c.getPhoneNumber());
			pstmt.setString(4, c.getEmail());
			pstmt.executeUpdate();
		}catch (Exception se){
			System.out.println(se);
		}
	}

	public int deleteContact(String n){
		int no = 0;
		try{
			String cmd = "DELETE FROM Contacts WHERE name = " + "'"+ n +"'";
			stmt = conn.createStatement();
			no = stmt.executeUpdate(cmd);
		}catch (Exception e) {
			System.out.println(e);
		}
		return no;
	}

	public void updatephoneNumber(String num, String cname){
		try{
			String sql = "UPDATE Contacts SET pnumber=" + "'" +num + "'"
					+ "where name=" + "'" + cname + "'";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e){
			System.out.println("Problem" + e);
		}
	}
}

