package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.*;

public class AddGUI implements ActionListener {
	
	private JTextField name,id;
	private JButton add;
	private University uni;
	private JDialog addD;
	
	public AddGUI(JFrame parent,University u) {
		addD = new JDialog(parent,true);
		addD.setTitle("Add");
		addD.setSize(300,200);
		addD.setLocationRelativeTo(null);
				
		this.uni = u;
		
		JPanel top = new JPanel(new GridLayout(2,2));
		
		top.add(new JLabel("Department Name:"));
		name = new JTextField();
		top.add(name);
		
		top.add(new JLabel("Department ID:"));
		id = new JTextField();
		top.add(id);
		
		addD.add(top,BorderLayout.NORTH);
		
		JPanel bottom = new JPanel(new FlowLayout());
		add = new JButton("Add");
		add.addActionListener(this);
		bottom.add(add);
		
		addD.add(bottom,BorderLayout.SOUTH);
		addD.setVisible(true);
			
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == add) {
			if (name.getText().equals("") || id.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Name or ID cannot be blank");
				name.setText("");
				id.setText("");
				name.requestFocus();
			} else {
				try {
					int num = Integer.parseInt(id.getText());
					String n = name.getText();

					if ((Department.isNumber(n)) == false) {
						Department d = new Department(num, n);
						uni.addDep(d);
						JOptionPane.showMessageDialog(null, "Data Saved");
						addD.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null,
								"Name cannot be numeric");
						name.setText("");
						id.setText("");
					}
				} catch (NumberFormatException nf) {
					JOptionPane.showMessageDialog(null, "Wrong data format");
					name.setText("");
					id.setText("");
				}

			}

		}
	}

}













