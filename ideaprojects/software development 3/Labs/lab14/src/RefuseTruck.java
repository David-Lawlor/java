/*Sdev3
  PACKAGE_NAME
  Created by David
  12:09   07/11/2014
  Software Development 3
*/
public class RefuseTruck {
    // Instance Variables
    private int noOfBinsDeclined, noOfBinsCollected, maxBins;
    private double ratePerKg;
    private double totalWeight;

// Constructor

    public RefuseTruck (int noBins, double ratePerKg){
        this.maxBins = noBins;
        this.ratePerKg = ratePerKg;
        this.noOfBinsDeclined = 0;
        this.noOfBinsCollected= 0;
    }

//------------------------------------------------------------------------------------------
//Method 1
//------------------------------------------------------------------------------------------

    public void collectBin(double weight){
        if (weight < 100 && noOfBinsCollected <=maxBins){
            noOfBinsCollected++;
            totalWeight += weight;
        }
        else{
            System.out.println ( "Bin is over the 100Kg weight - Collection declined");
            noOfBinsDeclined ++;
        }
    }

//------------------------------------------------------------------------------------------
// Method 2
//------------------------------------------------------------------------------------------

    public int getNoOfBinsCollected(){
        return noOfBinsCollected;
    }

//------------------------------------------------------------------------------------------
//Method 3
//------------------------------------------------------------------------------------------

    public int getMaxBins(){
        return maxBins;
    }

//------------------------------------------------------------------------------------------
//Method 4
//------------------------------------------------------------------------------------------

    public void printStats (){
        System.out.println("\nNo of bins Collected: " + noOfBinsCollected + " bins");
        System.out.println("No. of bins not collected: " + noOfBinsDeclined + " bins");
        System.out.printf("Average Weight of bins collected is: %.2f kg %n" , (totalWeight/ noOfBinsCollected) );
        System.out.printf("Average cost of bins collected is €%.2f" , ((totalWeight/ noOfBinsCollected)* ratePerKg));
    }
}
