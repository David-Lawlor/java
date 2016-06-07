package movie;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.Scanner;

public class CreateMovieTable {
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

	public void dropTables() {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			stmt = conn.createStatement();
			;

			try {
				// Drop the Movie table.
				stmt.execute("DROP TABLE Movie");
				System.out.println("Movie table dropped.");
			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void buildMovieTable() {
		try {
			String createString = "CREATE TABLE Movie "
					+ "(id NUMBER PRIMARY KEY, title CHAR(35), actor CHAR(20), genre CHAR(30))";

			System.out.println("Table created ");
			stmt = conn.createStatement();
			stmt.executeUpdate(createString);
			
			String insertString1 = "INSERT INTO Movie(id,title,actor,genre) values(1,"
					+ "'The Kings Speech','Colin Firth','Drama')";
			stmt.executeUpdate(insertString1);
			
			
			String insertString2 = "INSERT INTO Movie(id,title,actor, genre) values(2,"
					+ "'The Black Swan','Natalie Portman','Psychological Thriller')";
			stmt.executeUpdate(insertString2);
			
			String insertString3 = "INSERT INTO Movie(id,title,actor, genre) values(3,"
					+ "'Harry Potter and the Deadly Hollows','Emma Watson','Fantasy')";
			stmt.executeUpdate(insertString3);
			
			String insertString4 = "INSERT INTO Movie(id,title,actor, genre) values(4,"
					+ "'Gravity','Sandra Bullock','Scifi')";
			stmt.executeUpdate(insertString4);
			
			
			String insertString5 = "INSERT INTO Movie(id,title,actor, genre) values(5,"
					+ "'Inception','Leonardo di Caprio','Fantasy')";

			stmt.executeUpdate(insertString5);
			
			String insertString6 = "INSERT INTO Movie(id,title,actor, genre) values(6,"
					+ "'The Social Network','Jesse Eisenberg','Drama')";

			stmt.executeUpdate(insertString6);
			
			String insertString7 = "INSERT INTO Movie(id,title,actor, genre) values(7,"
					+ "'The Kids are alright','Julianne Moore','Comedy')";

			stmt.executeUpdate(insertString7);
			
			String insertString8 = "INSERT INTO Movie(id,title,actor, genre) values(8,"
					+ "'All about Steve','Sandra Bullock','Comedy')";

			stmt.executeUpdate(insertString8);
			
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

	}

	public void showDB() {
		String sqlStatement = "SELECT * FROM Movie";
		try {
			// Send the statement to the DBMS.
			rset = stmt.executeQuery(sqlStatement);

			// Display the contents of the result set.
			// The result set will have three columns.
			while (rset.next()) {
				System.out.println(rset.getInt(1) + " " + rset.getString(2)
						+ " " + rset.getString(3) + " " + rset.getString(4));

			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	public void queryDB()
	{
		String sqlStatement1 = "SELECT count(*) FROM Movie";
		String sqlStatement2 = "SELECT title FROM Movie WHERE actor = 'Sandra Bullock'";
		String sqlStatement3 = "SELECT count(*) FROM Movie WHERE genre = 'Comedy'";	
		try {
			System.out.println("================Query 1=======================");
			rset = stmt.executeQuery(sqlStatement1);
			if (rset.next()) {
				System.out.println("The number of movies in the database is: "+rset.getInt(1));

			}
			System.out.println("================Query 2=======================");
			rset = stmt.executeQuery(sqlStatement2);
			System.out.println("The movies with Sandra Bullock are:");
			while (rset.next()) {
				System.out.println(rset.getString(1));
			}
			System.out.println("================Query 3=======================");
			rset = stmt.executeQuery(sqlStatement3);
			if (rset.next()) {
				System.out.println("The number of Comedy movies in the database is: "+rset.getInt(1));
			}	
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
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
