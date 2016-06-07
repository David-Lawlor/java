package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;

import db.AdvertOperations;

public class SearchbyKeywordGUI implements ActionListener {
	private JTextField keywordField;
	private ButtonGroup sortGroup;
	private JPanel searchPanel;
	private JPanel rPanel;
	private JTextArea details;
	private JButton exitB;
	private AdvertOperations ao;
	private JButton searchB, clearB;
	private JRadioButton ascending, descending;
	private String order;

	public SearchbyKeywordGUI(AdvertOperations ao) {
		this.ao = ao;
	}

	public JPanel addSearchPanel() {
		searchPanel = new JPanel();
		searchPanel.setLayout(new BorderLayout());

		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched,
				"Search by Keyword");

		searchPanel.setBorder(titled);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));

		topPanel.setBorder(BorderFactory.createEtchedBorder());
		topPanel.add(Box.createRigidArea(new Dimension(80, 0)));

		keywordField = new JTextField();
		keywordField.setMaximumSize(new Dimension(150, 20));
		JLabel searchLabel = new JLabel("Enter Keyword");
		topPanel.add(keywordField);
		topPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		topPanel.add(searchLabel);
		topPanel.setBackground(Color.white);

		JPanel middlePanel = new JPanel();
		middlePanel.setBorder(BorderFactory.createEtchedBorder());
		middlePanel.setBackground(Color.white);

		JPanel radioPanel = new JPanel();

		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.PAGE_AXIS));

		radioPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		radioPanel.setBackground(Color.white);

		ascending = new JRadioButton("Ascending", true);
		ascending.addActionListener(this);
		ascending.setBackground(Color.white);
		radioPanel.add(ascending);
		descending = new JRadioButton("Descending");
		descending.addActionListener(this);
		descending.setBackground(Color.white);
		radioPanel.add(descending);

		sortGroup = new ButtonGroup();
		sortGroup.add(ascending);
		sortGroup.add(descending);

		middlePanel.add(radioPanel);

		JPanel labelPanel = new JPanel();
		JLabel sortLabel = new JLabel("Sort Price", SwingConstants.LEFT);
		labelPanel.setBackground(Color.white);
		labelPanel.add(sortLabel);

		middlePanel.add(labelPanel);

		JLabel blankLabel = new JLabel("                       ");
		middlePanel.add(blankLabel);

		JPanel btnPanel = new JPanel(new FlowLayout());
		btnPanel.setBackground(Color.white);
		searchB = new JButton("Search");
		searchB.addActionListener(this);
		btnPanel.add(searchB);

		middlePanel.add(btnPanel);

		JPanel resultsPanel = addresultsPanel();
		resultsPanel.setBorder(BorderFactory.createEtchedBorder());
		resultsPanel.setBackground(Color.white);

		searchPanel.add(topPanel, BorderLayout.NORTH);
		searchPanel.add(middlePanel, BorderLayout.CENTER);
		searchPanel.add(resultsPanel, BorderLayout.SOUTH);

		searchPanel.setBackground(Color.white);

		return searchPanel;
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
		details.setText("Results");
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
		if (e.getSource().equals(searchB)) {
		/*Insert your code for Exercise 2 here*/
			String s = "Results: \n";
			try{
				if(ascending.isSelected())
					order = "ASC";
				else
					order = "DESC";
				ResultSet rset = ao.searchByKeyword(keywordField.getText(), order);
				while (rset.next()) {
					s += (rset.getInt(1) + "\t" + rset.getString(2) +  "\t" + rset.getDouble(3) +  "\t" +
							rset.getString(4) + "\n");
				}
				System.out.println(s);
			}catch (SQLException sqlE){
				System.out.println("Error in resultSet");
			}
			details.setText(s);
			
		}
		else if(e.getSource().equals(clearB)) {
			details.setText("");
		}
		else if(e.getSource().equals(exitB)) {
			System.exit(0);
		}
		}
	}

