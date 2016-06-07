package Exercise2;

/**
 * Created by David on 03/10/2014.
 */
public class RefuseTruck {
    private int maxBins;
    private int noOfBinsDeclined;
    private int noOfBinsCollected;
    private double ratePerKg;
    private double totalWeight;

    public RefuseTruck(int binsIn, double rateKg){
        maxBins = binsIn;
        ratePerKg = rateKg;
        noOfBinsCollected = 0;
        noOfBinsDeclined = 0;
        totalWeight = 0;
    }

    public int getNoOfBinsCollected(){
        return noOfBinsCollected;
    }

    public int getMaxBins(){
        return maxBins;
    }

    public void collectBin(double weightIn) {
        if (weightIn > 100) {
            System.out.println("TOO HEAVY");
            noOfBinsDeclined++;
        } else if (noOfBinsCollected == maxBins) {
            System.out.println("TRUCK FULL");
            noOfBinsDeclined++;
        } else {
            noOfBinsCollected++;
            totalWeight += weightIn;
        }
    }

    public void printStats(){
        System.out.println("No of bins Collected: " + noOfBinsCollected + " bins");
        System.out.println("No of bins not Collected: " + noOfBinsDeclined + " bins");
        System.out.println("Average weight of bins collected is; " + (totalWeight/ noOfBinsCollected) + "Kg");
        System.out.println("Average cost of bins collected is: " + (ratePerKg*(totalWeight/noOfBinsCollected)));
    }





}
