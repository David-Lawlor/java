package examplesPanels;

import javax.swing.*;
import java.awt.*;

public class ManyPanelsEx extends JFrame {
	private Container c;

	// Twelve buttons
	private JButton button01 = new JButton("One");
	private JButton button02 = new JButton("Two");
	private JButton button03 = new JButton("Three");
	private JButton button04 = new JButton("Four");
	private JButton button05 = new JButton("Five");
	private JButton button06 = new JButton("Six");
	private JButton button07 = new JButton("Seven");
	private JButton button08 = new JButton("Eight");
	private JButton button09 = new JButton("Nine");
	private JButton button10 = new JButton("Ten");
	private JButton button11 = new JButton("Eleven");
	private JButton button12 = new JButton("Twelve");

	// Four panels
	private JPanel panel01 = new JPanel(new GridLayout(2, 0));
	private JPanel panel02 = new JPanel(new FlowLayout());
	private JPanel panel03 = new JPanel(new FlowLayout());
	private JPanel panel04 = new JPanel(new GridLayout(2, 0));

	public ManyPanelsEx() {
		c = getContentPane();
		c.setBackground(Color.GREEN);
		setLayout(new BorderLayout());

		this.add(panel01, BorderLayout.WEST);
		this.add(panel02, BorderLayout.CENTER);
		this.add(panel03, BorderLayout.SOUTH);
		this.add(panel04, BorderLayout.EAST);

		panel01.add(button01);
		panel01.add(button02);
		panel01.add(button03);
		panel01.setBackground(Color.BLUE);

		panel02.add(button04);
		panel02.add(button05);
		panel02.add(button06);
		panel02.setBackground(Color.PINK);

		panel03.add(button07);
		panel03.setBackground(Color.YELLOW);

		panel04.add(button08);
		panel04.add(button09);
		panel04.add(button10);
		panel04.add(button11);
		panel04.add(button12);
		panel04.setBackground(Color.ORANGE);

		this.setSize(400, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ManyPanelsEx frame = new ManyPanelsEx();
		frame.setVisible(true);
	}
}


