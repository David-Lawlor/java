package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import db.ShopOperations;

public class addProductsGUI implements ActionListener {
	JLabel manlbl, sizelbl, pricelbl, qtylbl;
	JTextField mantxt, sizetxt, pricetxt, qtytxt;
	JPanel addPanel, topPanel, bottomPanel;
	JButton addB, clearB;
	private ShopOperations so;

	public addProductsGUI(ShopOperations so)
	{
		this.so=so;
	}
	public JPanel addProductsPanel() {

		addPanel = new JPanel();
		addPanel.setLayout(new BorderLayout());

		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched, "Add Product");
		addPanel.setBorder(titled);

		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(4, 2));
		topPanel.setBackground(Color.white);

		manlbl = new JLabel("Manufacturer");
		topPanel.add(manlbl);
		mantxt = new JTextField(15);
		topPanel.add(mantxt);

		sizelbl = new JLabel("Product Size");
		topPanel.add(sizelbl);
		sizetxt = new JTextField(15);
		topPanel.add(sizetxt);

		pricelbl = new JLabel("Product Price");
		topPanel.add(pricelbl);
		pricetxt = new JTextField(15);
		topPanel.add(pricetxt);

		qtylbl = new JLabel("Quantity");
		topPanel.add(qtylbl);
		qtytxt = new JTextField(15);
		topPanel.add(qtytxt);

		addPanel.add(topPanel, BorderLayout.NORTH);

		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.setBorder(BorderFactory.createEtchedBorder());
		bottomPanel.add(Box.createRigidArea(new Dimension(80, 0)));
		bottomPanel.setBackground(Color.white);

		addB = new JButton("Add");
		addB.addActionListener(this);
		bottomPanel.add(addB);

		clearB = new JButton("Clear");
		clearB.addActionListener(this);
		bottomPanel.add(clearB);

		addPanel.add(bottomPanel, BorderLayout.SOUTH);

		addPanel.setBackground(Color.white);
		return addPanel;
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addB))
		{
			// Exercise 4: You need to add the code for the add button below which takes
			// the data that the user has entered and passes this data as parameters 
			// with a call to a database method addProduct which you need to write in the
			// ShopOperations class

			so.addProduct(mantxt.getText(), Integer.parseInt(sizetxt.getText()),
					Double.parseDouble(pricetxt.getText()), Integer.parseInt(qtytxt.getText()));
		}
		else 
		{
			mantxt.setText("");
			sizetxt.setText("");
			pricetxt.setText("");
			qtytxt.setText("");
			
		}
	}

}
