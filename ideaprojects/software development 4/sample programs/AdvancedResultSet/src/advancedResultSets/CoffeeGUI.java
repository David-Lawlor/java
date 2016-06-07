package advancedResultSets;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

/** class to setup GUI and allow user to browse through rows */
class CoffeeGUI extends JFrame implements ActionListener {
	// result set to browse
	private ResultSet data; // result set to browse
	private CoffeeOperations co;

	// fields corresponding to database columns
	private JTextField desc, prodNum, price;

	private JButton next, previous, exit, first, last, add, update, delete;
	private JFrame f;
	private JPanel p1, p2, p3;

	// constructor
	public CoffeeGUI(ResultSet data, CoffeeOperations co) {

		this.data = data;
		this.co = co;

		f = new JFrame("Coffee Database");
		f.setSize(900, 150);

		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));

		p1.add(new JLabel("Description:"));
		desc = new JTextField(20);
		desc.setEditable(false);
		desc.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                clearFields();
    			desc.setEditable(true);
    			prodNum.setEditable(true);
    			price.setEditable(true);
            }
        });
		p1.add(desc);

		p1.add(new JLabel("Product Number:"));
		prodNum = new JTextField(20);
		prodNum.setEditable(false);
		p1.add(prodNum);

		p1.add(new JLabel("Price:"));
		price = new JTextField(10);
		price.setEditable(false);
		price.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                price.setText("");
                price.setEditable(true);
            }
        });
		p1.add(price);

		f.add(p1, BorderLayout.NORTH);

		// panel with next and previous buttons

		p2 = new JPanel();
		p2.setLayout(new FlowLayout());

		first = new JButton("First");
		p2.add(first);
		first.addActionListener(this); // await button press

		previous = new JButton("Previous");
		p2.add(previous);
		previous.addActionListener(this); // await button press

		next = new JButton("Next");
		p2.add(next);
		next.addActionListener(this); // await button press

		last = new JButton("Last");
		p2.add(last);
		last.addActionListener(this); // await button press

		exit = new JButton("Exit");
		p2.add(exit);
		exit.addActionListener(this); // await button press

		f.add(p2, BorderLayout.CENTER);

		// panel with next and previous buttons

		p3 = new JPanel();
		p3.setLayout(new FlowLayout());

		add = new JButton("Add");
		p3.add(add);
		add.addActionListener(this); // await button press

		update = new JButton("Update Price");
		p3.add(update);
		update.addActionListener(this); // await button press

		delete = new JButton("Delete");
		p3.add(delete);
		delete.addActionListener(this); // await button press
		f.add(p3, BorderLayout.SOUTH);

		// go the first row
		try {
			data.first();
			setRow(); // set data for current row

		} catch (SQLException e) {
			System.out.println("No data " + e.toString());
			System.exit(1);
		}

		f.setVisible(true);
	}

	/** set the form fields = contents of current row in data result set */
	private void setRow() {
		try {
			desc.setText(data.getString(1));
			prodNum.setText(data.getString(2));
			price.setText(Double.toString(data.getDouble(3)));
		} catch (SQLException e1) {
			System.out.println("No data for row " + e1.toString());
			System.exit(1);
		}

	}
	
	private void setFirstRow() {
		try {
			data.first();
			desc.setText(data.getString(1));
			prodNum.setText(data.getString(2));
			price.setText(Double.toString(data.getDouble(3)));
		} catch (SQLException e1) {
			System.out.println("No data for row " + e1.toString());
			System.exit(1);
		}

	}

	public void clearFields() {
		desc.setText("");
		prodNum.setText("");
		price.setText("");
	}

	/** action listener for next and previous buttons */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(next)) // next button
		{
			try {
				if (data.next()) // go to next row in result set
				{
					setRow(); // update screen
				}
				/*
				 * if (data.isAfterLast()) // must be after last row {
				 * data.previous(); // move back }
				 */
			} catch (SQLException e1) {
				System.out.println("Error going to next row");
				System.exit(1);
			}
		}

		else if (e.getSource().equals(previous)) // previous hit
		{
			try {
				if (data.previous()) // go to previous row
				{
					setRow(); // update screen
				} else {
					if (data.isBeforeFirst()) {
						data.next(); // move on
					}
				}
			} catch (SQLException e2) {
				System.out.println("Error going to previous row");
				System.exit(1);
			}
		} else if (e.getSource().equals(first)) // previous hit
		{
			try {
				if (data.first()) // go to previous row
				{
					setRow(); // update screen
				} else // on row prior to data
				{
					if (data.isBeforeFirst()) {
						data.next(); // move on
					}
				}
			} catch (SQLException e2) {
				System.out.println("Error going to previous row");
				System.exit(1);
			}
		} else if (e.getSource().equals(last)) // previous hit
		{
			try {
				if (data.last()) // go to previous row
				{
					setRow(); // update screen
				} else // on row prior to data
				{
					if (data.isAfterLast()) {
						data.previous(); // move on
					}
				}
			} catch (SQLException e2) {
				System.out.println("Error going to previous row");
			}
		} else if (e.getSource().equals(add)) // previous hit
		{
			if ((desc.getText()!="") && (prodNum.getText()!="")
					&& (price.getText() != "")) {
				co.add(desc.getText(), prodNum.getText(),
						Double.parseDouble(price.getText()));
				data = co.queryDB();
				System.out.println("Got to here");
				setFirstRow();
			}

		}
		else if (e.getSource().equals(delete)) // previous hit
		{
				co.deleteRecord(prodNum.getText());
				data = co.queryDB();
				setFirstRow();
		}
		else if (e.getSource().equals(update)) // previous hit
		{
				co.updateRecord(prodNum.getText(),Double.parseDouble(price.getText()));
				price.setEditable(false);
				data = co.queryDB();
				setFirstRow();
		}
		else {
			co.closeDB();
			System.exit(0);

		}
	}
}
