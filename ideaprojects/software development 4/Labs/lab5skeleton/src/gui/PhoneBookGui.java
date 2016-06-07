package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import model.*;
import database.*;

public class PhoneBookGui extends JFrame implements ActionListener {
	private JPanel p1, p2;
	private JTextField idF, nameF, addF, phoneF, emailF;
	private JButton addB, delB, updateB, forwardB, backB, quitB;
	private JFrame frame;
	private PhoneBook pbook;
	private ContactOperations co;    // Needed to close the db connection and for the AddGUI
	private int counter = 0;

	public PhoneBookGui(PhoneBook p, ContactOperations co) {
		frame = new JFrame();
		frame.setSize(500, 200);
		frame.setTitle("Phone Book Application");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		pbook = p;
		this.co = co;

		frame.setLayout(new GridLayout(1, 2));
		p1 = new JPanel();

		p1.setLayout(new GridLayout(5, 2));

		p1.add(new Label("ID:"));
		idF = new JTextField(10);
		p1.add(idF);

		p1.add(new Label("Name:"));
		nameF = new JTextField(20);
		p1.add(nameF);

		p1.add(new Label("Address: "));
		addF = new JTextField(20);
		p1.add(addF);

		p1.add(new Label("Phone:"));
		phoneF = new JTextField(20);
		p1.add(phoneF);

		p1.add(new Label("E-mail:"));
		emailF = new JTextField(20);
		p1.add(emailF);

		p1.setBorder(new TitledBorder("Contact Details"));

		p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 2));

		addB = new JButton("Add");
		addB.addActionListener(this);
		p2.add(addB);

		delB = new JButton("Delete");
		delB.addActionListener(this);
		p2.add(delB);

		updateB = new JButton("Update");
		updateB.addActionListener(this);
		p2.add(updateB);

		quitB = new JButton("Exit");
		quitB.addActionListener(this);
		p2.add(quitB);

		backB = new JButton("<");
		backB.addActionListener(this);
		p2.add(backB);

		forwardB = new JButton(">");
		forwardB.addActionListener(this);
		p2.add(forwardB);

		p2.setBorder(new TitledBorder("Options"));

		frame.add(p1);
		frame.add(p2);
		setFirst();
		frame.setVisible(true);
	}

	public void setFirst() {
		int pos = 0;           // set to 0  and used below to retrieve 1st element from array list
		counter=0;             // This is the counter used for the forward and back buttons
		Contact c = pbook.getContact(pos);
		this.displayContact(c);
	}

	public void displayContact(Contact c) {
		idF.setText(Integer.toString(c.getID()));
		nameF.setText(c.getName());
		addF.setText(c.getAddress());
		phoneF.setText(c.getPhoneNumber());
		emailF.setText(c.getEmail());
	}

	public void deleteContact() {
		String b = JOptionPane.showInputDialog(null, "Enter the name of the person you wish to delete: ",
				"Contact Manager", JOptionPane.QUESTION_MESSAGE);

		co.deleteContact(b);
		int numberOfDeleted = pbook.removeContact(b);
		JOptionPane.showMessageDialog(null, numberOfDeleted + " Record(s) deleted.");
		setFirst();
	}

	public void updateContact() {
		String b = JOptionPane.showInputDialog(null,"Enter the name of the contact you would like to update: ",
				"Contact Manager", JOptionPane.QUESTION_MESSAGE);

		int index = pbook.findContact(b);
		if (index != -1){
			updateGUI up = new updateGUI(pbook, frame, index);
		}else{
			JOptionPane.showMessageDialog(null, "Contact not found");
		}
	}




	public void actionPerformed(ActionEvent ae) {
		int totalContacts = pbook.getNumContacts();
		if (ae.getSource().equals(delB)) {
			//deleteContact();
			setFirst();
		} else if (ae.getSource().equals(updateB)) {
			//updateContact();
			setFirst();
		} else if (ae.getSource().equals(addB)) {
			AddGUI a = new AddGUI(frame, pbook, co);
			//pbook.addContact();
			//pbook.refreshList();
			setFirst();
		} else if (ae.getSource().equals(forwardB)) {
			if ((counter + 1) < totalContacts) {
				counter++;
				this.displayContact(pbook.getContact(counter));
			}
		} else if (ae.getSource().equals(backB)) {
			if ((counter - 1) >= 0) {
				counter--;
				this.displayContact(pbook.getContact(counter));
			}
		} else {
			co.closeDB();
			System.exit(0);
		}
	}
}
