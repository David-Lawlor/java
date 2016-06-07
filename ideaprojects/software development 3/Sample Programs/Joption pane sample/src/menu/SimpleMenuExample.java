package menu;

import javax.swing.*;
import java.awt.*;

public class SimpleMenuExample extends JFrame {
	private JMenuBar bar = new JMenuBar();

	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");

	private JMenuItem open = new JMenuItem("Open");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem cut = new JMenuItem("Cut");
	private JMenuItem paste = new JMenuItem("Paste");

	private Container cPane = this.getContentPane();

	public SimpleMenuExample() {

		this.setSize(500, 300);
		this.setTitle("Menus");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		cPane.setBackground(Color.blue);

		file.add(open);
		file.add(save);
		edit.add(cut);
		edit.add(paste);

		this.setJMenuBar(bar);

		bar.add(file);
		bar.add(edit);
	}

	public static void main(String args[]) {
		SimpleMenuExample menu = new SimpleMenuExample();
		menu.setVisible(true);
	}
}
