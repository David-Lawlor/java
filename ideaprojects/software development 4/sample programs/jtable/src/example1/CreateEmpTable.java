package example1;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class CreateEmpTable {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rset;


    public CreateEmpTable()
    {

        conn = openDB();
    }
    public Connection openDB() {
        try {
            OracleDataSource ods = new OracleDataSource();

            // Tallaght
            // ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
            // ods.setUser("");
            // ods.setPassword("");

            // Home Oracle XE
            ods.setURL("jdbc:oracle:thin:HR/Dave@localhost:1521:XE");
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
        System.out.println("Checking for existing tables & Sequences");

        try {
            // Get a Statement object.
            stmt = conn.createStatement();

            try {
                stmt.execute("DROP SEQUENCE empid_seq");
                System.out.println("Sequence dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The seq simply did not exist.
            }
            try {
                // Drop the Coffee table.
                stmt.execute("DROP TABLE employee");
                System.out.println("Products table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void CreateEmployee()
    {
        try
        {
            System.out.println("Inside Create");
            // Create a Table
            String create = "CREATE TABLE employee " +
                    "(empID NUMBER PRIMARY KEY, lastname VARCHAR(40), firstname VARCHAR(40))";
            pstmt = conn.prepareStatement(create);
            pstmt.executeUpdate(create);


            // Insert data into table
            String insertString = "INSERT INTO employee(empID,lastname,firstname) values(?,?,?)";
            pstmt = conn.prepareStatement(insertString);

            pstmt.setInt(1,1);
            pstmt.setString(2, "Smith");
            pstmt.setString(3, "Pat");
            pstmt.executeUpdate();

            pstmt.setInt(1,2);
            pstmt.setString(2, "Davoe");
            pstmt.setString(3, "William");
            pstmt.executeUpdate();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Doe");
            pstmt.setString(3, "John");
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.print("SQL Exception " + e);
            System.exit(1);
        }
    }
    public void queryEmployee()
    {
        try{
            String queryString = "SELECT * FROM employee";
            pstmt = conn.prepareStatement(queryString);
            rset = pstmt.executeQuery();
            System.out.println("Employee Table");
            while (rset.next()){
                System.out.println(rset.getInt(1) +" " + rset.getString(2)+" "+rset.getString(3));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        CreateEmpTable cp = new CreateEmpTable();
        cp.dropTables();
        cp.CreateEmployee();
        cp.queryEmployee();
    }
}
