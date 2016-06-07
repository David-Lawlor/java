package layoutExamples;

import java.awt.*;
import javax.swing.*;

public class GridLayoutExample extends JFrame {
	private GridLayout layout;
	private JButton[] button;

	public GridLayoutExample() {
		super("GridLayout");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layout = new GridLayout(2, 3); // 2 rows, 3 columns
		this.setLayout(layout);
		button = new JButton[6];
		this.setSize(300, 200);

		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton("Button " + i);
			add(button[i]);
		}

	}

	public static void main(String args[]) {
		GridLayoutExample g = new GridLayoutExample();
		g.setVisible(true);
	}
}
