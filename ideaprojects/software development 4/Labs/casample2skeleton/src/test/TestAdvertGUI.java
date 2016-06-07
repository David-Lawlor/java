package test;

import db.AdvertOperations;
import gui.AdvertGUI;

public class TestAdvertGUI {
	public static void main(String args[]) {

		AdvertOperations ao = new AdvertOperations();
		AdvertGUI ag = new AdvertGUI(ao);		
	}
}
