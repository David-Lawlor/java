package Exercise1; /**
 * Created by David on 02/10/2014.
 */

import java.util.Scanner;

public class PhoneBook {
    public static void main(String [] args){
        Scanner in = new Scanner (System.in);
        int input;

        System.out.println("Please enter the number of friends in your phone book");
        input = in.nextInt();

        Friend[] book = new Friend[input];

        for (int i = 0; i < book.length; i++) {
            book[i] = new Friend();
            System.out.println("Please enter name");
            book[i].setName(in.next());
            System.out.println("Please enter number");
            book[i].setPhNum(in.next());
        }

        for (int i = 0; i < book.length; i++){
            System.out.println(book[i].toString());
        }

        int index = -1;

        while (index == -1){
            System.out.println("Please enter the name of the person whose number you wish to update:");
            String temp = in.next();
            for (int i = 0; i < book.length; i++){
                if(temp.equals(book[i].getName())){
                    System.out.println("Enter the new number for " + temp);
                    book[i].setPhNum(in.next());
                    index = i;
                }
            }
            if (index == -1)
                System.out.println("Name not found");
        }
        for (int i = 0; i < book.length; i++){
            System.out.println(book[i].toString());
        }
    }
}


