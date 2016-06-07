/*Sdev3
  PACKAGE_NAME
  Created by David
  14:36   21/10/2014
  Software Development 3
*/

public class Square extends TwoDShape {

    public Square(){
        super();
    }

    public Square(int x, int y, int squareSide){
        super(x, y, squareSide);
    }

    @Override
    public String getName() {
        return ("Square");
    }

    public int getSide(){
        return getD1();
    }

    @Override
    public int getArea() {
        return (int) (getSide()*getSide());
    }

    @Override
    public String toString() {
        return super.toString() + " Side: " + getSide();
    }
}




