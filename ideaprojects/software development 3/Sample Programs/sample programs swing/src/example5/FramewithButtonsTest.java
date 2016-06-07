package example5;
import javax.swing.*;
import java.awt.*;

class MyFrameButtons extends JFrame
{
      private JButton cancelButton;
      private JButton okButton;
      private Container cPane; // AWT required for this
      
      public MyFrameButtons() 
      	{
        cPane = this.getContentPane(); // AWT required for this
       	setTitle("Frame with Buttons");
        setSize(300, 200);
        setResizable(false);
        setLocation(150, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        setLayout(new FlowLayout()); // AWT required for this
        cPane.setBackground(Color.white); // AWT required for this
                
        okButton = new JButton("OK");
        add(okButton);
        
        cancelButton = new JButton("CANCEL");
        add(cancelButton);  
       }   
}
class FramewithButtonsTest {

    public static void main(String args[])
    {
     MyFrameButtons ButtonFrame = new MyFrameButtons();
     ButtonFrame.setVisible(true);
    }
    
}
