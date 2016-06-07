package GUI;
/*IdeaProjects
  GUI
  Created by David
  01:12   31/01/2015
  Software Development 4
*/

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;


public class BankGUI extends JFrame {
  Bank bank1;
  JLabel welMess;
  JButton appInt, exit;
  JCheckBox savings, current;
  JPanel checkBoxes, buttons, top, bottom;
  boolean savAcc = false, curAcc = false;
  JTextArea details;

  public BankGUI(Bank bankIn){
    bank1 = bankIn;
    setTitle("Banking Application");
    setSize(400, 230);
    setResizable(true);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    details = new JTextArea();
    JScrollPane sp = new JScrollPane(details);
    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    current = new JCheckBox("Current");
    current.setToolTipText("Check to display Current Accounts");

    savings = new JCheckBox("Savings");
    savings.setToolTipText("Check to display all Savings Accounts");

    appInt = new JButton("Apply Interest");
    appInt.setToolTipText("Click here to apply interest to the accounts and show all accounts");
    appInt.setForeground(Color.red);

    exit = new JButton("Exit");
    exit.setToolTipText("Click here to exit the program");
    exit.setForeground(Color.red);

    buttons = new JPanel(new GridLayout(1, 2));
    buttons.add(appInt);
    buttons.add(exit);

    checkBoxes = new JPanel(new FlowLayout(FlowLayout.CENTER));
    checkBoxes.add(savings);
    checkBoxes.add(current);
    checkBoxes.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

    welMess = new JLabel("Welcome to Banking", JLabel.CENTER);
    welMess.setForeground(Color.red);
    welMess.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
    welMess.setBorder(BorderFactory.createLineBorder(Color.RED,1));

    top = new JPanel(new BorderLayout());
    top.add(welMess, BorderLayout.NORTH);
    top.add(sp, BorderLayout.CENTER);

    bottom = new JPanel(new GridLayout(2,1));
    bottom.add(buttons);
    bottom.add(checkBoxes);

    add(top, BorderLayout.CENTER);
    add(bottom, BorderLayout.SOUTH);

    appInt.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        bank1.applyInterest();
        details.setText(bank1.getDetails());

      }
    });

    exit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    savings.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(savAcc)
          savAcc = false;
        else
          savAcc = true;
        display();
      }
    });

    current.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(curAcc)
          curAcc = false;
        else
          curAcc = true;
        display();
      }
    });

  }

  public void display(){
    if(curAcc && !savAcc)
      details.setText(bank1.getDetails("Current"));
    else if(!curAcc && savAcc)
      details.setText(bank1.getDetails("Savings"));
    else if(!curAcc && !savAcc)
      details.setText("");
    else
      details.setText(bank1.getDetails());
  }
}
