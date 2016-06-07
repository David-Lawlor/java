package expreparedstatements;
public class TestCoffeeDB {
	public static void main(String[] args) {
		CreateCoffeeDB cdb = new CreateCoffeeDB();
		cdb.openDB();
		cdb.dropTables();
		cdb.buildCoffeeTable();
		cdb.queryDB();
		cdb.closeDB();
	}
}
