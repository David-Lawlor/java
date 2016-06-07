/**
 * Created by David on 07/10/2014.
 */
public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String colourIn, double widthIn, double lengthIn){
        super(colourIn);
        length = lengthIn;
        width = widthIn;
    }

    public void print(){
        super.print();
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
    }

    public void calcArea(){
        System.out.println("The area of the rectangle is: " + (length * width));
    }
}
