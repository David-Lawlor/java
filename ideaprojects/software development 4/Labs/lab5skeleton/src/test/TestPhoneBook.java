package test;

import gui.PhoneBookGui;
import model.PhoneBook;
import database.ContactOperations;

public class TestPhoneBook {
	public static void main(String[] args){	
		ContactOperations co = new ContactOperations();
		PhoneBook p = new PhoneBook("John", co);
		PhoneBookGui pb = new PhoneBookGui(p,co);
	}
}
