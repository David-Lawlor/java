/**
 * Created by DL on 17/11/2014.
 */
public class StockItem {
    private int id;
    private String description;
    private int max;
    private int min;
    private int inStock;

    public StockItem(int id, String description, int max, int min, int inStock) {
        this.id = id;
        this.description = description;
        this.max = max;
        this.min = min;
        this.inStock = inStock;
    }

    public void takeOnStock(int numberAdding)
    {
        try {
            if ((inStock + numberAdding) > max) {
                throw new OverMaxException();
            } else {
                inStock += numberAdding;
            }
        }catch(OverMaxException ome){
            System.out.println(ome.getMessage());
        }
    }

    public void issueStock(int numberDeducting)
    {
        try{
            if(inStock-numberDeducting < 0){
                throw new OutOfStockException();
            }
            else if(inStock-numberDeducting < min){
                throw new BelowMinException();
            }
            else
                inStock -= numberDeducting;
        }catch (BelowMinException bme){
            System.out.println(bme.getMessage());
        }
        catch (OutOfStockException ose){
            System.out.println(ose.getMessage());
        }
    }

    public int getInStock(){
        return inStock;
    }
}
