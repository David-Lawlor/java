/*IdeaProjects
  PACKAGE_NAME
  Created by David
  13:21   13/04/2015
  Software Development 3
*/

public class LuasJourney extends Journey implements Runnable {

  private double journeyTime = 0;

  public LuasJourney(double[] times){
    super(times);
  }

  public void run(){
    for (int i = 0; i < timeInterval.length; i++) {
      journeyTime += timeInterval[i];
      try{
        Thread.sleep(2000);
      }catch (InterruptedException ie){
        ie.printStackTrace();
      }
    }
  }

  public double journeyTime(){
    return journeyTime;
  }

}
