package example3;
import javax.swing.*;      

class MyFrame2 extends JFrame
{
  public MyFrame2() 
  {
        // set the default properties using inherited methods
        setTitle(" My first Frame");
        setSize(400, 200);
        setLocation(200, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        } 
}
public class TestFrame2 
 {
	 public static void main(String args[])
	 {
	 MyFrame2 myFirstFrame = new MyFrame2();
     myFirstFrame.setVisible(true);

     }
}


