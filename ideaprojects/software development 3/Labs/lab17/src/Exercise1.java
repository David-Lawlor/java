/*IdeaProjects
  PACKAGE_NAME
  Created by David
  13:34   18/11/2014
  Software Development 3
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise1 extends JFrame{
  private JLabel caption;         // declares a new caption
  private JTextField name;        // declares a new JTextField
  private JTextField nameCopy;    // declares a new JTextField
  private JButton enter;          // declares a new button

  private final int WINDOW_WIDTH = 300;
  private final int WINDOW_HEIGHT = 300;


  public Exercise1(){
    setTitle("Name Copy");                          // sets the title for the window
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Specify what happens when the close button is clicked.
    setSize(WINDOW_WIDTH,WINDOW_HEIGHT);            // sets the window size
    setResizable(false);                            // makes the window non resizable
    //setLocation(150, 250);
    //setLocationByPlatform(true);
    setLocationRelativeTo(null);                    // sets the window to open in the center of the screen
    Color c = new Color(240,240,240);               // creates a color object
    getContentPane().setBackground(c);              // gets the content pane for the frame and sets the background color
    setLayout(new FlowLayout());                    // sets the layout of the default container inside the JFrame to flow
    caption = new JLabel("Please enter your name"); // initialises the JLabel
    add(caption);                                   // adds the JLabel to the frame
    name = new JTextField(20);                      // initialises the name textfield
    add(name);                                      // adds name to the default container
    nameCopy = new JTextField(20);                  // initialises the nameCopy textfield
    add(nameCopy);                                  // adds nameCopy to the default container
    enter = new JButton("Enter");                   // initialises the button and names it enter
    add(enter);                                     // adds enter button to the default container
    enter.addActionListener(new ActionListener() {  // creates an actionListener
      @Override
      public void actionPerformed(ActionEvent e) {
        nameCopy.setText(name.getText());
      }
    });

  }

  public static void main(String[] args) {
    Exercise1 defaultFrame = new Exercise1();
    defaultFrame.setVisible(true);
  }
}
