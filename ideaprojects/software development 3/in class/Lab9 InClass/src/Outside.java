/*Sdev3
  PACKAGE_NAME
  Created by David
  14:05   22/10/2014
  Software Development 3
*/

public class Outside {
    private int x;

    public Outside(int x){
        this.x = x;
    }

    public int getX() {
        return x;
    }

    class Inside{
        int y;

        Inside(int y) {
            this.y = y;
        }

        public int getY() {
            return y;
        }

        public void add(){
            System.out.println("Sum is " + (x+y));
        }
    }

    public void multiply(){
        Inside i = new Inside(5);
        //System.out.println("Product is " + (x*y));
        System.out.println("Product is " + (x * i.getY()));
    }
}

