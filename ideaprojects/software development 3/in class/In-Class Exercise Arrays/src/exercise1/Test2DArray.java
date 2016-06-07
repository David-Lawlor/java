package exercise1;

/**
 * Created by pmagee on 24/09/2014.
 */
public class Test2DArray {
    public static void main(String args[]) {

        int [][] example2d = new int[2][3];
        int i=0;

        for (int row = 0; row < example2d.length; row++) {
            for (int col = 0; col < example2d[row].length; col++) {
                example2d[row][col] = i;
                i++;
            }
        }
        for (int row = 0; row < example2d.length; row++) {
            for (int col = 0; col < example2d[row].length; col++) {
                System.out.println(example2d[row][col]);
            }
        }
    }
}
