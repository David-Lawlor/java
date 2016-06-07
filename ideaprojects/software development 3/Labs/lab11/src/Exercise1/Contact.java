package Exercise1;/*Sdev3
  PACKAGE_NAME
  Created by David
  16:22   02/11/2014
  Software Development 3
*/

public class Contact {
    String name;
    char gender;
    String mobile;

    public Contact(String name, char gender, String mobile){
        this.name = name;
        this.gender = gender;
        this.mobile = mobile;
    }

    public char getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName(){
        return name;

    }

}
