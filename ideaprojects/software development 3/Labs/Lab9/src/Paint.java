/*Sdev3
  PACKAGE_NAME
  Created by David
  13:20   24/10/2014
  Software Development 3
*/

public class Paint {

    private double coverage;

    public Paint(){
        this.coverage = 0;
    }

    public Paint(double coverage){
        this.coverage = coverage;
    }

    public double calcAmount(Shape sIn){

        if (sIn instanceof TwoDShape){
            return ((TwoDShape) sIn).getArea() / this.coverage;
        }
        else {
            return ((ThreeDShape)sIn).getArea()/ this.coverage;
        }
    }
}