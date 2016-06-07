package Test;/*IdeaProjects
  Test
  Created by David
  11:48   04/02/2015
  Software Development 3
*/

import Model.ContactsDB;

public class TestContacts {
  public static void main(String[] args) {

    ContactsDB pB = new ContactsDB();

    pB.openDB();

    pB.buildContactsTable();

    pB.showDB();

    pB.insert(5, "Timmy", "34 Sommerville Heights", "012334577", "tim@c.com");

    pB.showDB();

    pB.queryDB();

    pB.dropTable();

    pB.closeDB();

  }
}
