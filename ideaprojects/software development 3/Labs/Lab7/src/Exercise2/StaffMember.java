package Exercise2;

/**
 * Created by David on 14/10/2014.
 */
public abstract class StaffMember {
    private String name;
    private String address;
    private String phNum;

    public StaffMember(String nameIn, String addressIn, String phNumIn){
        name = nameIn;
        address = addressIn;
        phNum = phNumIn;
    }

    public abstract double pay();

    public String getName(){
        return this.name;
    }

    public String toString(){
        return ("Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phNum );
    }
}
