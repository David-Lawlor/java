package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;

import db.ProductOperations;

public class SearchbyCategoryGUI implements ActionListener {

	private JPanel categoryPanel, rPanel;
	private JTextArea details;
	private JButton exitB, searchB, clearB;
	private JCheckBox laptops, desktops, tablets;
	private ProductOperations po;

	public SearchbyCategoryGUI(ProductOperations po) {
		this.po = po;
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


		laptops = new JCheckBox("Laptops",false);
		laptops.setBackground(Color.white);
		laptops.addActionListener(this);
		middlePanel.add(laptops);


		desktops = new JCheckBox("Desktops",false);
        desktops.setBackground(Color.white);
        desktops.addActionListener(this);
		middlePanel.add(desktops);


		tablets = new JCheckBox("Tablets",false);
        tablets.setBackground(Color.white);
        tablets.addActionListener(this);
		middlePanel.add(tablets);

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

		details = new JTextArea(11, 35);
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
				r += rset.getInt(1) +"  " + rset.getString(2)+" "+rset.getString(3)+" "+rset.getDouble(4) +" "+
                        +rset.getInt(5) +" " + rset.getString(6)+" "+rset.getString(7)+"\n";
			}
		} catch (SQLException qe) {
			System.out.println("SQL Exception - query did not work");
		}

		return r;
	}

	public void actionPerformed(ActionEvent e) {
		String category = "";
		if (e.getSource().equals(searchB)) {

        // Insert code for Exercise 3 here
			ResultSet rset;
			String brand1 =" ";
			String brand2 =" ";
			Boolean all = false;

			if(laptops.isSelected() && desktops.isSelected()&& tablets.isSelected())
				all = true;

			else if (laptops.isSelected()) {
				brand1 = laptops.getText();
				if(desktops.isSelected())
					brand2 = desktops.getText();
				else if(tablets.isSelected())
					brand2 = tablets.getText();

			}

			else if(desktops.isSelected()) {
				brand1 = desktops.getText();
				if(tablets.isSelected())
					brand2 = tablets.getText();

			}
			else if(tablets.isSelected()) {
				brand1 = tablets.getText();

			}

			if(all){
				rset = po.getProducts();
			}
			else if(brand2 == " ")
				rset = po.searchByCategory(brand1);
			else
				rset = po.searchByCategory(brand1, brand2);

			String results = "";
			try {
				while (rset.next()) {
					results += rset.getInt(1) +"  " + rset.getString(2)+" "+rset.getString(3)+" "+rset.getDouble(4) +" "+
							+rset.getInt(5) +" " + rset.getString(6)+" "+rset.getString(7)+"\n";
				}
			}catch(SQLException sqlE){
				System.out.println("Error in result set");
			}
			details.setText(results);




		} else if (e.getSource().equals(clearB)) {
			details.setText("");
		} else if (e.getSource().equals(exitB)) {
            po.closeDB();
			System.exit(0);
		}
	}


}
