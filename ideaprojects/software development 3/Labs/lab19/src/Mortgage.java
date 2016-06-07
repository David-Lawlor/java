/*IdeaProjects
  PACKAGE_NAME
  Created by David
  12:40   28/11/2014
  Software Development 3
*/

public class Mortgage{

  private int id;
  private double interest;
  private int year;
  private double loan;

  // Constructor
  public Mortgage(int Id, double i, int y, double l){
    id = Id;
    interest = i/1200.0;
    year = y;
    loan = l;
  }

  // Find monthly pay
  public double monthlyPay(){
    return loan*interest/(1-(Math.pow(1/(1+interest),year*12)));
  }

  // Find total pay
  public double totalPay(){
    return monthlyPay()*year*12;
  }

  public static void main(String[] args) {
    MortgageGUI mgui = new MortgageGUI();
    mgui.setVisible(true);
  }


}
