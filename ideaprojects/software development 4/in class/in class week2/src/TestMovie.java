package example1;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.Scanner;



class Database {
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private PreparedStatement pstm;

    

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