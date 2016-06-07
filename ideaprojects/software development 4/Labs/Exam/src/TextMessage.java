/*IdeaProjects
  PACKAGE_NAME
  Created by David
  01:42   21/05/2015
  Software Development 3
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TextMessage extends JFrame implements ActionListener {

  private JFrame f;
  private JPanel p1, p2, p3;
  private JLabel mobileNet, mobileNumber;
  private JTextField number;
  private JComboBox<String> network;
  private JTextArea output;
  private JButton submit, clear;

  // Constants for window size
  private final int WINDOW_WIDTH = 360;
  private final int WINDOW_HEIGHT = 250;

  public TextMessage() {
    f = new JFrame("Text Message");
    f.setTitle("Mobile Network");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

    mobileNet = new JLabel("Mobile Network");
    mobileNumber = new JLabel("Mobile Number");
    number = new JTextField();
    String[] networkNums = {"085", "086", "087"};
    network = new JComboBox<>(networkNums);

    p1 = new JPanel(new GridLayout(2,2));
    p1.add(mobileNet);
    p1.add(network);
    p1.add(mobileNumber);
    p1.add(number);

    output = new JTextArea();
    p2 = new JPanel(new GridLayout(1,1));
    p2.add(output);

    submit = new JButton("Send");
    clear = new JButton("Clear");

    p3 = new JPanel();
    p3.add(submit);
    p3.add(clear);

    submit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    clear.addActionListener(this);

    f.setLayout(new BorderLayout());
    f.add(p1, BorderLayout.NORTH);
    f.add(p2, BorderLayout.CENTER);
    f.add(p3, BorderLayout.SOUTH);

    f.setVisible(true);

  }

  public static void main(String args[]) {

    TextMessage t = new TextMessage();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submit){
      output.setText(network.getSelectedItem() + number.getText());
    }
    else if(e.getSource() == clear){
      output.setText("");
    }
  }
}

