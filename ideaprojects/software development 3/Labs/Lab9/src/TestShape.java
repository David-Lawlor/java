/*Sdev3
  PACKAGE_NAME
  Created by David
  09:54   24/10/2014
  Software Development 3
*/

public class TestShape {
    public static void main(String[] args) {
        Paint p = new Paint(70);
        Shape [] s1 = {new Circle(22,88,4),
                       new Square(71,96,10),
                       new Sphere(8,89,2),
                       new Cube(79,61,8)};
        int max = -1, min = -1;
        double minValue = Double.MAX_VALUE, maxValue = Double.MIN_VALUE, total =0;

        for (int i = 0; i < s1.length; i++){
            System.out.print(s1[i].getName());
            if (s1[i] instanceof TwoDShape){
                TwoDShape d2 = (TwoDShape) s1[i];
                System.out.println(d2.toString() + "\nArea of " + d2.getName() + " is " + d2.getArea());
            }
            else {
                ThreeDShape d3 = (ThreeDShape) s1[i];
                System.out.println(s1[i].toString() + "\nArea of " +  d3.getName() + " is " + d3.getArea() + "\nVolume of Cube is: " + d3.getVolume());
            }
            if(minValue > p.calcAmount(s1[i]))
            {
                minValue = p.calcAmount(s1[i]);
                min = i;
            }
            if(maxValue < p.calcAmount(s1[i])) {
                maxValue = p.calcAmount(s1[i]);
                max = i;
            }
            System.out.printf("Amount of paint required for %s is %.2f%n%n", s1[i].getName(), p.calcAmount(s1[i]));
            total += p.calcAmount(s1[i]);
        }

        System.out.printf("The total amount of paint required is: %.2f litres%n", total);
        System.out.println("The name of the shape that requires the most paint is: " + s1[max].getName());
        System.out.println("The name of the shape that requires the least paint is: " + s1[min].getName());
        System.out.println("The number of shapes created is: " + Shape.getNoOfShapes());

    }
}
