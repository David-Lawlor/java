/*Sdev3
  PACKAGE_NAME
  Created by David
  16:14   23/10/2014
  Software Development 3
*/

public class Sphere extends ThreeDShape {

    public Sphere(){
        super();
    }

    public Sphere(int x, int y, int radius){
        super(x, y, radius);
    }

    public String getName(){
        return ("Sphere");
    }

    public int getRadius(){
        return getLength();
    }

    public int getArea(){
        return (int)(4*Math.PI*getRadius()*getRadius());
    }

    @Override
    public int getVolume() {
        return (int)((4/3.0)* Math.PI * Math.pow(getRadius(),3));
    }

    @Override
    public String toString() {
        return super.toString() + " Radius " + getRadius();
    }
}
