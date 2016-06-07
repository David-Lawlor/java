package Exercise3;

/**
 * Created by David on 30/09/2014.
 */
public class TaxPayer {
    private int rsiNo;
    private double income;

    public TaxPayer(){
        income = 0;
        rsiNo = 0;
    }

    public TaxPayer(int rsiNo,double income) {
        this.income = income;
        this.rsiNo = rsiNo;
    }

    public double getIncome() {
        return income;
    }

    public int getRsiNo() {
        return rsiNo;
    }

    public void setRsiNo(int rsiNo) {
        this.rsiNo = rsiNo;
    }

    public void setIncome(double income) {
        this.income = income;
    }


}
