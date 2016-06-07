/*Sdev3
  PACKAGE_NAME
  Created by David
  16:39   23/10/2014
  Software Development 3
*/

public class Cube extends ThreeDShape {

    public Cube(){
        super();
    }

    public Cube(int x, int y, int side){
        super(x, y, side);
    }

    public String getName(){
        return ("Cube");
    }

    public int getSide() {
        return super.getLength();
    }

    @Override
    public int getArea() {
        return (int)(6*getSide()*getSide());
    }

    public int getVolume(){
        return (int)(Math.pow(getSide(),3));
    }

    public String toString(){
        return super.toString() + " Side " + getSide();
    }
}
