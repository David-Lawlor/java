/**
 * Created by DL on 29/04/2015.
 */
public class Pair {

    private String first;
    private String second;

    public Pair(String f, String s){
        first = f;
        second = s;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String toString(){
        return ("("+first+", "+second+")");
    }


}
