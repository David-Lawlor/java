import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class CreateCoffeeDB {
  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rset;

  public void openDB() {
    try {
      // Load the Oracle JDBC driver
      OracleDataSource ods = new OracleDataSource();
      ods.setURL("jdbc:oracle:thin:Dave/@localhost:1521:XE");
      ods.setUser("Dave");
      ods.setPassword("1234");

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
      pstmt = conn.prepareStatement("DROP TABLE Coffee");
      try {
        pstmt.execute();
        System.out.println("Coffee table dropped.");
      } catch (SQLException ex) {
      }
    } catch (SQLException ex) {
      System.out.println("ERROR: " + ex.getMessage());
      ex.printStackTrace();
    }
  }

  public void closeDB() {
    try {
      pstmt.close();
      rset.close();
      conn.close();
      System.out.print("Connection closed");
    } catch (SQLException e) {
      System.out.print("Could not close connection ");
      e.printStackTrace();
    }
  }

  public void fillCoffeeTable(){
    String s = "create table coffee (description varchar2(50), productCode varchar2(6), price number(7,2), Primary key (productCode))";
    try{
      pstmt = conn.prepareStatement(s);
      pstmt.execute();
      s = "insert into coffee (description, productCode, price) values (?,?,?)";
      pstmt = conn.prepareStatement(s);

      pstmt.setString(1, "dark");
      pstmt.setString(2, "14-001");
      pstmt.setDouble(3, 8.95);
      pstmt.execute();

      pstmt.setString(1, "medium");
      pstmt.setString(2, "14-002");
      pstmt.setDouble(3, 8.95);
      pstmt.execute();

      pstmt.setString(1, "dark");
      pstmt.setString(2, "15-001");
      pstmt.setDouble(3, 8.95);
      pstmt.execute();

      System.out.println("successful");
    }catch (SQLException sqlE){
      System.out.println(sqlE.getMessage());
    }

  }

}

  class TestCoffeeDB {
    public static void main(String[] args) {
      CreateCoffeeDB cdb = new CreateCoffeeDB();
      cdb.openDB();
      cdb.dropTables();
      cdb.fillCoffeeTable();
      //cdb.queryDB();
      //cdb.closeDB();
    }
  }
