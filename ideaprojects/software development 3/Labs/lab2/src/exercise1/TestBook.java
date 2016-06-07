package exercise1;

import exercise1.Novel;

/**
 * Created by David on 23/09/2014.
 */
public class TestBook {
    public static void main(String [] args){
        Textbook book1 = new Textbook("Core Java", 500, 2);
        Novel book2 = new Novel ("Pride and Prejudice" ,300, "Romance");

        book1.print();
        book2.print();
    }
}
