package exercise1;


/**
 * Created by David on 23/09/2014.
 */
public class Textbook extends Book {
    private int grade;

    public Textbook(String titleIn,int pagesIn,int gradeIn){
        super(titleIn, pagesIn);
        grade = gradeIn;
    }

    public void setGrade(int gradeIn){
        grade = gradeIn;
    }

    public int getGrade(){
        return grade;
    }

    public void print(){
        super.print();
        System.out.print(" Grade level is " + grade + "\n");
    }
}
