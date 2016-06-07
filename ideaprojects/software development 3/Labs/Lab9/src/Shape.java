/*Sdev3
  PACKAGE_NAME
  Created by David
  13:21   21/10/2014
  Software Development 3
*/

public abstract class Shape {
    private int x;
    private int y;
    private static int noOfShapes;

    public Shape(){
        x = 0;
        y = 0;
        noOfShapes++;
    }

    public Shape(int x, int y){
        this.x = x;
        this.y = y;
        noOfShapes++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ")" + "(" + y + ")";
    }

    public abstract String getName();

    public static int getNoOfShapes(){
        return noOfShapes;
    }
}
