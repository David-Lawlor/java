/*IdeaProjects
  PACKAGE_NAME
  Created by David
  11:58   11/02/2015
  Software Development 3
*/

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

class PaymentGUISkeleton extends JFrame
{
  private JRadioButton creditCardRadioButton, billCustomerRadioButton;
  private JList        cardTypeList;
  private JTextField   cardNumberTextField;
  private JComboBox    monthComboBox,yearComboBox;
  private JCheckBox    verifiedCheckBox;
  private JButton      acceptButton,exitButton;
  private JLabel       cardTypeLabel,cardNumberLabel,expirationDateLabel;

  //private GridBagLayout layout;

  public PaymentGUISkeleton()
  {
    setTitle("Payment Application");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridBagLayout());
    setSize(350,350);

    Border loweredBorder= BorderFactory.createBevelBorder(BevelBorder.LOWERED);

    // radio button panel
    JPanel radioPanel = new JPanel();
    ButtonGroup billingGroup = new ButtonGroup();
    radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    radioPanel.setBorder(BorderFactory.createTitledBorder(loweredBorder,"Billing:"));

    // credit card radio button
    creditCardRadioButton = new JRadioButton("Credit card", true);
    billingGroup.add(creditCardRadioButton);
    radioPanel.add(creditCardRadioButton);

    // bill customer radio button
    billCustomerRadioButton = new JRadioButton("Bill customer");
    billingGroup.add(billCustomerRadioButton);
    radioPanel.add(billCustomerRadioButton);

    add(radioPanel, getConstraints(0,0,3,1, GridBagConstraints.WEST));

    // card type label
    cardTypeLabel = new JLabel("Card type:");
    add(cardTypeLabel, getConstraints(0,1,1,1, GridBagConstraints.EAST));

    //


    // Insert Code for the JList
    String[] cardNames = {"Visa", "Master Card", "American Express", "Other"};
    cardTypeList = new JList(cardNames);
    cardTypeList.setFixedCellWidth(170);
    cardTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    cardTypeList.setVisibleRowCount(3);


    JScrollPane cardTypeScrollpane = new JScrollPane(cardTypeList);
    add(cardTypeScrollpane, getConstraints(1,1,2,1, GridBagConstraints.LAST_LINE_START));









    // card number label
    cardNumberLabel = new JLabel("Card number:");
    add(cardNumberLabel, getConstraints(0,2,1,1, GridBagConstraints.EAST));


    // card number text field
    cardNumberTextField = new JTextField(15);
    add(cardNumberTextField, getConstraints(1,2,2,1, GridBagConstraints.LAST_LINE_START));


    // expiration date label
    expirationDateLabel= new JLabel("Expiration date:");
    add(expirationDateLabel, getConstraints(0,3,1,1, GridBagConstraints.CENTER));

    // month combo box
    String[] months = { "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December" };
    monthComboBox = new JComboBox<String>(months);
    add(monthComboBox, getConstraints(1,3,1,1, GridBagConstraints.LAST_LINE_START));


    // year combo box
    String[] years = { "2011", "2012", "2013", "2014", "2015", "2016" };
    yearComboBox = new JComboBox<String>(years);
    add(yearComboBox, getConstraints(2,3,1,1, GridBagConstraints.WEST));


    // verified check box
    verifiedCheckBox = new JCheckBox("Verified");
    add(verifiedCheckBox, getConstraints(1,4,1,1, GridBagConstraints.LAST_LINE_START));


    // calculate button

    acceptButton = new JButton("Accept");
    add(acceptButton, getConstraints(1,5,1,1, GridBagConstraints.EAST));


    // exit button
    exitButton = new JButton("Exit");
    add(exitButton, getConstraints(2,5,1,1, GridBagConstraints.LAST_LINE_START));

  }

  // a  method for setting grid bag constraints
  private GridBagConstraints getConstraints(int gridx, int gridy,
                                            int gridwidth, int gridheight, int anchor)
  {
    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(5, 5, 5, 5);
    c.ipadx = 0;
    c.ipady = 0;
    c.gridx = gridx;
    c.gridy = gridy;
    c.gridwidth = gridwidth;
    c.gridheight = gridheight;
    c.anchor = anchor;
    return c;
  }

  public static void main(String[] args) {
    PaymentGUISkeleton payGUI = new PaymentGUISkeleton();
    payGUI.setVisible(true);
  }


}

