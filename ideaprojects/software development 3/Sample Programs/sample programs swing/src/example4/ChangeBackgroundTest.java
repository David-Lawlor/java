package example4;

import javax.swing.*;    
import java.awt.*;  // Needed to access Color

class MyFrame3 extends JFrame{
      public MyFrame3() 
      {
         //set the default properties using inherited methods
        setTitle(" My first Frame");
        setSize(400, 200);
        setLocation(200, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Color c = new Color(100, 200, 200);
        getContentPane().setBackground(c);
      }
}
class ChangeBackgroundTest
{
    public static void main(String args[])
    {
     MyFrame3 myFirstFrame = new MyFrame3();
     myFirstFrame.setVisible(true);
    }   
}




