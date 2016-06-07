/*Sdev3
  PACKAGE_NAME
  Created by David
  13:53   21/10/2014
  Software Development 3
*/

public class Circle extends TwoDShape {


    public Circle(){
        super();
    }

    public Circle(int x, int y, int radius){
        super(x, y, radius);
    }

    @Override
    public String getName() {
        return ("Circle");
    }

    public int getRadius() {
        return getD1();
    }

    public int getArea(){
        return (int)(Math.PI * getRadius() * getRadius());
    }

    @Override
    public String toString() {
        return (super.toString() + " Radius: " + getRadius()) ;
    }
}
