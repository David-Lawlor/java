package db;
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class CreateProductsTable {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rset;
	private ShopOperations so;

    
    public CreateProductsTable()
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
		System.out.println("Checking for existing tables & Sequences");

		try {
			// Get a Statement object.
			stmt = conn.createStatement();

			try {
				stmt.execute("DROP SEQUENCE id_seq");
				System.out.println("Sequence dropped.");
			} catch (SQLException ex) {
				// No need to report an error.
				// The seq simply did not exist.
			}
            try {
                // Drop the Coffee table.
                stmt.execute("DROP TABLE products");
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

	public void CreateProducts()
	{
		try
			{							
			System.out.println("Inside Create");
				// Create a Table
	            String create = "CREATE TABLE products " +
						"(prodID NUMBER PRIMARY KEY, manufacturer VARCHAR(40), prodsize NUMBER, price DECIMAL(9,2),quantity NUMBER)";
	            pstmt = conn.prepareStatement(create);
				pstmt.executeUpdate(create);
				
				// Creating a sequence
				String createseq = "create sequence id_seq increment by 1 start with 1";
				pstmt = conn.prepareStatement(createseq);
				pstmt.executeUpdate(createseq);

				// Insert data into table				
				String insertString = "INSERT INTO products(prodID,manufacturer,prodsize,price,quantity) values(id_seq.nextVal,?,?,?,?)";			
				pstmt = conn.prepareStatement(insertString);
				

				pstmt.setString(1, "Sony");
				pstmt.setInt(2, 60);
				pstmt.setDouble(3,999.99);
				pstmt.setInt(4, 10);
				pstmt.executeUpdate();				

				pstmt.setString(1, "Sony");
				pstmt.setInt(2, 40);
				pstmt.setDouble(3,399.99);
				pstmt.setInt(4, 7);
				pstmt.executeUpdate();		
				
				pstmt.setString(1, "Samsung");
				pstmt.setInt(2, 60);
				pstmt.setDouble(3,869.99);
				pstmt.setInt(4, 12);
				pstmt.executeUpdate();	
				
				pstmt.setString(1, "Samsung");
				pstmt.setInt(2, 40);
				pstmt.setDouble(3,359.99);
				pstmt.setInt(4, 14);
				pstmt.executeUpdate();														
			}	    
			catch (SQLException e)
			{
				System.out.print("SQL Exception " + e);
				System.exit(1);
			}	
	}
		public void queryProducts()
		{	
			try{
				String queryString = "SELECT * FROM products";			     
			    pstmt = conn.prepareStatement(queryString); 
			    rset = pstmt.executeQuery();
			    System.out.println("Products Table");   
			while (rset.next()){
				System.out.println(rset.getInt(1) +" " + rset.getString(2)+" "+rset.getInt(3)+" "+rset.getDouble(4)+" "+rset.getInt(5));		
			}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		public static void main(String args[]) {		
			CreateProductsTable cp = new CreateProductsTable();
			cp.dropTables();		
			cp.CreateProducts();	
			cp.queryProducts();
		}
}
