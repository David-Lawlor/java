package exampleMap;
public class Apple {
    private String color;

    public Apple(String color) {
        this.color = color;
    }
    public int hashCode(){
        return this.color.length();
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof Apple))
            return false;
        if (obj == this)
            return true;
        return this.color.equals(((Apple) obj).color);
    }
}







