package db;

import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class ProductOperations {
	private PreparedStatement pstmt;
	private ResultSet rset;
	private Connection conn;
	
	public ProductOperations()
	{
		conn = openDB();
	}

	public Connection openDB() {
		try {
			OracleDataSource ods = new OracleDataSource();

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
	// Exercise 1: Display Products

	public ResultSet getProducts(){
		try{
			String query = "SELECT * FROM caproducts";
			System.out.println("here");

			pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rset = pstmt.executeQuery();
		}catch(SQLException e){
			System.out.println(e);
		}
		return rset;
	}



	// Exercise 2: searchByBrand
	public ResultSet searchByBrand(String brand){
		try{

			String s = "SELECT pid,name,brand,price,qty,category,branch FROM caproducts WHERE brand = ?";
			pstmt = conn.prepareStatement(s);

			pstmt.setString(1, brand);

			rset = pstmt.executeQuery();
		}catch (SQLException sqlE){
			System.out.println("error in Query");
		}
		return rset;
	}



    // Exercise 3: searchByCategory overloaded methods
	public ResultSet searchByCategory(String category){
		try{

			String s = "SELECT pid,name,brand,price,qty,category,branch FROM caproducts WHERE category = ?";
			pstmt = conn.prepareStatement(s);

			pstmt.setString(1, category);

			rset = pstmt.executeQuery();
		}catch (SQLException sqlE){
			System.out.println("error in Query");
		}
		return rset;
	}

	public ResultSet searchByCategory(String category1, String category2){
		try{

			String s = "SELECT pid,name,brand,price,qty,category,branch FROM caproducts WHERE category = ? OR category = ?";
			pstmt = conn.prepareStatement(s);

			pstmt.setString(1, category1);
			pstmt.setString(2, category2);

			rset = pstmt.executeQuery();
		}catch (SQLException sqlE){
			System.out.println("error in Query");
		}
		return rset;
	}


		
	
	// Exercise 4: addProduct() method
	public void addProduct(String name, String brand, double price, int qty, String category, String branch){
		try {
			String sql = "INSERT INTO caproducts(pid,name,brand,price,qty,category,branch)  "
					+ "values(capid_seq.nextVal,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, brand);
			pstmt.setDouble(3, price);
			pstmt.setInt(4, qty);
			pstmt.setString(5, category);
			pstmt.setString(6, branch);
			pstmt.execute();

		}catch(SQLException sqlE){
			System.out.println("Error inserting record");
		}
	}
	

	

}
