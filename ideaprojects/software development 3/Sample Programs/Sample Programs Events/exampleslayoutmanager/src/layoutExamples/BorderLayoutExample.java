package layoutExamples;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 250;
	private static final int FRAME_X_ORIGIN = 150;
	private static final int FRAME_Y_ORIGIN = 250;

	private JButton button1, button2, button3, button4, button5;
	private Container cPane;

	public BorderLayoutExample() {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(true);
		this.setTitle("Testing Border Layout Manager");
		this.setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		cPane = this.getContentPane();
		cPane.setBackground(Color.white);

		this.setLayout(new BorderLayout());

		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");
		button4 = new JButton("Button 4");
		button5 = new JButton("Button 5");

		this.add(button1, BorderLayout.NORTH);
		this.add(button2, BorderLayout.SOUTH);
		this.add(button3, BorderLayout.EAST);
		this.add(button4, BorderLayout.WEST);
		this.add(button5, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		BorderLayoutExample bld = new BorderLayoutExample();
		bld.setVisible(true);
	}
}
