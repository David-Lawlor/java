/**
 * Created by DL on 17/11/2014.
 */
public class TestStockItem {
    public static void main(String[] args) {
        StockItem item1 = new StockItem(123, "Shampoo", 100, 10, 25);


            item1.takeOnStock(80);
            item1.issueStock(30);
            item1.issueStock(20);
            System.out.println("Amount left in stock is: " + item1.getInStock());


    }
}
