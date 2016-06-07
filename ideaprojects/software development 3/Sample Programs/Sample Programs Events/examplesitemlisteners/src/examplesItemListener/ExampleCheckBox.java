package examplesItemListener;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExampleCheckBox extends JFrame implements ItemListener {
	private JLabel label;
	private JCheckBox bold, italic;
	private Font font;

	public ExampleCheckBox() {
		super("CheckBox Ex");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		font = new Font("TimesRoman", Font.PLAIN, 72);
		label = new JLabel("Text To Change");
		label.setFont(font);
		this.add(label);

		bold = new JCheckBox("Bold");
		this.add(bold);
		italic = new JCheckBox("Italics");
		this.add(italic);

		bold.addItemListener(this);
		italic.addItemListener(this);

		this.setSize(520, 200);

	}

	public void itemStateChanged(ItemEvent e) {
		Font font;

		if ((bold.isSelected()) && (italic.isSelected()))
			font = new Font("Serif", Font.BOLD + Font.ITALIC, 72);
		else if (bold.isSelected())
			font = new Font("Serif", Font.BOLD, 72);
		else if (italic.isSelected())
			font = new Font("Serif", Font.ITALIC, 72);
		else
			font = new Font("Serif", Font.PLAIN, 72);

		label.setFont(font);
	}

	public static void main(String args[]) {
		ExampleCheckBox cb = new ExampleCheckBox();
		cb.setVisible(true);
	}
}
