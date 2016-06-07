import java.io.*;
import java.util.ArrayList;

/**
 * Created by DL on 17/03/2015.
 * Lab 8 on file io. Serializing an class and writing it to a file
 */
public class SerializeStock {

    private final String file = "Software Development 4/Labs/Lab8 File IO/res/stock.dat";

    private void write(ArrayList<Stock> s){
        try(FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            for(Stock x: s)
                oos.writeObject(x);

        }catch(NotSerializableException ex1){
            System.out.println("Class is not serializable");
        }catch (IOException ex2){
            System.out.println("Error writing object to stream");
        }
    }

    private void read(){
        Stock s;
        try(FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis)){

            do{
                try{
                    s = (Stock) ois.readObject();
                    System.out.println(s);
                }catch (EOFException eof){
                    System.out.println("End of file reached");
                    break;
                }
            }while (true);

        }catch (IOException ioe){
            System.out.println("File cannot be found");
        }catch (ClassNotFoundException cnf){
            System.out.println("Class class cannot be found");
        }
    }

    public static void main(String[] args) {

        ArrayList<Stock> s = new ArrayList<>();
        s.add(new Stock(1, "Description1", 11));
        s.add(new Stock(2, "Description2", 12));
        s.add(new Stock(3, "Description3", 13));
        s.add(new Stock(4, "Description4", 14));

        SerializeStock ss = new SerializeStock();

        ss.write(s);
        ss.read();
    }
}
