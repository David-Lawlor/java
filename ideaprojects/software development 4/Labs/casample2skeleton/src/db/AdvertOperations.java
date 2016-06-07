package db;

import java.sql.*;

import oracle.jdbc.pool.OracleDataSource;

public class AdvertOperations {
	private PreparedStatement pstmt;
	private ResultSet rset;
	private Connection conn;
	
	public AdvertOperations()
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
	// Exercise 1: getAdverts()
	public ResultSet getAdverts(){
		try{
			String sql = "SELECT * FROM Adverts";
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
		}catch(SQLException sqlE){
			System.out.println(sqlE);
		}
		return rset;
	}
	
	// Exercise 2: searchByKeyword()

	public ResultSet searchByKeyword(String keyword, String order){
		try{
			//String s = "SELECT adID,category,price,details FROM Adverts WHERE details LIKE ? ORDER BY price ?";
			String s = "SELECT adID,category,price,details FROM Adverts WHERE details LIKE ? ORDER BY price " + order;
			//System.out.println(s);
			//System.out.println(keyword + order);
			pstmt = conn.prepareStatement(s);

			//pstmt.setString(1, "%" + keyword + "%");
			//pstmt.setString(2, order);

			rset = pstmt.executeQuery();
		}catch (SQLException sqlE){
			System.out.println("error in Query");
		}
		return rset;
	}

	// Exercise 3: searchByCategory()
	public ResultSet searchByCategory(String category){
		try{

			String s = "SELECT adID,category,price,details FROM Adverts WHERE category = ?";
			pstmt = conn.prepareStatement(s);

			pstmt.setString(1, category);

			rset = pstmt.executeQuery();
		}catch (SQLException sqlE){
			System.out.println("error in Query");
		}
		return rset;
	}
	
	// Exercise 4: placeAd()
	public void placeAd(String category, double price, String details){
		try {
			String insertString = "INSERT INTO adverts(adID,category,price,details) values(adid_seq.nextVal,?,?,?)";
			pstmt = conn.prepareStatement(insertString);

			pstmt.setString(1, category);
			pstmt.setDouble(2, price);
			pstmt.setString(3, details);

			pstmt.executeUpdate();
			System.out.println("Record inserted successfully");
		}catch(SQLException sqlE){
			System.out.println("Error inserting record");
		}
	}

}
