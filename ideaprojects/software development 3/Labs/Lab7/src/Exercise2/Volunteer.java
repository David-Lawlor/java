package Exercise2;

/**
 * Created by David on 14/10/2014.
 */
public class Volunteer extends StaffMember {

    public Volunteer(String nameIn, String addressIn, String phNumIn){
       super(nameIn, addressIn, phNumIn);
    }

    public double pay(){
        return 0;
    }

    public String toString(){
        return super.toString();
    }
}
