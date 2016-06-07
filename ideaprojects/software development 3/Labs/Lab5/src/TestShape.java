/**
 * Created by David on 07/10/2014.
 */
public class TestShape {
    public static void main(String []args){
        Shape[] shapes = new Shape[4];


        shapes[0] = new Rectangle("red", 5, 4);
        shapes[1] = new Triangle("blue", 4, 5);
        shapes[2] = new Circle("black", 9 );
        shapes[3] = new Cylinder("indigo", 5, 9);

        for (int i = 0; i < shapes.length; i++){
            shapes[i].print();
            shapes[i].calcArea();

           if(shapes[i] instanceof Cylinder){
               Cylinder c = (Cylinder) shapes[i];
               c.calcVolume();
           }
        }
    }
}
