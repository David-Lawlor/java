package test;

import java.util.ArrayList;

import gui.UniGUI;
import model.University;

class TestUniversity
{
	public static void main(String[] args){

		int tdepids[] = {1,2,3,4};
		String tdepnames[] = {"Computing", "Business", "Languages", "Engineering"};
		University u1 =new University("TCD","Mr Bloggs","Dublin", tdepids, tdepnames);
		
		int udepids[] = {1,2,3,4,5};
		String udepnames[] = {"Science", "Marketing", "Arts", "Medicine","History"};
		University u2 =new University("UCD","Mr Baker","Dublin", udepids, udepnames);
		
		ArrayList<University> ulist = new ArrayList<University>();
		ulist.add(u1);
		ulist.add(u2);

		UniGUI ugui = new UniGUI(ulist);
		
	}
}
