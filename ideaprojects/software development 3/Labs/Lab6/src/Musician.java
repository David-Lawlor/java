/**
 * Created by David on 10/10/2014.
 */
public class Musician extends Person {
    private String instrument;

    public Musician (String nameIn, String instruIn){
        super(nameIn);
        instrument = instruIn;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instruIn) {
        instrument = instruIn;
    }

    public void print(){
        super.print();
        System.out.println(instrument);
    }
}
