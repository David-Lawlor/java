package examplesItemListener;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExampleRadioButton extends JFrame implements ItemListener {
	private JLabel label;
	private JRadioButton plain, bold, italic, boldItalic;
	private Font font;

	public ExampleRadioButton() {
		super("RadioButton Example");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		font = new Font("TimesRoman", Font.PLAIN, 72);
		label = new JLabel("Text To Change");
		label.setFont(font);
		this.add(label);

		plain = new JRadioButton("Plain", true);
		bold = new JRadioButton("Bold");
		italic = new JRadioButton("Italics");
		boldItalic = new JRadioButton("Bold/Italic");

		plain.addItemListener(this);
		bold.addItemListener(this);
		italic.addItemListener(this);
		boldItalic.addItemListener(this);

		this.add(plain);
		this.add(bold);
		this.add(italic);
		this.add(boldItalic);

		ButtonGroup group = new ButtonGroup();
		group.add(plain);
		group.add(bold);
		group.add(italic);
		group.add(boldItalic);

		this.setSize(520, 200);
	}

	public void itemStateChanged(ItemEvent e) {
		int style;

		if (plain.isSelected())
			style = Font.PLAIN;
		else if (bold.isSelected())
			style = Font.BOLD;
		else if (italic.isSelected())
			style = Font.ITALIC;
		else
			style = Font.BOLD + Font.ITALIC;

		label.setFont(new Font("TimesRoman", style, 72));

	}
	public static void main(String args[]) {
		ExampleRadioButton rb = new ExampleRadioButton();
		rb.setVisible(true);
	}
}


