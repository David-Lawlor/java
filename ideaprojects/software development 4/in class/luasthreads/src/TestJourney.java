/*IdeaProjects
  PACKAGE_NAME
  Created by David
  13:27   13/04/2015
  Software Development 3
*/

import java.util.ArrayList;
import java.util.List;

public class TestJourney {
  public static void main(String[] args) {
    double[] data = {2.2,3.2,4.5,4.0};

    LuasJourney l = new LuasJourney(data);

    Thread t1 = new Thread(l);
    t1.start();

    try {
      t1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("The total journey time is: " + l.journeyTime());
  }
}
