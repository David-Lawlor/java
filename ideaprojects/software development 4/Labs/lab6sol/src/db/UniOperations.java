package db;

import java.sql.*;

import model.Department;
import oracle.jdbc.pool.OracleDataSource;
/**
 * Created by Patricia on 15/02/2015.
 */
public class UniOperations {
    private Connection conn;
    private ResultSet rset;
    private PreparedStatement pstmt;
    private Statement stmt;

    public UniOperations() {
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
            ods.setURL("jdbc:oracle:thin:HR/pmagee@localhost:1521:XE");
            ods.setUser("hr");
            ods.setPassword("passhr");

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
    public ResultSet getDepts(int id) {
        try {
            String queryString = "SELECT depid,depname FROM Department where uniid = "+id+ "ORDER BY depid";

            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getUnis() {
        try {
            String queryString = "SELECT * FROM University ORDER BY uniid";

            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public int getNumUni()
    {
        int num=0;
        try {
            String queryString = "SELECT count(*) FROM University";

            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
            if (rset.next()) {
                num = rset.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return num;
    }
    public void addDep(Department d, String name) {
        try {
            int id = getUniID(name);
            System.out.println("ID is "+id);
            String sql2 = "INSERT INTO Department(depid,depname,uniid) "+ "values(did_seq.nextVal,?,?)";
            pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1, d.getDeptName());
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (Exception se) {
            System.out.println(se);
        }
    }

    public void updateDep(String dname, String newname, String uname)
    {
        try {
            int id = getUniID(uname);
            System.out.println("ID is "+id);
            String sql1 = "UPDATE Department SET depname=" + "'" + newname + "'"
                    + "where depname=" + "'" + dname + "'" + "AND uniid = "+id ;
            stmt = conn.createStatement();
            stmt.executeUpdate(sql1);
        } catch (Exception se) {
            System.out.println(se);
        }
    }
    public int deleteContact(String n, String uname) {
        int no = 0;
        try {
            int id = getUniID(uname);
            String cmd = "DELETE FROM Department WHERE depname =" + "'" + n + "'" + "AND uniid = "+id;
            stmt = conn.createStatement();
            no = stmt.executeUpdate(cmd);
        } catch (Exception e) {
            System.out.println(e);
        }
        return no;

    }

    public int getUniID(String name)
    {
        int id=0;
        try {
            System.out.println("Name is"+name);
            String sql1 = "SELECT UNIID FROM UNIVERSITY WHERE UNAME ="+"'"+name+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql1);

            if (rset.next()) {
                id = rset.getInt(1);
            }
        } catch (Exception se) {
            System.out.println(se);
        }
        return id;
    }
    public ResultSet getLastRow() {
        String sqlStatement = "SELECT * FROM department ORDER BY depid";
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


}
