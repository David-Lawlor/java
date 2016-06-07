package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.SourceTree;
import database.ContactOperations;

public class PhoneBook {

	private String owner;
	private ArrayList<Contact> clist;
	private ResultSet rset;
	private ContactOperations co;

	public PhoneBook(String o, ContactOperations co) {
		this.co = co;
		owner = o;
		clist = new ArrayList<Contact>();
		refreshList();
	}

	public void refreshList() {
		rset = co.getContacts();

		if (clist.size() > 0) {

			for (int i = clist.size()-1; i >=0; i--) {
				clist.remove(i);
			}
		}
		try {
			while (rset.next()) {
				Contact c = new Contact(rset.getInt(1), rset.getString(2),
						rset.getString(3), rset.getString(4), rset.getString(5));
				clist.add(c);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public Contact getContact(int i) {
		return clist.get(i);
	}

	public String getOwner() {
		return owner;
	}

	public int getNumContacts() {
		return clist.size();
	}
	

	

	public int findContact(String name) {
		int index = -1;
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}

	public void addContactModel(){
		rset = co.getLastRow();
		try{
			Contact c = new Contact(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
			clist.add(c);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public int removeContact(String name) {
		int num = 0;
		for (int i = 0; i < clist.size(); i++) {
			if (name.equals(clist.get(i).getName())) {
				clist.remove(i);
				num++;
			}
		}
		return num;
	}

	public void updatePhoneNum(String newnum, String name){
		co.updatephoneNumber(newnum, name);
		for (int i = 0; i < clist.size(); i++){
			if (clist.get(i).getName().equals(name)){
				clist.get(i).setPhoneNumber(newnum);
			}
		}
	}
}
