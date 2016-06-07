package Exercise2;

/**
 * Created by David on 14/10/2014.
 */
public class Executive extends Employee {
    private double bonus;

    public Executive (String nameIn, String addressIn, String phNumIn, String rsiNumIn, double salaryIn){
        super(nameIn, addressIn, phNumIn, rsiNumIn, salaryIn);
        bonus = 0;
    }

    public void awardBonus(double bonusIn){
        bonus = bonusIn;
    }

    public double pay(){
        return super.pay() + bonus;
    }

    public String toString(){
        return (super.toString());
    }

    }
