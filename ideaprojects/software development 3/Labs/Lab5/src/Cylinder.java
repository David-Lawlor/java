/**
 * Created by David on 07/10/2014.
 */
public class Cylinder extends Circle {
    private double height;
    private double volume;

    public Cylinder(String colourIn, double radiusIn, double heightIn){
        super(colourIn, radiusIn);
        height = heightIn;
        volume = 0;
    }

    public void print(){
        super.print();
        System.out.println("Height: " + height);
    }

    public void calcArea(){
        System.out.println("The surface area of the cylinder is: " + ((2*Math.PI*radius*radius)+ (2*Math.PI*radius*height)));
    }

    public void calcVolume(){
        System.out.println("The volume of the radius is: " + Math.PI*radius*radius*height);
    }
}
