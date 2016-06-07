package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import db.UniOperations;
import model.*;

public class AddGUI implements ActionListener {
	
	private JTextField name;
	private JButton add;
	private University uni;
	private JDialog addD;
	private UniOperations uo;
    private String uName;

	public AddGUI(JFrame parent,University u, UniOperations uo, String uName) {
		addD = new JDialog(parent,true);
		addD.setTitle("Add");
		addD.setSize(300,200);
		addD.setLocationRelativeTo(null);
				
		this.uni = u;
        this.uo=uo;
        this.uName=uName;
		
		JPanel top = new JPanel(new GridLayout(2,2));
		
		top.add(new JLabel("Department Name:"));
		name = new JTextField();
		top.add(name);
		
//		top.add(new JLabel("Department ID:"));
//		id = new JTextField();
//		top.add(id);
		
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
			if (name.getText().equals(""))  {
				JOptionPane.showMessageDialog(null,
						"Name or ID cannot be blank");
				name.setText("");

				name.requestFocus();
			} else {
				try {

					String n = name.getText();

					if ((Department.isNumber(n)) == false) {
						Department d = new Department(n);
                        uo.addDep(d, uName);
                        uni.addDep();
                        JOptionPane.showMessageDialog(null, "Data Saved");
						addD.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null,
								"Name cannot be numeric");
						name.setText("");

					}
				} catch (NumberFormatException nf) {
					JOptionPane.showMessageDialog(null, "Wrong data format");
					name.setText("");

				}

			}

		}
	}

}













