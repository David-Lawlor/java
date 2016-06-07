package exercise1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Counter extends JFrame implements ActionListener {
    private JTextField cField; // To get the Celsius temperature
    private JButton upButton, dnButton, rButton;      // Calculates everything
    private JLabel inputMsg;
    // Constants for window size
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 100;
    private int c = 0;


    public Counter() {
        // Set the title.
        setTitle("Counter Application");
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // Create a label prompting for the total sales.
        inputMsg = new JLabel("Counter:");
        add(inputMsg);
        // Create a text field for total sales.
        cField = new JTextField(3);
        add(cField);
        // Create 3 buttons to click.
        upButton = new JButton("Count Up");
        add(upButton);
        upButton.addActionListener(this);

        dnButton = new JButton("Count Down");
        add(dnButton);
        dnButton.addActionListener(this);

        rButton = new JButton("Reset");
        add(rButton);
        rButton.addActionListener(this);

        // Size and display the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }
/*
    // actionPerformed using getActionCommand()
    public void actionPerformed(ActionEvent e) {
        String btnLabel = e.getActionCommand();
        // event.getActionCommand() returns the button's label
        if (btnLabel.equals("Count Up")) {
            c++;
            cField.setText(Integer.toString(c));

        } else if (btnLabel.equals("Count Down")) {
            c--;
            cField.setText(Integer.toString(c));
        } else {
            c=0;
            cField.setText(Integer.toString(c));
        }
    }
    */

    // actionPerformed using getSource()
    public void actionPerformed(ActionEvent e) {
       // Get a reference of the source that has fired the event.
       // getSource() returns a java.lang.Object. Downcast back to Button.
        JButton b = (JButton) e.getSource();
        if (b == upButton) {
            c++;
            cField.setText(Integer.toString(c));

        } else if (b == dnButton) {
            c--;
            cField.setText(Integer.toString(c));
        } else {
            c=0;
            cField.setText(Integer.toString(c));
        }
    }


    public static void main(String args[]) {
        Counter c = new Counter();
        c.setVisible(true);
    }
}
