package exercise1;

import exercise1.Book;

/**
 * Created by David on 23/09/2014.
 */
public class Novel extends Book {
    private String genre;

    public Novel(String titleIn,int pagesIn,String genreIn){
        super(titleIn, pagesIn);
        genre = genreIn;
    }

    public void print() {
        super.print();
        System.out.println(" Genre: " + genre + "\n");
    }
}
