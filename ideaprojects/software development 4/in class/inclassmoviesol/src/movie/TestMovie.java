package movie;

public class TestMovie {
	public static void main(String[] args) {
		CreateMovieTable mt = new CreateMovieTable();
		mt.openDB();
		mt.dropTables();
		mt.buildMovieTable();
		mt.showDB();
		mt.queryDB();
		mt.closeDB();
	}

}
