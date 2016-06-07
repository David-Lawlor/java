/*Sdev3
  PACKAGE_NAME
  Created by David
  13:44   29/10/2014
  Software Development 3
*/

public class Membership {

    private String name;
    private int month;
    private int year;


    public Membership(String name, int month, int year)

    {
        this.name = name;
        this.month = month;
        this.year = year;
    }

    public String getName()
    {
        return name;
    }


    public int getMonth()
    {
        return month;
    }


    public int getYear()
    {
        return year;
    }


    public String toString()
    {
        return "Name: " + name +
                " joined in month " +
                month + " of " + year;
    }
}

