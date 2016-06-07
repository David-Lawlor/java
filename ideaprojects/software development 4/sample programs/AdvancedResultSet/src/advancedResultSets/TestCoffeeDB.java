package advancedResultSets;

import java.sql.*;

public class TestCoffeeDB {
	public static void main(String[] args) {
		CoffeeOperations cdb = new CoffeeOperations();
		cdb.openDB();
		cdb.dropTables();
		cdb.buildCoffeeTable();
		//cdb.advancedRSMethods();
		ResultSet data = cdb.queryDB(); // connect & retrieve data

		CoffeeGUI vg = new CoffeeGUI(data,cdb); // create GUI object
	}
}
