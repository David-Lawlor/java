package Exercise1;

/**
 * Created by David on 02/10/2014.
 */
public class Friend {
    private String name;
    private String phNum;

    public Friend(){
        name = "";
        phNum = "";
    }

    public Friend(String nameIn, String phNumIn){
        name = nameIn;
        phNum = phNumIn;
    }

    public String getName(){
        return name;
    }

    public void setName(String nameIn){
        name = nameIn;
    }

    public String getPhNum(){
        return phNum;
    }

    public void setPhNum(String phNumIn){
        phNum = phNumIn;
    }

    public String toString(){
        return ("Name " + name + "\nNumber " + phNum + "\n");
    }
}

