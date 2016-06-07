/*IdeaProjects
  PACKAGE_NAME
  Created by David
  13:43   25/11/2014
  Software Development 3
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

public class Calculator extends JFrame {
  private JButton add;
  private JButton subtract;
  private JButton multiply;
  private JButton divide;
  private JButton clear;
  private JButton quit;

  private JTextField text1;
  private JTextField text2;

  private JLabel answer;

  private JPanel lPanel;
  private JPanel rPanel;

  public Calculator(){
    super("Calculator");
    this.setLocationRelativeTo(null);
    this.setSize(400, 100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new GridLayout(1, 2));
    lPanel = new JPanel(new GridLayout(3, 1));
    rPanel = new JPanel(new GridLayout(3, 2));

    text1 = new JTextField();
    text2 = new JTextField();
    answer = new JLabel();
    add = new JButton("+");
    subtract = new JButton("-");
    multiply = new JButton("*");
    divide = new JButton("/");
    clear = new JButton("Clear");
    quit = new JButton("Quit");

    lPanel.add(text1);
    lPanel.add(text2);
    lPanel.add(answer);

    rPanel.add(add);
    rPanel.add(subtract);
    rPanel.add(multiply);
    rPanel.add(divide);
    rPanel.add(clear);
    rPanel.add(quit);

    this.add(lPanel);
    this.add(rPanel);

    add.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          double num1 = Double.parseDouble(text1.getText());
          double num2 = Double.parseDouble(text2.getText());
          answer.setText(Double.toString(num1 + num2));
        }catch(NumberFormatException nfe){
          //JOptionPane.showMessageDialog(null, "You must enter a number", "Error",
          //        JOptionPane.WARNING_MESSAGE);
          showMessage();
        }
      }
    });

    subtract.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          double num1 = Double.parseDouble(text1.getText());
          double num2 = Double.parseDouble(text2.getText());
          answer.setText(Double.toString(num1 - num2));
        }catch(NumberFormatException nfe){
          //JOptionPane.showMessageDialog(null, "You must enter a number", "Error",
          //        JOptionPane.WARNING_MESSAGE);
          showMessage();
        }
      }
    });

    multiply.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          double num1 = Double.parseDouble(text1.getText());
          double num2 = Double.parseDouble(text2.getText());
          answer.setText(Double.toString(num1 * num2));
        }catch(NumberFormatException nfe){
         // JOptionPane.showMessageDialog(null, "You must enter a number", "Error",
         //         JOptionPane.WARNING_MESSAGE);
          showMessage();
        }
      }
    });

    divide.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          double num1 = Double.parseDouble(text1.getText());
          double num2 = Double.parseDouble(text2.getText());
          answer.setText(Double.toString(num1 / num2));
        }catch(NumberFormatException nfe){
          //JOptionPane.showMessageDialog(null, "You must enter a number", "Error",
          //        JOptionPane.WARNING_MESSAGE);
          showMessage();
        }
      }
    });

    clear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        text1.setText("");
        text2.setText("");
        answer.setText("");
      }
    });

    quit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }

  public void showMessage(){
    JOptionPane.showMessageDialog(null, "You must enter a number", "Error",
            JOptionPane.WARNING_MESSAGE);
  }


  public static void main(String[] args) {
    Calculator cal = new Calculator();
    cal.setVisible(true);
  }
}
