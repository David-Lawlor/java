package test;

import java.util.ArrayList;

import db.UniOperations;
import gui.UniGUI;
import model.HEA;
import model.University;

class TestUniversity
{
	public static void main(String[] args){

	    UniOperations u = new UniOperations();
        HEA h = new HEA("Ireland",u);
        UniGUI ugui = new UniGUI(h.getUniList(),u);
		
	}
}
