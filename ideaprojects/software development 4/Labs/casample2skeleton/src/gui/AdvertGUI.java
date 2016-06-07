package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;

import db.AdvertOperations;

public class AdvertGUI extends JFrame implements ActionListener {
	private JButton displayB;
	private JButton searchB, searchC;
	private JButton clearB;
	private JButton exitB;
	private JButton addB;

	private JPanel northPanel;
	private JPanel cPanel;
	private JPanel rPanel;
	private JPanel resultsPanel;

	private AdvertOperations ao;
	private ResultSet rset;
	private JTextArea details;
	private JFrame f;
	private boolean displayarea = false;

	// The variable below holds the current centre panel
	// Could be a resultsPanel or and addPanel
	private static JPanel currentdisplayPanel;

	public AdvertGUI(AdvertOperations ao) {
		this.ao = ao;
		f = new JFrame();
		f.setTitle("Buy & Sell");
		f.setLayout(new BorderLayout());
		f.setSize(700, 400);
		f.setResizable(false);
		f.setLocationRelativeTo(null);

		northPanel = new JPanel();
		Icon tvIcon = new ImageIcon("imgs/tv.jpg");
		JLabel northLabel = new JLabel(" Place Your Ad here", tvIcon,
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

		displayB = new JButton("Display Adverts");
		displayB.addActionListener(this);
		cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		displayB.setMaximumSize(new Dimension(250, 25));
		cPanel.add(displayB);

		searchB = new JButton("Search for Advert by Keyword");
		searchB.addActionListener(this);
		cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		searchB.setMaximumSize(new Dimension(250, 25));
		cPanel.add(searchB);

		searchC = new JButton("Search for Advert by Catergory");
		searchC.addActionListener(this);
		cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		searchC.setMaximumSize(new Dimension(250, 25));
		cPanel.add(searchC);

		addB = new JButton("Place an Ad");
		addB.addActionListener(this);
		cPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		addB.setMaximumSize(new Dimension(250, 25));
		cPanel.add(addB);

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
            ao.closeDB();
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
			/*Insert code for Exercise 1 here*/
			String s = "";
			try {
				rset = ao.getAdverts();
				while (rset.next()) {
					s += (rset.getInt(1) + "\t" + rset.getString(2) +  "\t" + rset.getDouble(3) +  "\t" +
							rset.getString(4) + "\n");
				}
				System.out.println(s);
			}catch (SQLException sqlE){
				System.out.println("Error in resultSet");
			}
			details.setText(s);
		
		} else if (e.getSource().equals(searchB)) {
			SearchbyKeywordGUI sa = new SearchbyKeywordGUI(ao);
			resultsPanel = sa.addSearchPanel();
			f.add(resultsPanel, BorderLayout.CENTER);
			f.setVisible(true);

			if (displayarea)
				currentdisplayPanel.removeAll();

			displayarea = true;
			currentdisplayPanel = resultsPanel;

		} else if (e.getSource().equals(searchC)) {
			SearchbyCategoryGUI sc = new SearchbyCategoryGUI(ao);
			resultsPanel = sc.addSearchCatPanel();
			f.add(resultsPanel, BorderLayout.CENTER);
			f.setVisible(true);

			if (displayarea)
				currentdisplayPanel.removeAll();

			displayarea = true;
			currentdisplayPanel = resultsPanel;
		} else if (e.getSource().equals(addB)) {
			addAdvertGUI ag = new addAdvertGUI(ao);
			resultsPanel = ag.addPlaceAdPanel();
			f.add(resultsPanel, BorderLayout.CENTER);
			f.setVisible(true);

			if (displayarea) {
				currentdisplayPanel.removeAll();
				displayarea = true;
				currentdisplayPanel = resultsPanel;
			}

		}
	}
}
