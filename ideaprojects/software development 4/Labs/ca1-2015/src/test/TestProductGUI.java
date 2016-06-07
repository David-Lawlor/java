package test;

import db.ProductOperations;
import gui.ProductGUI;

public class TestProductGUI {
	public static void main(String args[]) {

		ProductOperations po = new ProductOperations();
		ProductGUI sg = new ProductGUI(po);
	}
}
