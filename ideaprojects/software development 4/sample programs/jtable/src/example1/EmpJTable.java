package example1;

// Source: http://www.techrepublic.com/article/displaying-data-with-jtables/#

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class EmpJTable {

    // Define our database connection
    public static Connection conn;

    public static void main(String args[]) {
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
            new MainWin();
        }
        // SQL error handling
        catch (SQLException se) {
            SQLExceptionHandler.handleException(se, conn);
            System.exit(0);
        }
        // Other error handling
        catch (Exception e) {
            e.printStackTrace ();
            System.exit(0);
        }
    }
}
