/*IdeaProjects
  PACKAGE_NAME
  Created by David
  13:41   24/11/2014
  Software Development 3
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cinema extends JFrame {
  private static final int FRAME_WIDTH = 400;
  private static final int FRAME_HEIGHT = 300;
  private static final int FRAME_X_ORIGIN = 150;
  private static final int FRAME_Y_ORIGIN = 250;
  private JButton wolfman, edge, invictus, up, quit;
  private JLabel number, total, title;
  private JTextField amount, quantity;
  private JPanel top, topMiddle, bottomMiddle, bottom, bottomExit;

  public Cinema() {
    // Set window coordinates
    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    this.setTitle("Cinema System");
    this.setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(this);
    this.setLayout(new GridLayout(5, 1));

    // Initialise panels
    top = new JPanel();
    topMiddle = new JPanel();
    bottomMiddle = new JPanel();
    bottom = new JPanel();
    bottomExit = new JPanel();

    // Add panels to the frame
    this.add(top);
    this.add(topMiddle);
    this.add(bottomMiddle);
    this.add(bottom);
    this.add(bottomExit);

    Font titleFont = new Font("Helvetica", Font.ITALIC, 28);

    // Panel 1
    top.setLayout(new FlowLayout());
    title = new JLabel("Welcome to the Cinema");
    title.setFont(titleFont);
    top.add(title);

    // Panel 2
    topMiddle.setLayout(new FlowLayout());
    number = new JLabel("Number of tickets");
    quantity = new JTextField(3);


    topMiddle.add(number);
    topMiddle.add(quantity);

    // Panel 3
    bottomMiddle.setLayout(new GridLayout(2, 2));
    wolfman = new JButton("The Wolfman");

    edge = new JButton("The Edge of Darkness");

    invictus = new JButton("Invictus");

    up = new JButton("Up in the Air");



    bottomMiddle.add(wolfman);
    bottomMiddle.add(edge);
    bottomMiddle.add(invictus);
    bottomMiddle.add(up);

    // Panel 4
    bottom.setLayout(new FlowLayout());
    total = new JLabel();
    amount = new JTextField(6);


    bottom.add(total);
    bottom.add(amount);

    // Panel 5
    bottomExit.setLayout(new FlowLayout());
    quit = new JButton("Exit");
    bottomExit.add(quit);
    quit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

  }

  ////class ButtonListener implements ActionListener{


  //}


  public static void main(String args[]) {
    Cinema c = new Cinema();
    c.setVisible(true);
  }
}

