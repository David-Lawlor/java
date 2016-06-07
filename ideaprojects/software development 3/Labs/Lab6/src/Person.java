/**
 * Created by David on 10/10/2014.
 */
public class Person {
    private String name;

    public Person (String nameIn){
        name = nameIn;
    }

    public String getName(){
        return name;
    }

    public void setName(String nameIn){
        name = nameIn;
    }

    public void print(){
        System.out.print("\t" + name + " plays ");
    }
}
