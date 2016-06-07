package db;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class CreateAdverts
{ 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rset;
    
    public CreateAdverts()
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
    public void dropTables() {
		System.out.println("Checking for existing tables.");

			try {
				// Dropping a sequence
			    String dropseq = "drop sequence adid_seq";
			    pstmt = conn.prepareStatement(dropseq);
				pstmt.executeUpdate();
				System.out.println("Sequence dropped.");

			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}

        try {
            // Drop the adverts table.
            String droptab = "drop TABLE adverts";
            pstmt = conn.prepareStatement(droptab);
            pstmt.executeUpdate();
            System.out.println("Adverts table dropped.");
        } catch (SQLException ex) {
            // No need to report an error.
            // The table simply did not exist.
        }
	}

	public void CreateAdvertsTable()
	{
		try
			{							
			System.out.println("Inside Create");
				// Create a Table
	            String create = "CREATE TABLE adverts " +
						"(adID NUMBER PRIMARY KEY, category VARCHAR(40), price DECIMAL(9,2),details VARCHAR(60))";
	            pstmt = conn.prepareStatement(create);
				pstmt.executeUpdate(create);
				
				// Creating a sequence
				String createseq = "create sequence adid_seq increment by 1 start with 1";
				pstmt = conn.prepareStatement(createseq);
				pstmt.executeUpdate(createseq);
				// Insert data into table
				
				String insertString = "INSERT INTO adverts(adID,category,price,details) values(adid_seq.nextVal,?,?,?)";			
				pstmt = conn.prepareStatement(insertString);
				
				pstmt.setString(1, "Outdoor");
				pstmt.setDouble(2, 100.00);
				pstmt.setString(3, "Trampoline");
				pstmt.executeUpdate();	
				

				pstmt.setString(1, "Outdoor");
				pstmt.setDouble(2, 300.00);
				pstmt.setString(3, "Bicycle");
				pstmt.executeUpdate();	


				pstmt.setString(1, "Furniture");
				pstmt.setDouble(2, 300.00);
				pstmt.setString(3, "Mahogony Kitchen table and 6 chairs");
				pstmt.executeUpdate();	
				
				pstmt.setString(1, "Electronics");
				pstmt.setDouble(2, 390.00);
				pstmt.setString(3, "XBOX ONE, Brand new never used");
				pstmt.executeUpdate();	
				
				pstmt.setString(1, "Electronics");
				pstmt.setDouble(2, 300.00);
				pstmt.setString(3, "XBOX 360 with Kinect, 10 games");
				pstmt.executeUpdate();	
				
															
			}	    
			catch (SQLException e)
			{
				System.out.print("SQL Exception " + e);
				System.exit(1);
			}	
	}
		public void queryAdverts()
		{	
			try{
				String queryString = "SELECT * FROM adverts";			     
			    pstmt = conn.prepareStatement(queryString); 
			    rset = pstmt.executeQuery();
			    System.out.println("Adverts Table");   
			while (rset.next()){
				System.out.println(rset.getInt(1) +" " + rset.getString(2)+" "+rset.getDouble(3)+" "+rset.getString(4));		
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
		CreateAdverts ca = new CreateAdverts();
		ca.dropTables();
		ca.CreateAdvertsTable();	
		ca.queryAdverts();
	}
   

}
