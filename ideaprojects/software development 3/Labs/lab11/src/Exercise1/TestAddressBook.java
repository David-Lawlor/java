package Exercise1;/*Sdev3
  PACKAGE_NAME
  Created by David
  16:44   02/11/2014
  Software Development 3
*/

import Exercise1.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAddressBook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<AddressBook> addressBooks = new ArrayList<AddressBook>();
        int total = 0;

        for(int i = 0; i < 1; i++ ){
            System.out.println("Enter the owner of address book " + (i+1));
            addressBooks.add(new AddressBook(in.next()));
        }

        for(AddressBook ab: addressBooks){
            System.out.println("Address Book belongs to: " + ab.getOwner());
            ab.displayAll();
            System.out.println("Number of male friends are: " + ab.getNumMale());
        }
        System.out.println("Total Contacts: " + AddressBook.getTotalContacts());


    }
}
