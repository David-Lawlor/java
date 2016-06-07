package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UserGUISol extends JFrame {

	private JTextField name, address1, address2, age, emailAddress;
	private JRadioButton mr, mrs, ms;
	private JTextArea status;
	private ButtonGroup title;
	private JComboBox<String> choiceBox;
	private JButton submit, quit;
	private JLabel choose;

	private GridBagLayout layout; // layout of this frame
	private GridBagConstraints gc; // constraints of this layout

	public UserGUISol() {
		super("Add User");
		this.setTitle("GridBagLayout");
		layout = new GridBagLayout();
		this.setLayout(layout); // set frame layout
		this.setSize(800, 400);

		gc = new GridBagConstraints();

		choose = new JLabel("Please Choose:");
		this.addComponent(choose, 0, 0, 1, 1);
        gc.weightx = 0.5;
        gc.weighty = 0.5;

		title = new ButtonGroup();
		mr = new JRadioButton("Mr", false);
		this.addComponent(mr, 0, 1, 1, 1);
		mr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("You chose: " + mr.getText());
            }
        });
		title.add(mr);

		mrs = new JRadioButton("Mrs", false);
		this.addComponent(mrs, 0, 2, 2, 1);
		mrs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("You chose: " + mrs.getText());
            }
        });
		title.add(mrs);

		ms = new JRadioButton("Ms", false);
		this.addComponent(ms, 0, 4, 1, 1);
		ms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("You chose: " + ms.getText());
            }
        });
		title.add(ms);

		JLabel n = new JLabel("Name:");
		this.addComponent(n, 1, 0, 1, 1);

		name = new JTextField(15);
		this.addComponent(name, 1, 1, 1, 1);

		JLabel a1 = new JLabel("Address 1:");
		this.addComponent(a1, 1, 2, 1, 1);

		address1 = new JTextField(15);
		this.addComponent(address1, 1, 4, 1, 1);

		JLabel ag = new JLabel("Age:");
		this.addComponent(ag, 2, 0, 1, 1);

		age = new JTextField(15);
		this.addComponent(age, 2, 1, 1, 1);

		JLabel a2 = new JLabel("Address 2:");
		this.addComponent(a2, 2, 2, 1, 1);

		address2 = new JTextField(15);
		this.addComponent(address2, 2, 4, 1, 1);

		JLabel em = new JLabel("Email Address:");
		this.addComponent(em, 3, 0, 1, 1);

		emailAddress = new JTextField(15);
		this.addComponent(emailAddress, 3, 1, 1, 1);

		JLabel a3 = new JLabel("Address 3:");
		this.addComponent(a3, 3, 2, 1, 1);

		choiceBox = new JComboBox<String>();
		choiceBox.addItem("Waterford");
		choiceBox.addItem("Dublin");
		choiceBox.addItem("Cork");
		choiceBox.addItem("Galway");
		choiceBox.addItem("Belfast");
		choiceBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                status.setText("You chose: "
                        + choiceBox.getSelectedItem().toString());
            }
        });

		this.addComponent(choiceBox, 3, 4, 1, 1);

		submit = new JButton("Submit");
		this.addComponent(submit, 4, 1, 1, 1);
		submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameString = name.getText();
                if (validateEmail(emailAddress.getText())) {
                    String em = emailAddress.getText();
                    status.setText("Valid Email address: " + em);
                } else {
                    status.setText("Email address must contain an @");
                }

                if (nameString.length() > 15) {
                    status.setText("The name entered is too long");
                }
            }
        });

		quit = new JButton("Quit");
		this.addComponent(quit, 4, 2, 1, 1);
		quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

		status = new JTextArea(5, 50);
		JScrollPane scroll = new JScrollPane(status);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.addComponent(scroll, 5, 0, 5, 1);
		this.setVisible(true);
	}

	private void addComponent(Component component, int row, int column,
			int width, int height) {
		gc.gridx = column; // set gridx
		gc.gridy = row; // set gridy
		gc.gridwidth = width; // set gridwidth
		gc.gridheight = height; // set gridheight
		layout.setConstraints(component, gc); // set constraints
		add(component); // add component
	} // end method addComponent

	public boolean validateEmail(String e) {
		boolean valid = false;

		int index = e.indexOf('@');
		if (index != -1) {
			valid = true;
		}
		return valid;
	}
}
