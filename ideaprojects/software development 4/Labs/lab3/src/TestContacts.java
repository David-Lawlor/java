import java.util.Random;

/**
 * Created by DL on 11/02/2015.
 */
public class TestContacts {
    public static void main(String[] args) {
        Random rand = new Random();
        ContactsDB cont = new ContactsDB();

        cont.openDB();

        cont.dropTable();
;
        cont.buildContactsTable();

        cont.queryDB();

        cont.add(5, "Timmy", "34 Sommerville Heights", "012334577", "tim@c.com");

        cont.delete(rand.nextInt(5)+1);

        cont.queryDB();

        cont.dropTable();

        cont.closeDB();
    }
}
