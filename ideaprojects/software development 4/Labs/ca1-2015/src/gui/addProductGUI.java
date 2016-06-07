package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import db.ProductOperations;

public class addProductGUI implements ActionListener {

	private JTextField nametxt,brandtxt,pricetxt,qtytxt,branchtxt;
	private JPanel addPanel, bottomPanel;
	private JButton addB;
	private JTextArea details;
	private JButton exitB, clearB;
	private ButtonGroup categoryGroup;
	private JRadioButton laptops, desktops, tablets;
	private ProductOperations po;

	public addProductGUI(ProductOperations po) {
		this.po = po;
	}

	public JPanel addPlaceAdPanel() {

		addPanel = new JPanel();
		addPanel.setLayout(new GridLayout(3, 1, 10, 10));

		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched, "Add a new Product");
		addPanel.setBorder(titled);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
		topPanel.setBorder(BorderFactory.createEtchedBorder());
		topPanel.add(Box.createRigidArea(new Dimension(80, 0)));
		topPanel.setBackground(Color.white);

		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.LINE_AXIS));
		radioPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
		radioPanel.setBackground(Color.white);

		laptops = new JRadioButton("Laptops", true);
		laptops.addActionListener(this);
		laptops.setBackground(Color.white);
		radioPanel.add(laptops);
		desktops = new JRadioButton("Desktops");
		desktops.addActionListener(this);
		desktops.setBackground(Color.white);
		radioPanel.add(desktops);
		tablets = new JRadioButton("Tablets");
        tablets.addActionListener(this);
        tablets.setBackground(Color.white);
		radioPanel.add(tablets);

		categoryGroup = new ButtonGroup();
		categoryGroup.add(laptops);
		categoryGroup.add(desktops);
		categoryGroup.add(tablets);

		topPanel.add(radioPanel);
		JPanel labelPanel = new JPanel();

		JLabel sortLabel = new JLabel("Please Choose", SwingConstants.LEFT);
		labelPanel.setBackground(Color.white);
		labelPanel.add(sortLabel);
		topPanel.add(labelPanel);

		JPanel detailsPanel = new JPanel();
        detailsPanel.setBorder(BorderFactory.createEtchedBorder());
        detailsPanel.setLayout(new GridLayout(5,2));


        JLabel namelbl = new JLabel("Name", SwingConstants.LEFT);
        detailsPanel.add(namelbl);
		nametxt = new JTextField(15);
        detailsPanel.add(nametxt);
        detailsPanel.setBackground(Color.WHITE);

        JLabel brandlbl = new JLabel("Brand", SwingConstants.LEFT);
        detailsPanel.add(brandlbl);
        brandtxt = new JTextField(15);
        detailsPanel.add(brandtxt);
        detailsPanel.setBackground(Color.WHITE);

        JLabel pricelbl = new JLabel("Price", SwingConstants.LEFT);
        detailsPanel.add(pricelbl);
        pricetxt = new JTextField(15);
        detailsPanel.add(pricetxt);
        detailsPanel.setBackground(Color.WHITE);

        JLabel qtylbl = new JLabel("Quantity", SwingConstants.LEFT);
        detailsPanel.add(qtylbl);
        qtytxt = new JTextField(15);
        detailsPanel.add(qtytxt);
        detailsPanel.setBackground(Color.WHITE);

        JLabel branchlbl = new JLabel("Branch", SwingConstants.LEFT);
        detailsPanel.add(branchlbl);
        branchtxt = new JTextField(15);
        detailsPanel.add(branchtxt);
        detailsPanel.setBackground(Color.WHITE);
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.setBorder(BorderFactory.createEtchedBorder());
		bottomPanel.add(Box.createRigidArea(new Dimension(50, 0)));
		bottomPanel.setBackground(Color.white);

		addB = new JButton("Add");
		addB.addActionListener(this);
		bottomPanel.add(addB);

		addPanel.add(topPanel);
		addPanel.add(detailsPanel);
		addPanel.add(bottomPanel);

		addPanel.setBackground(Color.white);
		return addPanel;
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addB)) {
			String category ="";

			if (laptops.isSelected())
				category = laptops.getText();
			else if(desktops.isSelected())
				category = desktops.getText();
			else if(tablets.isSelected())
				category = tablets.getText();
			/* Insert your code here for Exercise 4 */
			po.addProduct(nametxt.getText(), brandtxt.getText(), Double.parseDouble(pricetxt.getText()),
					Integer.parseInt(qtytxt.getText()), category, branchtxt.getText());
			nametxt.setText("");
			brandtxt.setText("");
			pricetxt.setText("");
			qtytxt.setText("");
			branchtxt.setText("");


		} else if (e.getSource().equals(clearB)) {
			details.setText("");
		} else if (e.getSource().equals(exitB)) {
            po.closeDB();
			System.exit(0);
		}
	}

}
