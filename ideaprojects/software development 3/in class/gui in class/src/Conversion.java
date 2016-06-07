/*Sdev3
  PACKAGE_NAME
  Created by David
  14:09   12/11/2014
  Software Development 3
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conversion extends JFrame implements ActionListener {

    private JTextField cInput;
    private JButton calcButton;
    private JLabel cLabel, rLabel;

    private final int WIN_WIDTH = 360;
    private final int WIN_HEIGHT = 100;

    public Conversion() {
        setTitle("Celcius to fahrenheit");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        cLabel = new JLabel("Enter the Celcius temperature");
        add(cLabel);
        cInput = new JTextField(10);
        add(cInput);
        calcButton = new JButton("Calculate Fahrenheit");
        add(calcButton);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        calcButton.addActionListener(this);
        rLabel = new JLabel("");
        add(rLabel);
    }

    public void actionPerformed(ActionEvent ae){
        int c, f;
        String text = cInput.getText();
        c = Integer.parseInt(text);
        f = (c*9/5) + 32;
        rLabel.setText("Fahrenheit" + f);

    }

    public static void main(String[] args) {
        Conversion c = new Conversion();
        c.setVisible(true);
    }
}