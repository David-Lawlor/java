/*Sdev3
  PACKAGE_NAME
  Created by David
  13:12   03/11/2014
  Software Development 3
*/

public class Days {
    public static void main(String[] args) {
        String [] days = {"Mon", "Tue", "Wed", "Thur", "Fri"};

        try {
            System.out.println("The next day of the week is " + days[5]);
        }
        catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Invalid index");
            //a.printStackTrace();
            // a.getMessage();
            // a.getCause();
        }
        finally {
            System.out.println("Test");
        }


    }
}
