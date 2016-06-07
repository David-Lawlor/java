package test;

import db.ShopOperations;
import gui.ShopGUI;

public class TestShopGUI {
	public static void main(String args[]) {

		ShopOperations so = new ShopOperations();
		ShopGUI sg = new ShopGUI(so);		
	}
}
