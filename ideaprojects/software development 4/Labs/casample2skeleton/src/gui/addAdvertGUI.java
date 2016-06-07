package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;

import db.AdvertOperations;

public class addAdvertGUI implements ActionListener {
	private JLabel pricelbl, qtylbl;
	private JTextField pricetxt;
	private JPanel addPanel, middlePanel, bottomPanel;
	private JButton addB;
	private JTextArea details;
	private JButton exitB, clearB;
	private ButtonGroup categoryGroup;
	private JRadioButton outdoor, electronics, furniture;
	private AdvertOperations ao;

	public addAdvertGUI(AdvertOperations ao) {
		this.ao = ao;
	}

	public JPanel addPlaceAdPanel() {

		addPanel = new JPanel();
		addPanel.setLayout(new GridLayout(4, 1, 10, 10));

		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched, "Place an Ad");
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

		outdoor = new JRadioButton("Outdoor", true);
		outdoor.addActionListener(this);
		outdoor.setBackground(Color.white);
		radioPanel.add(outdoor);
		electronics = new JRadioButton("Electronics");
		electronics.addActionListener(this);
		electronics.setBackground(Color.white);
		radioPanel.add(electronics);
		furniture = new JRadioButton("Furniture");
		furniture.addActionListener(this);
		furniture.setBackground(Color.white);
		radioPanel.add(furniture);

		categoryGroup = new ButtonGroup();
		categoryGroup.add(outdoor);
		categoryGroup.add(electronics);
		categoryGroup.add(furniture);

		topPanel.add(radioPanel);
		JPanel labelPanel = new JPanel();

		JLabel sortLabel = new JLabel("Please Choose", SwingConstants.LEFT);
		labelPanel.setBackground(Color.white);
		labelPanel.add(sortLabel);
		topPanel.add(labelPanel);

		JPanel pricePanel = new JPanel();
		pricePanel.setBorder(BorderFactory.createEtchedBorder());
		pricelbl = new JLabel("Price", SwingConstants.LEFT);
		pricePanel.add(pricelbl);
		pricetxt = new JTextField(15);
		pricePanel.add(pricetxt);
		pricePanel.setBackground(Color.WHITE);

		middlePanel = new JPanel();
		middlePanel.setBackground(Color.white);
		qtylbl = new JLabel("Details");
		middlePanel.add(qtylbl);
		details = new JTextArea(3, 30);
		JScrollPane scrollPane = new JScrollPane(details);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		middlePanel.add(scrollPane);

		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.setBorder(BorderFactory.createEtchedBorder());
		bottomPanel.add(Box.createRigidArea(new Dimension(50, 0)));
		bottomPanel.setBackground(Color.white);

		addB = new JButton("Add");
		addB.addActionListener(this);
		bottomPanel.add(addB);

		addPanel.add(topPanel);
		addPanel.add(pricePanel);
		addPanel.add(middlePanel);
		addPanel.add(bottomPanel);

		addPanel.setBackground(Color.white);
		return addPanel;
	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addB)) {
			String category = "";
			if (electronics.isSelected()){
				category = electronics.getText();
			System.out.println(category);}
			else if(furniture.isSelected())
				category = "Furniture";
			else
				category = "Outdoor";

			ao.placeAd(category, Double.parseDouble(pricetxt.getText()), details.getText());

		} else if (e.getSource().equals(clearB)) {
			details.setText("");
		} else if (e.getSource().equals(exitB)) {
			System.exit(0);
		}
	}

}
