/**
 * Created by DL on 29/04/2015.
 */
public class GenericPair<T> {
    private T first;
    private T second;

    public GenericPair(T f, T s){
        first = f;
        second = s;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public String toString(){
        return ("("+first+", "+second+")");
    }
}
