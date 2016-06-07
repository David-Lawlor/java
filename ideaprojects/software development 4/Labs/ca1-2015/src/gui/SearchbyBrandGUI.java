package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;

import db.ProductOperations;

public class SearchbyBrandGUI implements ActionListener{

	private JPanel brandPanel;
	private JPanel rPanel;
	private JTextArea details;
	private JButton exitB;
    private JRadioButton acer, lenovo, hp;
    private ButtonGroup categoryGroup;
	private ProductOperations po;
	private JButton searchB, clearB;


	public SearchbyBrandGUI(ProductOperations po) {
		this.po = po;
	}

    public JPanel addSearchBrandPanel() {
        brandPanel = new JPanel();
        brandPanel.setLayout(new FlowLayout());

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched,
                "Search by Brand");

        brandPanel.setBorder(titled);

        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(BorderFactory.createEtchedBorder());
        middlePanel.setBackground(Color.white);


        acer = new JRadioButton("Acer", true);
        acer.setBackground(Color.white);
        acer.addActionListener(this);
        middlePanel.add(acer);


        lenovo = new JRadioButton("Lenovo", true);
        lenovo.setBackground(Color.white);
        lenovo.addActionListener(this);
        middlePanel.add(lenovo);


        hp = new JRadioButton("HP", true);
        hp.setBackground(Color.white);
        hp.addActionListener(this);
        middlePanel.add(hp);

        categoryGroup = new ButtonGroup();
        categoryGroup.add(acer);
        categoryGroup.add(lenovo);
        categoryGroup.add(hp);

        searchB = new JButton("Search");
        searchB.addActionListener(this);

        JPanel resultsPanel = addresultsPanel();
        resultsPanel.setBorder(BorderFactory.createEtchedBorder());
        resultsPanel.setBackground(Color.white);

        brandPanel.add(middlePanel);
        brandPanel.add(searchB);
        brandPanel.add(resultsPanel);
        brandPanel.setBackground(Color.white);

        return brandPanel;
    }
	public JPanel addresultsPanel() {
		// Results Panel
		rPanel = new JPanel();
		rPanel.setLayout(new BoxLayout(rPanel, BoxLayout.PAGE_AXIS));

		Border etched = BorderFactory.createEtchedBorder();
		Border titled = BorderFactory.createTitledBorder(etched,
				"Results Window");
		rPanel.setBorder(titled);

		details = new JTextArea(6, 35);
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

       if (e.getSource().equals(searchB)) {

           // Insert code for Exercise 2 here
		   String brand ="";
		   if (acer.isSelected())
			   brand = acer.getText();
		   else if(lenovo.isSelected())
			   brand = lenovo.getText();
		   else if(hp.isSelected())
			   brand = hp.getText();
		   ResultSet rset = po.searchByBrand(brand);
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






        }
		else if(e.getSource().equals(clearB)) {
			details.setText("");
		}
		else if(e.getSource().equals(exitB)) {
           po.closeDB();
		   System.exit(0);
		}
		}
}

