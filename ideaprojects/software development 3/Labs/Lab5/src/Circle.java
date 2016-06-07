/**
 * Created by David on 07/10/2014.
 */
public class Circle extends Shape {
    protected double radius;

    public Circle(String colourIn, double radiusIn){
        super(colourIn);
        radius = radiusIn;
    }

    public void print(){
        super.print();
        System.out.println("Radius: " + radius);
    }

    public void calcArea(){
        System.out.println("The area of the circle is: " + radius*radius*Math.PI);
    }
}
