package db;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class ShopOperations {
	private PreparedStatement pstmt;
	private ResultSet rset;
	private Connection conn;
	
	public ShopOperations()
	{
		conn = openDB();
	}

	public Connection openDB() {
		try {
			OracleDataSource ods = new OracleDataSource();

			// Tallaght
			// ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
			// ods.setUser("????");
			// ods.setPassword("????");

			// Home Oracle XE
			ods.setURL("jdbc:oracle:thin:Dave/Dave@localhost:1521:XE");
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

	public void closeDB() {
		try {
			conn.close();
			System.out.print("Connection closed");
		} catch (SQLException e) {
			System.out.print("Could not close connection ");
			e.printStackTrace();
		}
	}
	// Exercise 1: Write a method getProducts to return a result set
	// containing all the data in the table. Use a prepared statement

	public ResultSet getProducts(){
		try{
			String query = "SELECT * FROM products ORDER BY prodid";
			System.out.println("here");

			pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rset = pstmt.executeQuery();
		}catch(SQLException e){
			System.out.println(e);
		}
		return rset;
	}
	
	
	
	// Exercise 2: Write a method manuSearch to return a result set
	// which contains all product details that matches the manufacturer name (String parameter)
	// Use a prepared statement
	
	
	public ResultSet manuSearch(String manufacturer){
		try{
			String query = "SELECT * FROM products WHERE manufacturer = '" + manufacturer + "'";
			System.out.println(query);
			pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rset = pstmt.executeQuery();
		}catch(SQLException sqlE){
			System.out.println(sqlE);
		}
		return rset;
	}
	
	
	
	// Exercise 3: Write a method checkLevels to return a result set
	// which contains all product details where the quantity in stock is below 12
	// Use a prepared statement
	
	public ResultSet checkLevels(){
		try {
			String query = "SELECT * FROM products WHERE quantity < 13";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
		}catch (SQLException sqlE){
			System.out.println(sqlE);
		}
		return rset;
	}
	
	// Exercise 4: Write a method addProduct() which takes 4 parameters and adds a new product to
	// the products table. 
	// Use a prepared statement
	
	public void addProduct(String manu, int size, double price, int qty){
		String insert = "INSERT INTO products VALUES (id_seq.nextVal,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, manu);
			pstmt.setInt(2, size);
			pstmt.setDouble(3, price);
			pstmt.setInt(4, qty);
			pstmt.executeUpdate();
		}catch (SQLException sqlE){
			System.out.println("Error in insert");
			System.out.println(sqlE);
		}


	}

}
