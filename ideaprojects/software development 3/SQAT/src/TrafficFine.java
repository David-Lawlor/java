/*Sdev3
  PACKAGE_NAME
  Created by David
  18:09   07/11/2014
  Software Development 3
*/

/**
 * @author ocawley
 */

public class TrafficFine
{
    public static void main(String[] args) {

        String fine = new String();
        int speed = -100, limit = 30;
        try {
            if (limit == 30) {
                if (speed > 100) {
                    fine = "SUSPEND";
                } else if (speed > 50 && speed <= 100) {
                    fine = "EUR 100";
                } else if (speed > 30 && speed <= 50) {
                    fine = "EUR 80";
                } else {
                    fine = "EUR 0";
                }
            } else if (limit == 50) {
                if (speed > 120) {
                    fine = "SUSPEND";
                } else if (speed > 80 && speed <= 120) {
                    fine = "EUR 150";
                } else if (speed > 50 && speed <= 80) {
                    fine = "EUR 100";
                } else {
                    fine = "EUR 0";
                }
            } else if (limit == 120) {
                if (speed > 200) {
                    fine = "SUSPEND";
                } else if (speed > 120) {
                    fine = "EUR 250";
                } else {
                    fine = "EUR 0";
                }
            } else
                fine = "Invalid limit specified";
        } catch (Exception e) {
            fine = "Invalid input";
        }
        System.out.println(fine);
    }

}