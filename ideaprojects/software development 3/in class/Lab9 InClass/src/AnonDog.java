/*Sdev3
  PACKAGE_NAME
  Created by David
  14:26   22/10/2014
  Software Development 3
*/

public class AnonDog {
    public static void main(String [] args){
        Dog d = new Dog(){
            public void makeSound(){
                System.out.println("The anonymous dog is barking");
            }
        };
    }
}
