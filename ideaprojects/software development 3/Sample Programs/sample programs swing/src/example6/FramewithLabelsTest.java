package example6;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class FrameButtonsLabel extends JFrame
{
    private JButton cancelButton;
    private JButton okButton;
    private JLabel helloLabel;
    private Container contentPane;
    
    public FrameButtonsLabel() 
    {   
     contentPane = getContentPane();
       
       //set the default properties using inherited methods
      setTitle(" My Frame");
      setSize(300, 200);
      setResizable(false);
      setLocation(150, 250);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      //set content pane properties
      setLayout(new FlowLayout());
      contentPane.setBackground(Color.white);
	  okButton = new JButton("OK");
      add(okButton);
      
      cancelButton = new JButton("CANCEL");
      add(cancelButton); 
      
      helloLabel = new JLabel("Hello Swing");
      add(helloLabel);    
     } 
}
  
  class FramewithLabelsTest {

  public static void main(String args[])
  {
   FrameButtonsLabel ButtonLabelFrame = new FrameButtonsLabel();
   ButtonLabelFrame.setVisible(true);
  }  
}

  