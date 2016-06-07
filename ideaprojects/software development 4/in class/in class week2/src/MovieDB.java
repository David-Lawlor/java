/*IdeaProjects
  PACKAGE_NAME
  Created by David
  14:18   02/02/2015
  Software Development 3
*/

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MovieDB {
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

  /**
   * The dropTables method drops any existing in case the database already
   * exists.
   */
  public void dropTables() {
    System.out.println("Checking for existing tables.");

    try {
      // Get a Statement object.
      stmt = conn.createStatement();


      try {
        // Drop the Coffee table.
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

  /**
   * The buildCoffeeTable method creates the Coffee table and adds some rows
   * to it.
   */
  public void buildMovieTable() {
    try {
      // Get a Statement object.
      Statement stmt = conn.createStatement();

      String createString = "CREATE TABLE Movie"
              + "id integer PRIMATY KEY, "
              + "title VARCHAR2(20),"
              + "actor VARCHAR2(20),"
              + "genre VARCHAR2(20);";
      stmt = conn.createStatement();
      stmt.executeUpdate(createString);

      String insertString1 = "INSERT INTO Movie(id, title, actor, genre) values"
              + "1,'The kings speech', 'Colin Firth', 'Drama')";
      stmt.executeUpdate(insertString1);

      System.out.println("Movie table created.");
    } catch (SQLException ex) {
      System.out.println("ERROR: " + ex.getMessage());
    }
  }

  public ResultSet queryDB() {

    String sqlStatement = "SELECT * FROM Coffee";
    try {
      Statement stmt = conn.createStatement();
      // Send the statement to the DBMS.
      rset = stmt.executeQuery(sqlStatement);

      // Display the contents of the result set.
      // The result set will have three columns.
      while (rset.next()) {
        System.out.printf("%25s %10s %5.2f\n",
                rset.getString("Description"),
                rset.getString("ProdNum"), rset.getDouble("Price"));
      }
    } catch (Exception ex) {
      System.out.println("ERROR: " + ex.getMessage());
    }
    return null;
  }

  public void queryStrings() {
    String sqlStatement = "SELECT * FROM Coffee WHERE UPPER(Description) = 'FRENCH ROAST DARK'";

    try {
      // Send the statement to the DBMS.
      rset = stmt.executeQuery(sqlStatement);

      // Display the contents of the result set.
      // The result set will have three columns.
      while (rset.next()) {
        System.out.printf("%25s %10s %5.2f\n",
                rset.getString("Description"),
                rset.getString("ProdNum"), rset.getDouble("Price"));
      }
    } catch (Exception ex) {
      System.out.println("ERROR: " + ex.getMessage());
    }
  }

  public void queryLIKE() {
    // String sqlStatement =
    // "SELECT * FROM Coffee WHERE Description LIKE '%Decaf%'";
    // String sqlStatement =
    // "SELECT * FROM Coffee WHERE ProdNum LIKE '2_-00_'";
    String sqlStatement = "SELECT * FROM Coffee WHERE Description NOT LIKE '%Decaf%'";

    try {
      // Send the statement to the DBMS.
      rset = stmt.executeQuery(sqlStatement);

      // Display the contents of the result set.
      // The result set will have three columns.
      while (rset.next()) {
        System.out.printf("%25s %10s %5.2f\n",
                rset.getString("Description"),
                rset.getString("ProdNum"), rset.getDouble("Price"));
      }
    } catch (Exception ex) {
      System.out.println("ERROR: " + ex.getMessage());
    }
  }

  public void queryANDOR() {
    // String sqlStatement =
    // "SELECT * FROM Coffee WHERE Price > 10.00 AND Price < 14.00";
    String sqlStatement = "SELECT * FROM Coffee WHERE Description LIKE '%Dark%' OR ProdNum LIKE '16%'";

    try {
      // Send the statement to the DBMS.
      rset = stmt.executeQuery(sqlStatement);

      // Display the contents of the result set.
      // The result set will have three columns.
      while (rset.next()) {
        System.out.printf("%25s %10s %5.2f\n",
                rset.getString("Description"),
                rset.getString("ProdNum"), rset.getDouble("Price"));
      }
    } catch (Exception ex) {
      System.out.println("ERROR: " + ex.getMessage());
    }
  }

  public void querySORT() {

    // String sqlStatement = "SELECT * FROM Coffee ORDER BY Price";
    String sqlStatement = "SELECT * FROM Coffee	WHERE Price > 9.95 ORDER BY Price DESC";

    try {
      // Send the statement to the DBMS.
      rset = stmt.executeQuery(sqlStatement);

      // Display the contents of the result set.
      // The result set will have three columns.
      while (rset.next()) {
        System.out.printf("%25s %10s %5.2f\n",
                rset.getString("Description"),
                rset.getString("ProdNum"), rset.getDouble("Price"));
      }
    } catch (Exception ex) {
      System.out.println("ERROR: " + ex.getMessage());
    }
  }

  public void queryMATHFNS() {
    // Variables to hold the lowest, highest, and
    // average prices of coffee.
    double lowest = 0.0, highest = 0.0, average = 0.0;

    try {
      // Create SELECT statements to get the lowest, highest,
      // and average prices from the Coffee table.
      String minStatement = "SELECT MIN(Price) FROM Coffee";
      String maxStatement = "SELECT MAX(Price) FROM Coffee";
      String avgStatement = "SELECT AVG(Price) FROM Coffee";

      // Get the lowest price.
      ResultSet minResult = stmt.executeQuery(minStatement);
      if (minResult.next())
        lowest = minResult.getDouble(1);

      // Get the highest price.
      ResultSet maxResult = stmt.executeQuery(maxStatement);
      if (maxResult.next())
        highest = maxResult.getDouble(1);

      // Get the average price.
      ResultSet avgResult = stmt.executeQuery(avgStatement);
      if (avgResult.next())
        average = avgResult.getDouble(1);

      // Display the results.
      System.out.printf("Lowest price: $%.2f\n", lowest);
      System.out.printf("Highest price: $%.2f\n", highest);
      System.out.printf("Average price: $%.2f\n", average);
    } catch (Exception ex) {
      System.out.println("ERROR: " + ex.getMessage());
    }
  }
  public void insert(String prodNum, double price,String description)
  {
    try
    {
      // Create a string with an INSERT statement.
      String sqlStatement = "INSERT INTO Coffee " +
              "(ProdNum, Price, Description) " +
              "VALUES ('" +
              prodNum + "', " +
              price + ", '" +
              description + "')";

      // Send the statement to the DBMS.
      int rows = stmt.executeUpdate(sqlStatement);

      // Display the results.
      System.out.println(rows + " row(s) added to the table.");
    }
    catch (Exception ex) {
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

{



  }
}

