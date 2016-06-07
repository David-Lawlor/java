/*IdeaProjects
  PACKAGE_NAME
  Created by David
  13:02   28/11/2014
  Software Development 3
*/

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MortgageGUI extends JFrame{
  private JPanel p1;
  private JPanel p2;
  //private JLabel l_IntRate, l_Year, l_LoanAmt, l_MonRepay, l_TotRepay;
  private JTextField t_IntRate, t_Year, t_LoanAmt, t_MonRepay, t_TotRepay;
  private JButton comMor, clear, quit;
  private DecimalFormat df = new DecimalFormat("€###,###.##");
  private static int mortgageCounter = 0;

  private final int WINDOW_WIDTH = 500;
  private final int WINDOW_HEIGHT = 200;


  public MortgageGUI(){
    super("Mortgage Calculator");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new BorderLayout());

    comMor = new JButton("Compute Mortgage");
    comMor.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          Mortgage m1 = new Mortgage(mortgageCounter, Double.parseDouble(t_IntRate.getText()), Integer.parseInt(t_Year.getText()),
                  Double.parseDouble(t_LoanAmt.getText()));
          mortgageCounter++;
          //t_MonRepay.setText(String.format("€%.2f",m1.monthlyPay()));
          //t_TotRepay.setText(String.format("€%.2f",m1.totalPay()));
          //t_MonRepay.setText("€"+Double.toString(m1.monthlyPay()));
          //t_TotRepay.setText("€"+Double.toString(m1.totalPay()));
          //t_MonRepay.setText("€" + df.format(m1.monthlyPay()));
          //t_TotRepay.setText("€" + df.format(m1.totalPay()));
          t_MonRepay.setText(df.format(m1.monthlyPay()));
          t_TotRepay.setText(df.format(m1.totalPay()));
        }catch(NumberFormatException nfe){
          JOptionPane.showMessageDialog(null, "You must enter valid data", "Warning",
                  JOptionPane.WARNING_MESSAGE);
        }
      }
    });
    clear = new JButton("Clear Text");
    clear.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        t_MonRepay.setText(null);
        t_TotRepay.setText(null);
        t_IntRate.setText(null);
        t_Year.setText(null);
        t_LoanAmt.setText(null);
      }
    });

    quit = new JButton("Quit");
    quit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    t_IntRate = new JTextField();
    t_Year = new JTextField();
    t_LoanAmt = new JTextField();
    t_MonRepay = new JTextField();
    t_MonRepay.setEditable(false);
    t_TotRepay = new JTextField();
    t_TotRepay.setEditable(false);

    p1 = new JPanel(new GridLayout(5,2));
    p1.setBorder(new TitledBorder("Enter interest rate, year and loan amount"));
    p1.add(new JLabel("Interest Rate %"));
    p1.add(t_IntRate);
    p1.add(new JLabel("Years"));
    p1.add(t_Year);
    p1.add(new JLabel("Loan Amount"));
    p1.add(t_LoanAmt);
    p1.add(new JLabel("Monthly Payment"));
    p1.add(t_MonRepay);
    p1.add(new JLabel("Total Payment"));
    p1.add(t_TotRepay);

    p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p2.add(comMor);
    p2.add(clear);
    p2.add(quit);

    add(p1, BorderLayout.NORTH);
    add(p2, BorderLayout.SOUTH);

  }
}
