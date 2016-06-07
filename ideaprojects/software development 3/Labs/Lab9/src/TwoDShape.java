/*Sdev3
  PACKAGE_NAME
  Created by David
  13:17   21/10/2014
  Software Development 3
*/

public abstract class TwoDShape extends Shape {
    private int d1;
    private int d2;

    public TwoDShape(){
        super();
        d1 = 0;
        d2 = 0;
    }

    public TwoDShape(int x, int y, int d1){
        super(x, y);
        this.d1 = d1;
        this.d2 = d1;
    }

    public int getD1() {
        return d1;
    }

    public int getD2() {
        return d2;
    }

    public abstract int getArea();

    @Override
    public String toString() {
        return super.toString();
    }
}
