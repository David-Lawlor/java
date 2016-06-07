import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

/**
 * Created by DL on 10/02/2015.
 */
public class ContactsDB {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rset;

    public void openDB(){
        try{
            OracleDataSource ods = new OracleDataSource();

            ods.setURL("jdbc:oracle:thin:Dave@localhost:1521/XE");
            ods.setUser("Dave");
            ods.setPassword("1234");

            conn = ods.getConnection();
            System.out.println("connected");

        }catch(Exception e){
            System.out.println("Unable to load driver " + e);
            System.exit(1);
        }
    }

    public void closeDB(){
        try{
            pstmt.close();
            rset.close();
            conn.close();
            System.out.println("Connection closed");
        }catch(SQLException e){
            System.out.println("Could not close connection");
            e.printStackTrace();
        }
    }

    public void dropTable(){
        System.out.println("Checking for existing tables.");
        try{

            pstmt = conn.prepareStatement("DROP TABLE Contacts");
            try{
                pstmt.execute();
                System.out.println("Contacts table dropped");
            }catch (SQLException e){
                System.out.println("Contacts table did not exist");
            }
        }catch (SQLException e){
            System.out.println("Contacts table not dropped successfully");
            e.printStackTrace();
        }
    }

    public void buildContactsTable(){
        try {
            String sql = "CREATE TABLE Contacts" +
                    "(contactID NUMBER(25)," +
                    "conName VARCHAR2(30)," +
                    "address VARCHAR2(255)," +
                    "phone VARCHAR2(15)," +
                    "email VARCHAR2(50)," +
                    "PRIMARY KEY(contactID))";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();

            String sql2 = "INSERT INTO Contacts VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql2);

            pstmt.setInt(1,1);
            pstmt.setString(2,"Peter");
            pstmt.setString(3,"23 Lime Lane");
            pstmt.setString(4,"018976543");
            pstmt.setString(5,"p.cassidy@b.com");
            pstmt.executeUpdate();

            pstmt.setInt(1,2);
            pstmt.setString(2,"Donal");
            pstmt.setString(3,"2 Shelbourne rd");
            pstmt.setString(4,"012446578");
            pstmt.setString(5,"d.oreilly@b.com");
            pstmt.executeUpdate();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Mary");
            pstmt.setString(3,"4 Richmond rd");
            pstmt.setString(4,"019887654");
            pstmt.setString(5,"m.lawlor@b.com");
            pstmt.executeUpdate();

            pstmt.setInt(1,4);
            pstmt.setString(2,"Glen");
            pstmt.setString(3,"4 Richmond Lane");
            pstmt.setString(4,"011223876");
            pstmt.setString(5,"g.whelan@b.com");
            pstmt.executeUpdate();


        }catch (SQLException e){
            System.out.println("Error building table");
            e.printStackTrace();
        }
    }

    public ResultSet queryDB(){
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Contacts",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rset = pstmt.executeQuery();
            System.out.println();
            while (rset.next()){
                System.out.println(rset.getInt(1)+" "+rset.getString(2)+" "+rset.getString(3)+" "+rset.getString(4)+" "+rset.getString(5));
            }
            System.out.println();
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return rset;
    }

    public void add(int id, String name, String address, String phone, String email){
        try{
            String sql = "SELECT Contacts.* FROM Contacts";
            pstmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rset = pstmt.executeQuery();

            rset.moveToInsertRow();
            rset.updateInt(1, id);
            rset.updateString(2, name);
            rset.updateString(3,address);
            rset.updateString(4,phone);
            rset.updateString(5,email);
            rset.insertRow();
            pstmt.executeUpdate();
            System.out.println("insert successful\n");
        }catch(Exception e){
            System.out.println("Error going to last row");
            System.out.println(e.getMessage());
            e.printStackTrace();
            //System.exit(1);
        }
    }

    public void delete(int id){
        try {
            String sql = "SELECT Contacts.* FROM Contacts WHERE contactID = " + id;
            pstmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE);
            rset = pstmt.executeQuery();
            if (rset.next())       // try to go to row
            {
                System.out.println("Deleting..");
                rset.deleteRow();  // delete the row from the database and result set
                System.out.println("Row " + id + " deleted");
            }
            else
                System.out.println("Record not found");
        }catch(SQLException e){
            System.out.println("Error in delete");
        }
    }
}
