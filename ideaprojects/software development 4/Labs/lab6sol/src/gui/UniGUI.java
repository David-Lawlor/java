package gui;

import db.UniOperations;
import model.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UniGUI extends JFrame implements ActionListener, ItemListener {

	private static final int FRAME_WIDTH = 390;
	private static final int FRAME_HEIGHT = 300;
	private JButton left, right, add, update, delete, exit;
	private JTextField name, id, pres, loc, num;
	private JComboBox<String> combo;
	private ArrayList<University> theUniList = new ArrayList<University>();
    private UniOperations uo;
	private int counter = 0;
	private JFrame parent;

	public UniGUI(ArrayList<University> u, UniOperations uo) {

		parent = new JFrame("University Application");
		theUniList = u;
        this.uo=uo;
        System.out.println("Size is"+u.size());

		parent.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		parent.setTitle("Mortgage Application");
		// Position the frame in the centre of the screen
		parent.setLocationRelativeTo(null);
		parent.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Panel 1 - top
		JPanel top = new JPanel(new GridLayout(4, 2));
		parent.add(top, BorderLayout.NORTH);
		top.add(new JLabel("University Name"));

		// ComboBox
		combo = new JComboBox<String>();
		combo.setBounds(20, 35, 260, 20);
		top.add(combo);
		// Populate the combobox list
		for (int iCtr = 0; iCtr< theUniList.size(); iCtr++)
			combo.addItem(theUniList.get(iCtr).getuName());
		// Allow edits
		combo.setEditable(true);
		// Watch for changes
		combo.addItemListener(this);

		top.add(new JLabel("President"));
		pres = new JTextField(theUniList.get(0).getPresident());
		top.add(pres);
		top.add(new JLabel("Location"));
		loc = new JTextField(theUniList.get(0).getLocation());
		top.add(loc);
		top.add(new JLabel("Number Departments"));
		num = new JTextField(Integer.toString(theUniList.get(0).getNumDept()));
		top.add(num);

		// Panel - middle
		JPanel middle = new JPanel(new GridLayout(2, 2));
		middle.add(new Label("Department Name"));
		name = new JTextField();
		middle.add(name);
		middle.add(new Label("Department ID"));
		id = new JTextField();
		middle.add(id);
		parent.add(middle, BorderLayout.CENTER);

		// Panel - bottom
		JPanel bottom = new JPanel(new FlowLayout());
		parent.add(bottom, BorderLayout.SOUTH);

		left = new JButton("<");
		left.addActionListener(this);
		bottom.add(left);

		right = new JButton(">");
		right.addActionListener(this);
		bottom.add(right);

		add = new JButton("Add");
		add.addActionListener(this);
		bottom.add(add);

		update = new JButton("Update");
		update.addActionListener(this);
		bottom.add(update);

		delete = new JButton("Delete");
		delete.addActionListener(this);
		bottom.add(delete);

		exit = new JButton("Exit");
		exit.addActionListener(this);
		bottom.add(exit);

		setFirst();
		parent.setVisible(true);

	}

	public void setFirst() {
		counter = 0;
		if (theUniList.get(counter).getNumDept() > 0) {
			displayDep(theUniList.get(counter).getDept(counter));
		}
	}

	public void setFirst(String n) {
		counter = 0;

		for (int i = 0; i < theUniList.size(); i++) {
			if (theUniList.get(i).getuName().equals(n)) {
				if (theUniList.get(i).getNumDept() > 0) {
					this.displayDep(theUniList.get(i).getDept(counter));
					num.setText(Integer
							.toString(theUniList.get(i).getNumDept()));
				}
			}
		}

	}

	public void displayDep(Department d) {
		name.setText(d.getDeptName());
        System.out.println(d.getDeptName());
        System.out.println(d.getDeptid());
		id.setText("" + d.getDeptid());
	}

	// deleteDep Method

	public void deleteDep() {
		String b = "";
		int cnt = 0;

		for (int i = 0; i < theUniList.size(); i++) {
			if (theUniList.get(i).getuName().equals(combo.getSelectedItem())) {
				cnt = i;
			}
		}

        try {
            if (b == null || theUniList.get(cnt).findDep(b) == -1) {
                b = JOptionPane.showInputDialog(null,
                        "Enter the name of department you wish to delete: ",
                        "University", JOptionPane.QUESTION_MESSAGE);
            }
                uo.deleteContact(b, (String) combo.getSelectedItem());
                int numDeleted = theUniList.get(cnt).removeDep(b);
                JOptionPane.showMessageDialog(null, numDeleted + " Record(s) deleted");

                setFirst(combo.getSelectedItem().toString());

        }
        catch (NullPointerException np)
        {

        }
	}

	// updateDep Method

	public void updateDep() {

		String d = "";
		String nd = "";
		int cnt = 0;

		for (int i = 0; i < theUniList.size(); i++) {
			if (theUniList.get(i).getuName().equals(combo.getSelectedItem())) {
				cnt = i;
			}
		}
        try {
            if (d == null || theUniList.get(cnt).findDep(d) == -1) {
                d = JOptionPane.showInputDialog(null,
                        "Enter the name of department you wish to update",
                        "University", JOptionPane.QUESTION_MESSAGE);
            }

                if (nd.equals("") || (Department.isNumber(nd))) {
                    nd = JOptionPane.showInputDialog(null,
                            "Enter the new name of the department:", "University",
                            JOptionPane.QUESTION_MESSAGE);
                }

        }
        catch (NullPointerException np)
        {}
        uo.updateDep(d,nd,(String) combo.getSelectedItem());
        theUniList.get(cnt).changedeptname(d, nd);

		setFirst(combo.getSelectedItem().toString());

	}

	public void itemStateChanged(ItemEvent ie) {
		if (ie.getSource() == combo
				&& ie.getStateChange() == ItemEvent.SELECTED) {
			for (int i = 0; i < theUniList.size(); i++) {
				if (theUniList.get(i).getuName()
						.equals(combo.getSelectedItem())) {
					pres.setText(theUniList.get(i).getPresident());
					loc.setText(theUniList.get(i).getLocation());

				}
				setFirst(combo.getSelectedItem().toString());
			}
		}
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == right) {
			for (int i = 0; i < theUniList.size(); i++) {
				if (theUniList.get(i).getuName()
						.equals(combo.getSelectedItem())) {
					if ((counter + 1) < theUniList.get(i).getNumDept()) {
						counter++;
						this.displayDep(theUniList.get(i).getDept(counter));
					}
				}

			}

		} else if (ae.getSource() == left) {
			for (int i = 0; i < theUniList.size(); i++) {
				if (theUniList.get(i).getuName()
						.equals(combo.getSelectedItem())) {
					if ((counter - 1) >= 0) {
						counter--;
						this.displayDep(theUniList.get(i).getDept(counter));
					}
				}
			}

		} else if (ae.getSource() == add) {
			for (int i = 0; i < theUniList.size(); i++) {
				if (theUniList.get(i).getuName()
						.equals(combo.getSelectedItem())) {
					AddGUI a = new AddGUI(parent, theUniList.get(i),uo, (String) combo.getSelectedItem());
					num.setText(Integer.toString(theUniList.get(i).getNumDept()));
				}
			}

			setFirst();
		} else if (ae.getSource() == update) {
			updateDep();

		} else if (ae.getSource() == delete) {
			deleteDep();

		} else {
			System.exit(0);
            uo.closeDB();
		}
	}
}
