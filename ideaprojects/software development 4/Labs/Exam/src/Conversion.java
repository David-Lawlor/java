import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import javax.swing.*;

class Conversion extends JFrame implements ActionListener {
  private JPanel p1, p3;
  private JTextField celsiusInput, fahInput;
  private JButton calcButton;
  private JLabel celsiusMsg, fahMsg;
  private JLabel answer;

  DecimalFormat df = new DecimalFormat("###.00");
  JRadioButton celcius;
  JRadioButton fahrenheit;
  // Constants for window size
  private final int WINDOW_WIDTH = 360;
  private final int WINDOW_HEIGHT = 150;

  public Conversion() {
    // Set the title.
    this.setTitle("Celsius to Fahrenheit");
    // Specify what happens when the close button is clicked.
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    p1 = new JPanel();
    p1.setLayout(new FlowLayout());

    // Create a label prompting for the total sales.
    celsiusMsg = new JLabel("Celcius");
    p1.add(celsiusMsg);
    // Create a text field for total sales.
    celsiusInput = new JTextField(5);
    p1.add(celsiusInput);

    fahMsg = new JLabel("Fahrenheit");
    p1.add(fahMsg);
    // Create a text field for total sales.
    fahInput = new JTextField(5);
    p1.add(fahInput);

    this.add(p1, BorderLayout.NORTH);

    p3 = new JPanel();
    // Create a button to click.
    calcButton = new JButton("Convert");
    p3.add(calcButton);
    answer = new JLabel("Answer:");
    p3.add(answer);
    answer.setVisible(true);

    this.add(p3, BorderLayout.SOUTH);

    JPanel p2 = new JPanel();
    ButtonGroup choices = new ButtonGroup();
    celcius = new JRadioButton("Celcius to fahrenheit");
    fahrenheit = new JRadioButton("Fahrenheit to celcius");
    choices.add(celcius);
    choices.add(fahrenheit);
    p2.add(celcius);
    p2.add(fahrenheit);
    this.add(p2, BorderLayout.CENTER);


    calcButton.addActionListener(this);
    // Size and display the window.
    this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == calcButton){
      if(celcius.isSelected()){
        try{
          double x = Double.parseDouble(celsiusInput.getText());
          x = ((9.0/5.0)*x)+32;
          fahInput.setText(Double.toString(x));
        }catch(NumberFormatException ime){
          fahInput.setText("Error");
        }
      }
      else if(fahrenheit.isSelected()){
        try{
          double x = Double.parseDouble(fahInput.getText());
          x = (5.0/9.0)*(x-32);
          celsiusInput.setText(df.format(x));
        }catch(NumberFormatException ime){
          celsiusInput.setText("Error");
        }
      }
    }
  }
}

class ConversionTest {
  public static void main(String args[]) {
    Conversion c = new Conversion();
    c.setVisible(true);
  }
}
