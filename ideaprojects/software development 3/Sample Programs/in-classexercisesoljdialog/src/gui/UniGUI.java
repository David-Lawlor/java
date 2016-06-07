package gui;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UniGUI {

	private static final int FRAME_WIDTH = 390;
	private static final int FRAME_HEIGHT = 200;
    private JButton left, right, add, delete, update, exit;
	private JTextField name, id, num;
    // This class needs access to the university object which is declared here and initialised
    // in the constructor below
	private University theUni;
	private int counter = 0;
	// This frame represents the main window of the application
	private JFrame frame;

	public UniGUI(University u) {
		frame = new JFrame();
		frame.setTitle("University Application");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // university reference variable is initialised using u which is passed in
        // to the constructor as a parameter
		theUni = u;

		// Panel 1 - top
		JPanel top = new JPanel(new GridLayout(4, 2));
		frame.add(top, BorderLayout.NORTH);
		top.add(new JLabel("University Name"));
		top.add(new JTextField(u.getuName()));
		top.add(new JLabel("President"));
		top.add(new JTextField(u.getPresident()));
		top.add(new JLabel("Location"));
		top.add(new JTextField(u.getLocation()));
		top.add(new JLabel("Number Departments"));
		num = new JTextField("" + u.getNumDept());
		top.add(num);

		// Panel - middle
		JPanel middle = new JPanel(new GridLayout(2, 2));
		middle.add(new Label("Department Name"));
		name = new JTextField();
		middle.add(name);
		middle.add(new Label("Department ID"));
		id = new JTextField();
		middle.add(id);
		frame.add(middle, BorderLayout.CENTER);

		// Panel - bottom
		JPanel bottom = new JPanel(new FlowLayout());
		frame.add(bottom, BorderLayout.SOUTH);

		left = new JButton("<");
		left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((counter - 1) >= 0) {
                    counter--;
                    name.setText(theUni.getDept(counter).getDeptName());
                    id.setText(Integer.toString(theUni.getDept(counter).getDeptid()));
                }
            }
        });
        bottom.add(left);

		right = new JButton(">");
		right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((counter + 1) < theUni.getNumDept()) {
                    counter++;
                    name.setText(theUni.getDept(counter).getDeptName());
                    id.setText(Integer.toString(theUni.getDept(counter).getDeptid()));
                }
            }
        });
        bottom.add(right);

		add = new JButton("Add");
		add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddGUI a = new AddGUI(frame, theUni);
                setFirst();
            }
        });
		bottom.add(add);

		update = new JButton("Update");
		update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDep();
                setFirst();
            }
        });
		bottom.add(update);

		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDep();
                setFirst();
            }
        });
		bottom.add(delete);

		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		bottom.add(exit);

		frame.setVisible(true);
		setFirst();

	}

	public void setFirst() {
		counter = 0;
		if (theUni.getNumDept() > 0) {
            name.setText(theUni.getDept(counter).getDeptName());
            id.setText(Integer.toString(theUni.getDept(counter).getDeptid()));
		}
		num.setText(Integer.toString(theUni.getNumDept()));

	}

	public void deleteDep() {
		{
			String b = "";

			while (b==null || theUni.findDep(b) == -1) {
				b = JOptionPane.showInputDialog(null,
						"Enter the name of department you wish to delete: ",
						"University", JOptionPane.QUESTION_MESSAGE);
			}
			int numberOfDeleted = theUni.removeDep(b);
			JOptionPane.showMessageDialog(null, numberOfDeleted
					+ " Record(s) deleted.");
		}
	}

	public void updateDep() {

		String d = "", nd = "";

		while (d.equals("") || theUni.findDep(d) == -1) {
			d = JOptionPane.showInputDialog(null,
					"Enter the name of department you wish to update: ",
					"University", JOptionPane.QUESTION_MESSAGE);
		}

		while (nd.equals("") || (Department.isNumber(nd))) {
			nd = JOptionPane.showInputDialog(null,
					"Enter the new name of the department: ", "University",
					JOptionPane.QUESTION_MESSAGE);
		}
		theUni.changedeptname(d, nd);
	}
}
