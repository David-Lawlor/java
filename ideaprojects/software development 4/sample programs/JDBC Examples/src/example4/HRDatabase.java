package example4;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Patricia on 25/01/2015.
 */
public class HRDatabase {
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
    public void queryHR()
    {
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("select * from departments ");
            while (rset.next()) {
                System.out.println(rset.getInt(1) + " " + rset.getString(2));
            }
        } catch (SQLException e) {
            System.out.print("SQL Exception " + e);
            System.exit(1);
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
