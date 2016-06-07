package Exercise1;

/**
 * Created by David on 15/10/2014.
 */
public class Food extends Goods {

   private double calories;

    public Food(String desc, double p, double caloriesIn){
        super(desc, p);
        calories = caloriesIn;
    }
}
