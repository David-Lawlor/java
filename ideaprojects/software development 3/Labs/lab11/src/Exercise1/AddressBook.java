package Exercise1;/*Sdev3
  PACKAGE_NAME
  Created by David
  15:47   02/11/2014
  Software Development 3
*/


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AddressBook {
    Random r = new Random();
    Scanner in = new Scanner(System.in);

    private static int totalContacts;
    private String owner;
    private int numOfContacts;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public AddressBook(String owner){
        this.owner = owner;
        fillList();
    }

    public void fillList(){
        String tempName, tempMobile;
        char tempGender;
        numOfContacts = r.nextInt(2) + 1;
        System.out.println(numOfContacts);
        totalContacts += numOfContacts;
        for (int i = 0; i < numOfContacts; i++){
            System.out.print("Enter name for contact" + (i+1));
            tempName = in.next();
            System.out.print("Enter gender for contact " + (i + 1));
            tempGender = in.next().charAt(0);
            System.out.print("Enter mobile for contact " + (i + 1));
            tempMobile = in.next();
            contacts.add(new Contact(tempName,tempGender,tempMobile));
        }
    }

    public void displayAll(){
        for(Contact x: contacts){
            System.out.println(x.getName() + " " + x.getGender() + " " + x.getMobile());
        }
    }

    public int getNumMale(){
        int total = 0;
        for (Contact x: contacts){
            if (x.gender == 'M' || x.gender == 'm'){
                total++;
                System.out.println(total);
            }
        }
        return total;
    }

    public String getOwner(){
        return this.owner;
    }

    static int getTotalContacts(){
        return totalContacts;
    }




}
