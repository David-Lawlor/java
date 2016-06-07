/**
 * Created by David on 10/10/2014.
 */
public class Rockband {
    private String bandName;
    private String label;
    Musician [] bandMembers;

    public Rockband(String bandIn, String labelIn, String[] names, String[] instruments){
        bandName = bandIn;
        label = labelIn;
        bandMembers = new Musician[names.length];
        for (int i = 0; i < names.length; i++){
            bandMembers[i] = new Musician(names[i], instruments[i]);
        }
    }

    public boolean changeRecordLabel(String newLabel){
        if (newLabel.equals(label)) {
                return false;
            }
        else {
            label = newLabel;
            return true;
        }
    }

    public void print(){
        System.out.println("Name: " + bandName);
        System.out.println("Record company: " + label);
        for (int i = 0; i < bandMembers.length; i++){
            bandMembers[i].print();
        }
    }
}
