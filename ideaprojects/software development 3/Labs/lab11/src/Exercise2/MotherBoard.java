package Exercise2;/*Sdev3
  PACKAGE_NAME
  Created by David
  13:12   31/10/2014
  Software Development 3
*/

public class MotherBoard {
    private String manufacturer;
    private int totalMemoryCapacity;
    private MemoryModule[] memMod;

    public MotherBoard(String manufacturer, int totalMemoryCapacity, int memModSize){
        this.manufacturer = manufacturer;
        this.totalMemoryCapacity = totalMemoryCapacity;
        memMod = new MemoryModule[memModSize];
        for (int i = 0; i < memMod.length; i++){
            memMod[i] = new MemoryModule(totalMemoryCapacity/memModSize);
        }
    }

    public String toString(){
        String s = "Motherboard manufacturer: " + manufacturer + " containing: \n";
        for (int i = 0; i < memMod.length; i++) {
            s += memMod[i].toString(i+1);
        }
        return s;
    }

    private class MemoryModule{
        private int capacity;

        MemoryModule(int capacity){
            this.capacity = capacity;
        }

        String toString(int i){
                return "Module " + i + " Size: " + capacity + "MB\n";
        }
    }
}
