package exercise1;

/**
 * Created by David on 23/09/2014.
 */
public class Book {
    private String title;
    private int pages;

    public Book(String titleIn, int pagesIn){
        title = titleIn;
        pages = pagesIn;
    }

    public String getTitle(){
        return title;
    }

    public int getPages(){
        return pages;
    }

    public void setPages(int pagesIn){
        pages = pagesIn;
    }

    public void setTitle(String titleIn){
        title = titleIn;
    }

    public void print(){
        System.out.print("Book " + title + " has " + pages + " pages ");

    }

}