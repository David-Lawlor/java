/**
 * Created by David on 07/10/2014.
 */
public abstract class Shape {
    protected String colour;
    protected double area;

    public Shape(String colourIn){
        colour = colourIn;
        area = 0;
    }

    public void print(){
        System.out.println("Colour: " + colour);
    }

    public abstract void calcArea();
}
