package test;

import gui.UniGUI;
import model.University;

class TestUniversity {
	public static void main(String[] args) {

		int depids[] = { 1, 2, 3, 4 };
		String depnames[] = { "Computing", "Business", "Languages",
				"Engineering" };
		University newUniv = new University("TCD", "Mr Bloggs", "Dublin",
				depids, depnames);

		UniGUI ugui = new UniGUI(newUniv);

	}
}
