package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;

import db.ShopOperations;

public class
		ShopGUI extends JFrame implements ActionListener {
	private JButton displayB;
	private JButton checkB;
	private JButton searchB;
	private JButton clearB;
	private JButton exitB;
	private JButton prodB;

	private JPanel northPanel;
	private JPanel cPanel;
	private JPanel rPanel;
	private JPanel addPanel;
	private JPanel resultsPanel;

	private ShopOperations so;
	private ResultSet rset;
	private JTextArea details;
	private JFrame f;
	private boolean displayarea = false;

	// The variable below holds the current centre panel
	// Could be a resultsPanel or and addPanel
	private static JPanel currentdisplayPanel;

	public ShopGUI(ShopOperations so) {
		this.so = so;
		f = new JFrame();
		f.setTitle("TV Shop");
		f.setLayout(new BorderLayout());
		f.setSize(700, 400);
		f.setResizable(false);
		f.setLocationRelativeTo(null);

		northPanel = new JPanel();
		Icon tvIcon = new ImageIcon("imgs/tv.jpg");
		JLabel northLabel = new JLabel(" Welcome to the TV Shop", tvIcon,
				SwingConstants.CENTER);
		northLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		northPanel.setBackground(Color.white);
		northPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		northPanel.add(northLabel);
		f.add(northPanel, BorderLayout.NORTH);

		// Choices Panel on left hand side of main screen
		cPanel = new JPanel();
		cPanel.setSize(350, 100);
		cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.Y_AXIS));
		cPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));

		displayB = new JButton("Display Products");
		displayB.addActionListener(this);
		cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		displayB.setMaximumSize(new Dimension(250, 25));
		cPanel.add(displayB);

		searchB = new JButton("Search for TV by Manufacturer");
		searchB.addActionListener(this);
		cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		searchB.setMaximumSize(new Dimension(250, 25));
		cPanel.add(searchB);

		checkB = new JButton("Check Stock Levels");
		checkB.addActionListener(this);
		cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		checkB.setMaximumSize(new Dimension(250, 25));
		cPanel.add(checkB);

		prodB = new JButton("Add Product");
		prodB.addActionListener(this);
		cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		prodB.setMaximumSize(new Dimension(250, 25));
		cPanel.add(prodB);

		cPanel.setBackground(Color.white);
		cPanel.setMaximumSize(new Dimension(300, 50));
		setSize(350, 100);

		cPanel.setBackground(Color.white);

		f.add(cPanel, BorderLayout.WEST);

		JPanel blankPanel = new JPanel();
		f.add(blankPanel, BorderLayout.CENTER);
		blankPanel.setBackground(Color.white);

		f.setBackground(Color.white);
		f.setVisible(true);
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exitB)) {
			System.exit(0);
		} else if (e.getSource().equals(clearB)) {

			details.setText("");
		} else if (e.getSource().equals(displayB)) {
			resultsPanel = addresultsPanel();
			f.add(resultsPanel, BorderLayout.CENTER);
			f.setVisible(true);

			if (displayarea)
				currentdisplayPanel.removeAll();
			displayarea = true;
			currentdisplayPanel = resultsPanel;



			// Exercise 1
			// Insert code here to call on a database method to
			// retrieve all records from the products table
			// The results should then be displayed in the text area
			// on the screen
			String results1 = "";
			try {
				rset = so.getProducts();
				while (rset.next()) {
					results1 += (rset.getInt(1) + "\t"
							 + rset.getString(2) + "\t"
							 + rset.getInt(3) + "\t"
							 + rset.getDouble(4) + "\t"
							 + + rset.getInt(5) + "\t"
							 + "\n");
				}
			}catch(SQLException sqlE){
				System.out.println(sqlE);
			}
			details.setText(results1);

		} else if (e.getSource().equals(searchB)) {
			String r = "";
			String b = JOptionPane.showInputDialog(null,
					"Enter the manufacturer of tv you wish to search for: ",
					"TV Shop", JOptionPane.QUESTION_MESSAGE);

			resultsPanel = addresultsPanel();
			f.add(resultsPanel, BorderLayout.CENTER);
			f.setVisible(true);

			if (displayarea)
				currentdisplayPanel.removeAll();

			displayarea = true;
			currentdisplayPanel = resultsPanel;

			// Exercise 2
			// Insert code here to call on a database method to
			// retrieve all matching records from the products table
			// The results should then be displayed in the textarea
			// on the screen

			String results2 ="";
			rset = so.manuSearch(b);
			try {
				while (rset.next()) {
					results2 += (rset.getInt(1) + "\t"
							 + rset.getString(2) + "\t"
							 + rset.getInt(3) + "\t"
							 + rset.getDouble(4) + "\t"
							 + rset.getInt(5) + "\t"
							 + "\n");
				}
			}catch (SQLException sqlE){
				System.out.println(sqlE);
			}
			details.setText(results2);
			

		} else if (e.getSource().equals(checkB)) {

			resultsPanel = addresultsPanel();
			f.add(resultsPanel, BorderLayout.CENTER);
			f.setVisible(true);
			if (displayarea)
				currentdisplayPanel.removeAll();
			displayarea = true;
			currentdisplayPanel = resultsPanel;

			// Exercise 3
			// Call on a database method to
			// retrieve all matching records from the products table
			// where stock levels are below 10
			// The results should then be displayed in the textarea
			// on the screen

			String results3 = "";
			rset = so.checkLevels();
			try {
				while (rset.next()){
					results3 += (rset.getInt(1) + "\t"
							+ rset.getString(2) + "\t"
							+ rset.getInt(3) + "\t"
							+ rset.getDouble(4) + "\t"
							+ rset.getInt(5) + "\t"
							+ "\n");
				}
			}catch(SQLException sqlE){
				System.out.println(sqlE);
			}

			details.setText(results3);


		} else if (e.getSource().equals(prodB)) {
			addProductsGUI ag = new addProductsGUI(so);
			addPanel = ag.addProductsPanel();
			f.add(addPanel, BorderLayout.CENTER);
			f.setVisible(true);

			if (displayarea) {
				currentdisplayPanel.removeAll();
				displayarea = true;
				currentdisplayPanel = addPanel;
			}
		}
	}
}
