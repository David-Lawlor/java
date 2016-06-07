/**
 * Created by David on 07/10/2014.
 */
public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String colourIn, double baseIn, double heightIn){
        super(colourIn);
        height = heightIn;
        base = baseIn;
    }

    public void print(){
        super.print();
        System.out.println("Base: " + base);
        System.out.println("Height: " + height);
    }

    public void calcArea(){
        System.out.println("The area of the triangle is; " + (base * .5 * height ));
    }
}
