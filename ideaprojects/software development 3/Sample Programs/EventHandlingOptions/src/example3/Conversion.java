package example3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Conversion extends JFrame {
    private JTextField celsiusInput; // To get the Celsius temperature
    private JButton calcButton;      // Calculates everything
    private JLabel resultLabel;
    private JLabel celsiusMsg;
    // Constants for window size
    private final int WINDOW_WIDTH = 360;
    private final int WINDOW_HEIGHT = 100;


    public Conversion() {
        // Set the title.
        setTitle("Celsius to Fahrenheit");
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // Create a label prompting for the total sales.
        celsiusMsg = new JLabel("Enter the Celsius temperature:");
        add(celsiusMsg);
        // Create a text field for total sales.
        celsiusInput = new JTextField(10);
        add(celsiusInput);
        // Create a button to click.
        calcButton = new JButton("Calculate Fahrenheit");
        add(calcButton);
        calcButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                int fahrenheitTemp, celsiusTemp;

                String text = celsiusInput.getText();
                celsiusTemp = Integer.parseInt(text);
                fahrenheitTemp = (celsiusTemp * 9 / 5) + 32;
                resultLabel.setText("Fah: " + Integer.toString(fahrenheitTemp));
            }

        });

        resultLabel = new JLabel("");
        add(resultLabel);
        // Size and display the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }


    public static void main(String args[]) {
        Conversion c = new Conversion();
        c.setVisible(true);
    }
}


