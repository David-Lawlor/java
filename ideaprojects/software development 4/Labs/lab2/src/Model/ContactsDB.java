package Model;/*IdeaProjects
  PACKAGE_NAME
  Created by David
  11:34   04/02/2015
  Software Development 3
*/

import com.sun.org.apache.xpath.internal.SourceTree;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ContactsDB {

  private Connection conn;
  private Statement stmt;
  private ResultSet rset;

  public void openDB(){
    String url;
    Scanner in = new Scanner(System.in);
    try {
      // Load the Oracle JDBC driver
      OracleDataSource ods = new OracleDataSource();

      ods.setURL("jdbc:oracle:thin:Dave@localhost:1521/XE");;
      ods.setUser("Dave");;
      ods.setPassword("1234");

      conn = ods.getConnection();
      System.out.println("connected.");
    } catch (Exception e) {
      System.out.print("Unable to load driver " + e);
      System.exit(1);
    }
  }

  public void closeDB(){
    try{
      stmt.close();
      rset.close();
      conn.close();
      System.out.println("Connection Closed");
    }catch (SQLException e) {
      System.out.println("Could not close connection");
      e.printStackTrace();
    }
  }

  public void buildContactsTable(){
    try{
      Statement stmt = conn.createStatement();

      stmt.executeUpdate("CREATE TABLE Contacts(id number,name VARCHAR(50),address VARCHAR(255),phone VARCHAR(255),email VARCHAR(255), PRIMARY KEY (id))");
      System.out.println("Table successfully created");

      stmt.execute("INSERT INTO Contacts VALUES(1,'Peter','23 Lime Lane','018976543','p.cassidy@b.com')");
      stmt.execute("INSERT INTO Contacts VALUES(2,'Donal','2 Shelbourne road','012446578','d.oreilly@b.com')");
      stmt.execute("INSERT INTO Contacts VALUES(3,'Mary','4 Richmond rd','019887654','m.lawlor@b.com')");
      stmt.execute("INSERT INTO Contacts VALUES(4,'Glen','4 Richmond Lane','011223876','g.whelan@b.com')");

    }catch(SQLException e){
      System.out.println("Error building table");
      e.printStackTrace();
    }

  }

  public void insert(int id, String name, String address, String phone, String email){
    try{
      Statement stmt = conn.createStatement();
      stmt.executeUpdate("INSERT INTO Contacts VALUES("+id+", '"+name+"', '"+address+"', '"+phone+"', '"+email+"')");
      System.out.println("Insert successful");
    }catch (SQLException e){
      System.out.println("Insert not successful");
      e.printStackTrace();
    }

  }

  public void dropTable(){
    try{
      stmt.execute("DROP TABLE Contacts");
      System.out.println("Contacts table has been successfully dropped");
    }catch (SQLException e){
      System.out.println("Error, Contacts table has not been dropped.");
      e.printStackTrace();
    }
  }

  public void showDB(){
    try{
      stmt = conn.createStatement();
      rset = stmt.executeQuery("SELECT * FROM contacts");
      while (rset.next()){
        System.out.println(rset.getInt(1)+" "+rset.getString(2)+" "+rset.getString(3)+" "+rset.getString(4)+" "+rset.getString(5));
      }
    }catch (SQLException e){
      System.out.println("Invalid query");
      System.exit(1);
    }
  }

  public void queryDB(){
    try{
      Statement stmt = conn.createStatement();
      System.out.println("================Query 1=======================");
      String sql1 = "SELECT count(*) FROM contacts";
      System.out.println(sql1);
      rset = stmt.executeQuery(sql1);
      System.out.println("here");
      while (rset.next()){
        System.out.println("The number of contacts in the database is: " + rset.getString(1));
      }

      System.out.println("================Query 2=======================");
      String sql2 = "SELECT phone FROM Contacts WHERE name = 'Peter'";
      rset = stmt.executeQuery(sql2);
      System.out.println("The phone number for Peter is:");
      while (rset.next()){
        System.out.println(rset.getString(1));
      }

      System.out.println("================Query 3=======================");
      String sql3 = "SELECT * FROM contacts ORDER BY NAME";
      rset = stmt.executeQuery(sql3);
      while(rset.next()){
        System.out.println(rset.getInt(1)+" "+rset.getString(2)+" "+rset.getString(3)+" "+rset.getString(4)+" "+rset.getString(5));
      }
    }catch (SQLException e){
      System.out.println("Error in query");
      e.printStackTrace();
    }
  }


}
