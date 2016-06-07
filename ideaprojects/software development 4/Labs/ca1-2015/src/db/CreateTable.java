package db;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

/**
 * Created by Patricia on 04/03/2015.
 */
public class CreateTable {
    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rset;

    public CreateTable()
    {

        conn = openDB();
    }

    public Connection openDB()
    {
        try
        {
            OracleDataSource ods = new OracleDataSource();

            // Home Oracle XE
            ods.setURL("jdbc:oracle:thin:Dave/Dave@localhost:1521:XE");
            ods.setUser("Dave");
            ods.setPassword("1234");

            conn = ods.getConnection();
            System.out.println("connected.");


        }
        catch (Exception e)
        {
            System.out.print("Unable to load driver " + e);
            System.exit(1);
        }
        return conn;
    }
    public void dropTables() {
        System.out.println("Checking for existing tables.");

        try {
            // Dropping a sequence
            String dropseq = "drop sequence capid_seq";
            pstmt = conn.prepareStatement(dropseq);
            pstmt.executeUpdate();
            System.out.println("Product Sequence dropped.");
        } catch (SQLException ex) {
            // No need to report an error.
            // The table simply did not exist.
        }
        try {
            // Drop the products table.
            String droptab = "drop TABLE caproducts";
            pstmt = conn.prepareStatement(droptab);
            pstmt.executeUpdate();
            System.out.println("Products table dropped.");
        } catch (SQLException ex) {
            // No need to report an error.
            // The table simply did not exist.
        }
    }
    public void createTables()
    {
        try {
            // Create Products Table
            String created = "CREATE TABLE caproducts( "
                    + "pid NUMBER PRIMARY KEY," + "name VARCHAR(40),"+"brand VARCHAR(40),"+"price DECIMAL(9,2),"+"qty NUMBER,"+"category VARCHAR(40),"
                    + "branch VARCHAR(40))";
            stmt = conn.createStatement();
            stmt.executeUpdate(created);

            // Create Products a sequence
            String createseq2 = "create sequence capid_seq increment by 1 start with 1";
            stmt = conn.createStatement();
            stmt.executeUpdate(createseq2);

            // Insert records into the Products table
            String insertString2 = "INSERT INTO caproducts(pid,name,brand,price,qty,category,branch) "
                    + "values(capid_seq.nextVal,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(insertString2);

            pstmt.setString(1, "HP Stream 11 inch");
            pstmt.setString(2, "HP");
            pstmt.setDouble(3, 249.99);
            pstmt.setInt(4, 10);
            pstmt.setString(5, "Laptops");
            pstmt.setString(6, "Blanchardstown");
            pstmt.execute();

            pstmt.setString(1, "Acer Aspire 11.6 inch");
            pstmt.setString(2, "Acer");
            pstmt.setDouble(3, 339.99);
            pstmt.setInt(4, 10);
            pstmt.setString(5, "Laptops");
            pstmt.setString(6, "Blanchardstown");
            pstmt.execute();

            pstmt.setString(1, "Lenovo G50 15.6 inch");
            pstmt.setString(2, "Lenovo");
            pstmt.setDouble(3, 419.99);
            pstmt.setInt(4, 10);
            pstmt.setString(5, "Laptops");
            pstmt.setString(6, "Blanchardstown");
            pstmt.execute();

            pstmt.setString(1, "HP Stream 11 inch");
            pstmt.setString(2, "HP");
            pstmt.setDouble(3, 249.99);
            pstmt.setInt(4, 10);
            pstmt.setString(5, "Laptops");
            pstmt.setString(6, "Liffey Valley");
            pstmt.execute();

            pstmt.setString(1, "Acer Aspire 11.6 inch");
            pstmt.setString(2, "Acer");
            pstmt.setDouble(3, 339.99);
            pstmt.setInt(4, 15);
            pstmt.setString(5, "Laptops");
            pstmt.setString(6, "Liffey Valley");
            pstmt.execute();


            pstmt.setString(1, "Lenovo G50 15.6 inch");
            pstmt.setString(2, "Lenovo");
            pstmt.setDouble(3, 419.99);
            pstmt.setInt(4, 1);
            pstmt.setString(5, "Laptops");
            pstmt.setString(6, "Liffey Valley");
            pstmt.execute();

            pstmt.setString(1, "Lenovo H30 Desktop PC");
            pstmt.setString(2, "Lenovo");
            pstmt.setDouble(3, 279.99);
            pstmt.setInt(4, 15);
            pstmt.setString(5, "Desktops");
            pstmt.setString(6, "Liffey Valley");
            pstmt.execute();

            pstmt.setString(1, "ACER Aspire XC-703");
            pstmt.setString(2, "Acer");
            pstmt.setDouble(3, 499.99);
            pstmt.setInt(4, 15);
            pstmt.setString(5, "Desktops");
            pstmt.setString(6, "Blanchardstown");
            pstmt.execute();


            pstmt.setString(1, "HP Pavillion 23 inch");
            pstmt.setString(2, "HP");
            pstmt.setDouble(3, 899.99);
            pstmt.setInt(4, 1);
            pstmt.setString(5, "Desktops");
            pstmt.setString(6, "Dundalk");
            pstmt.execute();

            pstmt.setString(1, "HP Stream ");
            pstmt.setString(2, "HP");
            pstmt.setDouble(3, 129.99);
            pstmt.setInt(4, 64);
            pstmt.setString(5, "Tablets");
            pstmt.setString(6, "Dundalk");
            pstmt.execute();

            pstmt.setString(1, "Acer Memo Pad");
            pstmt.setString(2, "Acer");
            pstmt.setDouble(3, 99.99);
            pstmt.setInt(4, 35);
            pstmt.setString(5, "Tablets");
            pstmt.setString(6, "Blanchardstown");
            pstmt.execute();





        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
    }
    public void queryTable()
    {
        try{
            String queryString = "SELECT * FROM caproducts";
            pstmt = conn.prepareStatement(queryString);
            rset = pstmt.executeQuery();
            System.out.println("Products Table");
            while (rset.next()){
                System.out.println(rset.getInt(1) +"  " + rset.getString(2)+" "+rset.getString(3)+" "+rset.getDouble(4) +" "+
                +rset.getInt(5) +" " + rset.getString(6)+" "+rset.getString(7));
            }
            closeDB();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void closeDB()
    {
        try
        {
            conn.close();
            System.out.print("Connection closed");
        }
        catch (SQLException e)
        {
            System.out.print("Could not close connection ");
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        CreateTable ca = new CreateTable();
        ca.dropTables();
        ca.createTables();
        ca.queryTable();
    }
}
