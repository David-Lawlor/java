/*Sdev3
  PACKAGE_NAME
  Created by David
  14:33   22/10/2014
  Software Development 3
*/

public class AInterface {
    public static void main (String [] args){
        Manageable r = new Manageable() {
            @Override
            public void manage() {
                System.out.println("I am manageable");
            }
        };

        r.manage();
    }
}
