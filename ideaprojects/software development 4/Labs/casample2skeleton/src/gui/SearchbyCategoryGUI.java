package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;

import db.AdvertOperations;

public class SearchbyCategoryGUI implements ActionListener {

	private JPanel categoryPanel, rPanel;
	private JTextArea details;
	private JButton exitB, searchB, clearB;
	private JRadioButton outdoor, electronics, furniture;
	private AdvertOperations ao;
	private ButtonGroup categoryGroup;

	public SearchbyCategoryGUI(AdvertOperations ao) {
		this.ao = ao;
	}

	public JPanel addSearchCatPanel() {
		categoryPanel = new JPanel();
		categoryPanel.setLayout(new FlowLayout());

		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched,
				"Search by Category");

		categoryPanel.setBorder(titled);

		JPanel middlePanel = new JPanel();
		middlePanel.setBorder(BorderFactory.createEtchedBorder());
		middlePanel.setBackground(Color.white);

		Icon oIcon = new ImageIcon("imgs/outdoor.png");
		outdoor = new JRadioButton("Outdoor", oIcon, true);
		outdoor.setBackground(Color.white);
		outdoor.addActionListener(this);
		outdoor.setActionCommand("Outdoor");
		middlePanel.add(outdoor);

		Icon eIcon = new ImageIcon("imgs/electronics.png");
		electronics = new JRadioButton("Electronics", eIcon, true);
		electronics.setBackground(Color.white);
		electronics.addActionListener(this);
		electronics.setActionCommand("Electronics");
		middlePanel.add(electronics);

		Icon fIcon = new ImageIcon("imgs/furniture.png");
		furniture = new JRadioButton("Furniture", fIcon, true);
		furniture.setBackground(Color.white);
		furniture.addActionListener(this);
		furniture.setActionCommand("Furniture");
		middlePanel.add(furniture);

		categoryGroup = new ButtonGroup();
		categoryGroup.add(outdoor);
		categoryGroup.add(electronics);
		categoryGroup.add(furniture);

		searchB = new JButton("Search");
		searchB.addActionListener(this);

		JPanel resultsPanel = addresultsPanel();
		resultsPanel.setBorder(BorderFactory.createEtchedBorder());
		resultsPanel.setBackground(Color.white);

		categoryPanel.add(middlePanel);
		categoryPanel.add(searchB);
		categoryPanel.add(resultsPanel);
		categoryPanel.setBackground(Color.white);

		return categoryPanel;
	}

	public JPanel addresultsPanel() {
		// Results Panel
		rPanel = new JPanel();
		rPanel.setLayout(new BoxLayout(rPanel, BoxLayout.PAGE_AXIS));

		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched,
				"Results Window");
		rPanel.setBorder(titled);

		details = new JTextArea(4, 30);
		JScrollPane scrollPane = new JScrollPane(details);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		rPanel.add(scrollPane);

		// Panel to hold buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 60)));

		clearB = new JButton("Clear");
		clearB.addActionListener(this);
		buttonPanel.add(clearB);
		buttonPanel.setBackground(Color.white);

		exitB = new JButton("Exit");
		exitB.addActionListener(this);
		buttonPanel.add(exitB);
		buttonPanel.setBackground(Color.white);

		rPanel.add(buttonPanel);
		rPanel.setBackground(Color.white);
		return rPanel;

	}

	public String getStringResults(ResultSet rset) {
		String r = "";

		try {
			while (rset.next()) {
				r += (rset.getInt(1) + " " + rset.getString(2) + " "
						+ rset.getDouble(3) + " " + rset.getString(4) + "\n");
			}
		} catch (SQLException qe) {
			System.out.println("SQL Exception - query did not work");
		}

		return r;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(searchB)) {
			String category = "";
			ButtonModel b = categoryGroup.getSelection();
			category = b.getActionCommand();
			//System.out.println(electronics.getText());
			//if (electronics.isSelected())
			//	category = "Electronics";
			//else if(furniture.isSelected())
			//	category = "Furniture";
			//else
			//	category = "Outdoor";
			ResultSet rset = ao.searchByCategory(category);
			String results = "";
			try {
				while (rset.next()) {
					results += (rset.getInt(1) + " " + rset.getString(2) + " "
							+ rset.getDouble(3) + " " + rset.getString(4) + "\n");
				}
				}catch(SQLException sqlE){
					System.out.println("Error in result set");
				}
			details.setText(results);

		} else if (e.getSource().equals(clearB)) {
			details.setText("");
		} else if (e.getSource().equals(exitB)) {
			System.exit(0);
		}
	}
}
