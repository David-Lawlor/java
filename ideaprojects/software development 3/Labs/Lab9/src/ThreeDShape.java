/*Sdev3
  PACKAGE_NAME
  Created by David
  14:56   21/10/2014
  Software Development 3
*/

public abstract class ThreeDShape extends Shape {
    private int length;
    private int width;
    private int height;

    public ThreeDShape(){
        super();
    }

    public ThreeDShape(int x, int y, int length, int width, int height){
        super(x, y);
        this.width = width;
        this.length = length;
        this.height = height;
    }

    protected ThreeDShape(int x, int y, int length) {
        super(x, y);
        this.length = length;
    }

    public int getLength(){
        return length;
    };

    public int getWidth(){
        return width;
    };

    public  int getHeight(){
        return height;
    };

    public abstract int getArea();

    public abstract int getVolume();

    @Override
    public String toString() {
        return super.toString();
    }
}
