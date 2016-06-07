package db;

import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class CreateUniTable {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rset;

	public CreateUniTable() {
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

	public void dropTables() {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			stmt = conn.createStatement();
			try {
				stmt.execute("DROP TABLE Department");
				stmt.execute("DROP TABLE University");
				stmt.execute("DROP sequence uid_seq");
				stmt.execute("drop sequence did_seq");

			} catch (SQLException ex) {
				System.out.println("Problem dropping Tables");
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void CreateTables() {
		try {

			// Create a Table
			String create = "CREATE TABLE University "
					+ "(uniid NUMBER PRIMARY KEY, uname VARCHAR(40) , location VARCHAR(30), president VARCHAR(30))";
			stmt = conn.createStatement();
			stmt.executeUpdate(create);
			// Creating a sequence
			String createseq = "create sequence uid_seq increment by 1 start with 1";
			//stmt = conn.createStatement();
			stmt.executeUpdate(createseq);

			// Create a Table
			String created = "CREATE TABLE Department( "
					+ "depid NUMBER PRIMARY KEY," + "depname VARCHAR(40),"
					+ "uniid NUMBER REFERENCES University(uniid)" + ")";
			//stmt = conn.createStatement();
			stmt.executeUpdate(created);

			// Creating a sequence
			String createseq2 = "create sequence did_seq increment by 1 start with 1";
			//stmt = conn.createStatement();
			stmt.executeUpdate(createseq2);

			// Insert record 1 into University table

			String insertString1 = "INSERT INTO University(uniid,uname,location,president) "
					+ "values(uid_seq.nextVal,?,?,?)";
			pstmt = conn.prepareStatement(insertString1);

			pstmt.setString(1, "UCD");
			pstmt.setString(2, "Belfield");
			pstmt.setString(3, "Dr Hugh Brady ");
			pstmt.execute();

			// Insert 4 records into the Department table
			String insertString2 = "INSERT INTO Department(depid,depname,uniid) "
					+ "values(did_seq.nextVal,?,uid_seq.currVal)";
			pstmt = conn.prepareStatement(insertString2);

			pstmt.setString(1, "Computing");
			pstmt.execute();

			pstmt.setString(1, "Business");
			pstmt.execute();

			pstmt.setString(1, "Language");
			pstmt.execute();

			pstmt.setString(1, "Arts");
			pstmt.execute();

			// Insert record 2 into University Table
			String insertString3 = "INSERT INTO University(uniid,uname,location,president) "
					+ "values(uid_seq.nextVal,?,?,?)";
			pstmt = conn.prepareStatement(insertString3);

			pstmt.setString(1, "DCU");
			pstmt.setString(2, "Glasnevin");
			pstmt.setString(3, "Professor Brian MacCraith");
			pstmt.execute();

			String insertString4 = "INSERT INTO Department(depid,depname,uniid) "
					+ "values(did_seq.nextVal,?,uid_seq.currVal)";
			pstmt = conn.prepareStatement(insertString4);

			pstmt.setString(1, "Computer Applications");
			pstmt.execute();

			pstmt.setString(1, "BioTechnology");
			pstmt.execute();

			pstmt.setString(1, "Business");
			pstmt.execute();

			pstmt.setString(1, "Languages");
			pstmt.execute();

		} catch (SQLException e) {
			System.out.print("SQL Exception " + e);
			System.exit(1);
		}
	}

	public void query1DB() {
		try {
            // Query 1
			String queryString = "SELECT * FROM University";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(queryString);
			System.out.println("University Table");
			while (rset.next()) {
				System.out.println(rset.getInt(1) + " " + rset.getString(2)
						+ " " + rset.getString(3) + " " + rset.getString(4));
			}

            // Query 2
            String queryString1 = "SELECT * FROM Department";
			stmt = conn.createStatement();
			ResultSet drset = stmt.executeQuery(queryString1);
			System.out.println("Departments Table");
			while (drset.next()) {
				System.out.println(drset.getInt(1) + " " + drset.getString(2)
						+ " " + drset.getInt(3));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
    public void query2DB() {
        try {
            String queryString = "SELECT * FROM University, Department where University.uniid = Department.uniid";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
            while (rset.next()) {
                System.out.println("University: " + rset.getString(2)
                        +" \nDepartment" +rset.getInt(5) + " " + rset.getString(6)
                        + " " +rset.getInt(7));

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
		CreateUniTable ct = new CreateUniTable();
		ct.dropTables();
		ct.CreateTables();
		//ct.query1DB();
        ct.query2DB();

	}

}
